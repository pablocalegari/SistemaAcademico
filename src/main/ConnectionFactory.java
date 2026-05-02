package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection getConnection() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String login = "root";
            String senha = "";
            String url = "jdbc:mysql://localhost:3306/";
            return DriverManager.getConnection(url, login, senha);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception{
        try{
            Connection connect = ConnectionFactory.getConnection();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
