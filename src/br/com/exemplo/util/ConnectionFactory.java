package br.com.exemplo.util;

import java.sql.Connection;
import java.sql.DriverManager;

import br.com.exemplo.view.Janela1;

public class ConnectionFactory {
    public static Connection getConnection() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String login = "root";
            String senha = "";
            String url = "jdbc:mysql://localhost:3306/sistema_academico";
            return DriverManager.getConnection(url, login, senha);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception{
        try{
            Connection connect = ConnectionFactory.getConnection();
            Janela1 janelaPrincipal = new Janela1();
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
