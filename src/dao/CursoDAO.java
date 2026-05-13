package dao;

import models.Curso;
import main.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    private Connection connection;
    private PreparedStatement preparedStatement; // deixa rodar querys
    private ResultSet resultSet; // seria a tabela ou o retorno da query

    public CursoDAO() throws Exception {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (Exception e) {
            throw new Exception(">> ERRO ->" + e.getMessage());
        }
    }

    public int buscarId(String nome, String campus, String periodo) throws Exception {
        try {
            String sql = "SELECT id FROM curso WHERE nome = ? AND campus = ? AND periodo = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, campus);
            preparedStatement.setString(3, periodo);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
            throw new Exception("Curso não encontrado: " + nome + " / " + campus + " / " + periodo);
        } catch (Exception e) {
            throw new Exception(">> ERRO AO BUSCAR CURSO ->" + e.getMessage());
        }
    }

    public List<Curso> listar() throws Exception {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT * FROM curso";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Curso curso = new Curso(
                    resultSet.getString("nome"),
                    resultSet.getString("campus"),
                    resultSet.getString("periodo")
                );
                curso.setId(resultSet.getInt("id"));
                lista.add(curso);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception(">> ERRO AO LISTAR CURSOS ->" + e.getMessage());
        }
    }
}