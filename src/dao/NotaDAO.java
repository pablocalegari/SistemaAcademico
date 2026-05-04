package dao;

import models.Aluno;
import main.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotaDAO {
    private Aluno aluno;
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

    
}
