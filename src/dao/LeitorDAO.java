package dao;

import models.Leitor;
import main.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LeitorDAO {
    private Leitor leitor;
    private Connection connection;
    private PreparedStatement preparedStatement; // deixa rodar querys
    private ResultSet resultSet; // seria a tabela ou o retorno da query

    public LeitorDAO() throws Exception{
        try{
            this.connection = ConnectionFactory.getConnection();
        } catch (Exception e){
            throw new Exception(">> ERRO ->" + e.getMessage());
        }
    }

    public void salvar(Leitor leitor) throws Exception{
        try{
            String sql = "INSERT INTO tbLeitor(codLeitor, nomeLeitor, tipoLeitor)" +
                    "values (?, ?, ?)";
            // passa a query para executar no banco de dados
            preparedStatement = connection.prepareStatement(sql);

            // passando os valores do codigo, nome, e tipo para os (?, ?, ?) da query
            preparedStatement.setInt(1, leitor.getCodLeitor());
            preparedStatement.setString(2, leitor.getNomeLeitor());
            preparedStatement.setString(3, leitor.getTipoLeitor());

            // executando a query no banco
            preparedStatement.executeUpdate();
        } catch (Exception e){
            throw new Exception(">> ERRO AO SALVAR ->" + e.getMessage());
        }
    }

    public List listar() throws Exception{
        List<Leitor> lista = new ArrayList<Leitor>();
        String sql = "SELECT * FROM tbLeitor";
        preparedStatement = connection.prepareStatement(sql);
        try{
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                // pegando os do banco de dados e passando para as variaveis
                int codLeitor = resultSet.getInt("codLeitor");
                String nomeLeitor = resultSet.getString("nomeLeitor");
                String tipoLeitor = resultSet.getString("tipoLeitor");

                lista.add(new Leitor(codLeitor, nomeLeitor, tipoLeitor));
            }
            return lista;
        } catch (Exception e){
            throw new Exception(">> ERRO AO LISTAR DADOS->" + e.getMessage());
        }
    }
}
