package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.exemplo.model.Aluno;
import br.com.exemplo.util.ConnectionFactory;

public class AlunoDAO {
    private Aluno aluno;
    private Connection connection; // Conecta com o banco de dados
    private PreparedStatement preparedStatement; // deixa rodar querys
    private ResultSet resultSet; // seria a tabela ou o retorno da query

    public AlunoDAO() throws Exception{
        try{
            this.connection = ConnectionFactory.getConnection();
        } catch (Exception e){
            throw new Exception(">> ERRO ->" + e.getMessage());
        }
    }

    public void salvar(Aluno aluno) throws Exception{
        try{
            String sql = "INSERT INTO aluno(nome , sobrenome , rgm , cpf, data_nascimento, email, celular , endereco, municipio, uf, genero)" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            // passa a query para executar no banco de dados
            preparedStatement = connection.prepareStatement(sql);
            // passando do tipo de Date do java.util para o tipo de Date do java.sql, que é o que o banco de dados aceita
            java.sql.Date dataNascimento = new java.sql.Date(aluno.getDataNascimento().getTime());

            // passando os valores do codigo, nome, e tipo para os (?, ?, ?) da query
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setString(2, aluno.getSobrenome()); 
            preparedStatement.setString(3, aluno.getRgm());
            preparedStatement.setString(4, aluno.getCpf());
            preparedStatement.setDate(5, dataNascimento);
            preparedStatement.setString(6, aluno.getEmail());
            preparedStatement.setString(7, aluno.getNumeroCelular());
            preparedStatement.setString(8, aluno.getEndereco());
            preparedStatement.setString(9, aluno.getMunicipio());
            preparedStatement.setString(10, aluno.getUf());
            preparedStatement.setString(11, aluno.getGenero()); 

            // executando a query no banco
            preparedStatement.executeUpdate();
        } catch (Exception e){
            throw new Exception(">> ERRO AO SALVAR ->" + e.getMessage());
        }
    }

    public void salvarCurso(Aluno aluno) throws Exception{
        try{
            String sql = "UPDATE aluno SET curso_id = ?, periodo = ? WHERE rgm = ?";
            // passa a query para executar no banco de dados
            preparedStatement = connection.prepareStatement(sql);

            // passando os valores do codigo, nome, e tipo para os (?, ?, ?) da query
            preparedStatement.setInt(1, aluno.getCurso_id());
            preparedStatement.setString(2, aluno.getPeriodo()); 
            preparedStatement.setString(3, aluno.getRgm());

            // executando a query no banco
            preparedStatement.executeUpdate();
            
            // Deixa o aluno com 0 em notas e faltas por padrão para poder alterar com mais facilidade
            String[] semestres = {"2025-1", "2025-2", "2026-1", "2026-2"};
            String sqlNotas = "INSERT INTO nota (aluno_id, disciplina_id, semestre, nota, faltas) " +
                              "SELECT a.id, d.id, ?, 0, 0 " +
                              "FROM aluno a, disciplina d " +
                              "WHERE a.rgm = ? AND d.curso_id = ?";

            for (String semestre : semestres) {
                preparedStatement = connection.prepareStatement(sqlNotas);
                preparedStatement.setString(1, semestre);
                preparedStatement.setString(2, aluno.getRgm());
                preparedStatement.setInt(3, aluno.getCurso_id());
                preparedStatement.executeUpdate();
            }
            
        } catch (Exception e){
            throw new Exception(">> ERRO AO SALVAR ->" + e.getMessage());
        }
    }
    
    public List listar() throws Exception{
        List<Aluno> lista = new ArrayList<Aluno>();
        String sql = "SELECT aluno.*, curso.nome AS nome_curso " + "FROM aluno " + "INNER JOIN curso ON aluno.curso_id = curso.id";
        try{
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                // pegando os do banco de dados e passando para as variaveis
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                String rgm = resultSet.getString("rgm");
                String cpf = resultSet.getString("cpf");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                String email = resultSet.getString("email");
                String numeroCelular = resultSet.getString("celular");
                String endereco =  resultSet.getString("endereco");
                int curso = resultSet.getInt("curso_id");
                String nomeCurso = resultSet.getString("nome_curso");
                String municipio = resultSet.getString("municipio");
                String uf = resultSet.getString("uf");
                String genero = resultSet.getString("genero");
                String periodo = resultSet.getString("Periodo");


                lista.add(new Aluno(rgm,nome,sobrenome,curso,cpf,numeroCelular,email,dataNascimento,endereco,municipio,uf,genero,periodo,nomeCurso));
            }
            return lista;
        } catch (Exception e){
            throw new Exception(">> ERRO AO LISTAR DADOS->" + e.getMessage());
        }
    }

    public void atualizar(Aluno aluno)throws Exception{
        try{
            String sql = "UPDATE aluno SET nome=?, sobrenome=?, cpf=?, data_nascimento=?, email=?, celular=?, endereco=?, municipio=?, uf=?, genero=? WHERE rgm=?;";
            
            // passa a query para executar no banco de dados
            preparedStatement = connection.prepareStatement(sql);
            // passando do tipo de Date do java.util para o tipo de Date do java.sql, que é o que o banco de dados aceita
            java.sql.Date dataNascimento = new java.sql.Date(aluno.getDataNascimento().getTime());

            // passando os valores do codigo, nome, e tipo para os (?, ?, ?) da query
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setString(2, aluno.getSobrenome());
            preparedStatement.setString(3, aluno.getCpf());
            preparedStatement.setDate(4, dataNascimento);
            preparedStatement.setString(5, aluno.getEmail());
            preparedStatement.setString(6, aluno.getNumeroCelular());
            preparedStatement.setString(7, aluno.getEndereco());
            preparedStatement.setString(8, aluno.getMunicipio());
            preparedStatement.setString(9, aluno.getUf());
            preparedStatement.setString(10, aluno.getGenero());
            preparedStatement.setString(11, aluno.getRgm());
            
            // executando a query no banco
            preparedStatement.executeUpdate();
        } catch(Exception e){
            throw new Exception(">> ERRO AO ALTERAR DADO -> " + e.getMessage());
        }
    }
    
    public void atualizarCurso(Aluno aluno)throws Exception{
        try{
            String sql = "UPDATE aluno SET curso_id=?, periodo=? WHERE rgm=?;";
            
            // passa a query para executar no banco de dados
            preparedStatement = connection.prepareStatement(sql);

            // passando os valores do codigo, nome, e tipo para os (?, ?, ?) da query
            preparedStatement.setInt(1, aluno.getCurso_id());
            preparedStatement.setString(2, aluno.getPeriodo());
            preparedStatement.setString(3, aluno.getRgm());
            
            // executando a query no banco
            preparedStatement.executeUpdate();
        } catch(Exception e){
            throw new Exception(">> ERRO AO ALTERAR DADO -> " + e.getMessage());
        }
    }
    
    public Aluno consultarAluno(int RGM) throws Exception {
    	try {
    	       String sql = "SELECT aluno.*, curso.nome AS nome_curso FROM aluno INNER JOIN"
    	       		+ " curso ON aluno.curso_id = curso.id WHERE aluno.rgm = ?";
    	       
             preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setInt(1, RGM);
             resultSet = preparedStatement.executeQuery();
             
             if(resultSet.next()) {
                 String nome = resultSet.getString("nome");
                 String sobrenome = resultSet.getString("sobrenome");
                 int curso = resultSet.getInt("curso_id");
                 String nomeCurso = resultSet.getString("nome_curso");
                 aluno = new Aluno(null, nome, sobrenome, curso, null, null, null, null, null, null, null, null, null, nomeCurso);
                 }
             	return aluno;
             
        } catch (Exception e){
            throw new Exception(">> ERRO AO DELETAR ->" + e.getMessage());
      }
    }
    
    public void deletarAluno(Aluno aluno) throws Exception{
        try{
            String sql = "DELETE FROM aluno WHERE rgm = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, aluno.getRgm());
            int isAlunoExistent = preparedStatement.executeUpdate();

            if (isAlunoExistent == 0){
                System.out.println(">> ALERTA -> RGM não encontrado");
            }
        } catch (Exception e){
            throw new Exception(">> ERRO AO DELETAR ->" + e.getMessage());
        }
    }
 }
