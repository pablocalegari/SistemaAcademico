package dao;

import models.Nota;
import main.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
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
            String sql = "INSERT INTO nota (disciplina, semestre, nota, faltas)" + 
                        "values (?, ?, ?, ?);";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nota.getDisciplina());
            preparedStatement.setString(2, nota.getSemestre());
            preparedStatement.setDouble(3, nota.getNota());
            preparedStatement.setInt(4, nota.getFalta());

            preparedStatement.executeUpdate();
        } catch(Exception e){
            throw new Exception(">> ERRO AO SALVAR ->" + e.getMessage());

        }
    }

    public List listar() throws Exception{
        List<Nota> lista = new ArrayList<Nota>();
        String sql = "SELECT * FROM nota;";
        preparedStatement = connection.prepareStatement(sql);
        try{
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String disciplina = resultSet.getString("disciplina");
                String semestre = resultSet.getString("semestre");
                double notaAluno = resultSet.getDouble("nota");
                int falta = resultSet.getInt("faltas");

                lista.add(new Nota(notaAluno, disciplina, falta, semestre));
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

            //preparedStatement.set

            //preparedStatement.executeUpdate();
        } catch (Exception e){
            throw new Exception(">> ERRO AO EXCLUIR ->" + e.getMessage());
        }
    }
}
