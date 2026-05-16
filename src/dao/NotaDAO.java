package dao;

import models.Nota;
import main.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotaDAO {
    private Nota nota;
    private Connection connection;
    private PreparedStatement preparedStatement; // deixa rodar querys
    private ResultSet resultSet; // seria a tabela ou o retorno da query

    public NotaDAO() throws Exception{
        try{
            this.connection = ConnectionFactory.getConnection();
        } catch (Exception e){
            throw new Exception(">> ERRO ->" + e.getMessage());
        }
    }

    public void salvar() throws Exception{
        try{
            String sql = "INSERT INTO nota (aluno_id, disciplina, semestre, nota, faltas)" + 
                        "values (?, ?, ?, ?, ?);";

            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, nota.getAlunoId());
            preparedStatement.setString(2, nota.getDisciplina());
            preparedStatement.setString(3, nota.getSemestre());
            preparedStatement.setDouble(4, nota.getNota());
            preparedStatement.setInt(5, nota.getFalta());
            
            preparedStatement.executeUpdate();
        } catch(Exception e){
            throw new Exception(">> ERRO AO SALVAR ->" + e.getMessage());
        }
    }

    public List listar() throws Exception{
        List<Nota> lista = new ArrayList<Nota>();
        String sql = "SELECT * FROM nota;";
        
        try{
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int alunoId = resultSet.getInt("aluno_id");
                String disciplina = resultSet.getString("disciplina");
                String semestre = resultSet.getString("semestre");
                double notaAluno = resultSet.getDouble("nota");
                int falta = resultSet.getInt("faltas");
                

                lista.add(new Nota(notaAluno, disciplina, falta, semestre, alunoId));
            }
            return lista;
        } catch (Exception e){
            throw new Exception(">> ERRO AO LISTAR ->" + e.getMessage());
        }
    }

    public void excluir() throws Exception{
        try{
            String sql = "DELETE FROM nota WHERE aluno_id = ?;";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, nota.getAlunoId());

            preparedStatement.executeUpdate();
        } catch (Exception e){
            throw new Exception(">> ERRO AO EXCLUIR ->" + e.getMessage());
        }
    }
    public Nota consultarNota(int rgm, String disciplina, String semestre) throws Exception {
        try {
            String sql = "SELECT n.nota, n.faltas FROM nota n " +
                         "INNER JOIN aluno a ON n.aluno_id = a.id " +
                         "INNER JOIN disciplina d ON n.disciplina_id = d.id " +
                         "WHERE a.rgm = ? AND d.nome = ? AND n.semestre = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(rgm));
            preparedStatement.setString(2, disciplina);
            preparedStatement.setString(3, semestre);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                double nota = resultSet.getDouble("nota");
                int faltas = resultSet.getInt("faltas");
                return new Nota(nota, disciplina, faltas, semestre, rgm);
            }
            return null; // não encontrado

        } catch (Exception e) {
            throw new Exception(">> ERRO AO CONSULTAR NOTA -> " + e.getMessage());
        }
    }
    
    // Lista as disciplinas para seleção
    public List<String> listarDisciplinas(int cursoId) throws Exception {
        List<String> lista = new ArrayList<>();
        try {
            String sql = "SELECT nome FROM disciplina WHERE curso_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cursoId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                lista.add(resultSet.getString("nome"));
            }
            return lista;
        } catch (Exception e) {
            throw new Exception(">> ERRO AO LISTAR DISCIPLINAS -> " + e.getMessage());
        }
    }
}
