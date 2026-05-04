package dao;

import models.Aluno;
import main.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlunoDAO {
    private Aluno aluno;
    private Connection connection;
    private PreparedStatement preparedStatement; // deixa rodar querys
    private ResultSet resultSet; // seria a tabela ou o retorno da query

    public AlunoDAO() throws Exception{
        try{
            this.connection = ConnectionFactory.getConnection();
        } catch (Exception e){
            throw new Exception(">> ERRO ->" + e.getMessage());
        }
    }

    public void salvar(Aluno Aluno) throws Exception{
        try{
            String sql = "INSERT INTO aluno(nome , rgm , cpf, data_nascimento, email, celular , endereco, curso_id)" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?);";
            // passa a query para executar no banco de dados
            preparedStatement = connection.prepareStatement(sql);

            // passando os valores do codigo, nome, e tipo para os (?, ?, ?) da query
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setInt(2, aluno.getRgm());
            preparedStatement.setString(3, aluno.getCpf());
            preparedStatement.setDate(4, aluno.getDataNascimento());
            preparedStatement.setString(5, aluno.getEmail());
            preparedStatement.setInt(6, aluno.getNumeroCelular());
            preparedStatement.setString(7, aluno.getEndereco());
            preparedStatement.setInt(8, aluno.getCurso());
            
            // executando a query no banco
            preparedStatement.executeUpdate();
        } catch (Exception e){
            throw new Exception(">> ERRO AO SALVAR ->" + e.getMessage());
        }
    }

    public List listar() throws Exception{
        List<Aluno> lista = new ArrayList<Aluno>();
        String sql = "SELECT * FROM aluno;";
        preparedStatement = connection.prepareStatement(sql);
        try{
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                // pegando os do banco de dados e passando para as variaveis
                String nome = resultSet.getString("nome");
                int rgm = resultSet.getInt("rgm");
                String cpf = resultSet.getString("cpf");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                String email = resultSet.getString("email");
                int numeroCelular = resultSet.getInt("celular");
                String endereco =  resultSet.getString("endereco");
                int curso = resultSet.getInt("curso_id");

                lista.add(new Aluno(rgm,nome,curso,cpf,numeroCelular,email,dataNascimento,endereco));
            }
            return lista;
        } catch (Exception e){
            throw new Exception(">> ERRO AO LISTAR DADOS->" + e.getMessage());
        }
    }

    //public void atualizar()throws Exception{
    //    try{
    //        String sql = "UPDATE aluno SET blablabla WHERE rgm = ?;";
    //    } catch(Exception e){
    //        throw new Exception(">> ERRO AO ALTERAR DADO -> " + e.getMessage());
    //    }
    //}

    public void deletar() throws Exception{
        try{
            String sql = "DELETE FROM aluno WHERE rgm = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, aluno.getRgm());
            int isAlunoExistent = preparedStatement.executeUpdate();

            if (isAlunoExistent == 0){
                System.out.println(">> ALERTA -> RMG não encontrado");
            }
        } catch (Exception e){
            throw new Exception(">> ERRO AO DELETAR ->" + e.getMessage());
        }
    }
}
