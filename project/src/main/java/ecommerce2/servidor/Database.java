package ecommerce2.servidor;

/**
 * Crie um Database no MySQL antes de iniciar esse arquivo
 * create database ecommerce;
 * use ecommerce;
 */

// Imports do Banco de dados
import java.sql.*;

public class Database {
    //Atributos
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    /**
     * Método que conecta ao MySQL e controla as requisições ao banco
     * @throws Exception
     */
    public void readDatabase() throws Exception {
        try{
            //Conectando ao banco de dados
            String user = "root";
            String password = "senha";
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce",user,password);

            //Iniciando inserção de queryes(pedidos) ao banco de dados
            statement = connect.createStatement();

            // ResultSet serve para pegar resultados de requisiçoes do Banco de dados
            resultSet = statement.executeQuery("create table clientes(id int not null auto_increment,nome varchar(30) not null,cpf int not null)");
            pegandoDados(resultSet);

            // Adicionando dados a tabela com PreparedStatements, onde vai nos ajudar a atualizar e pegar dados do bd
            preparedStatement = connect.prepareStatement("insert into clientes values(default,?,?)"); //? é para add depois, como abaixo
            preparedStatement.setString(1,"Gabriel");
            preparedStatement.setInt(2, 1234);
            preparedStatement.executeUpdate();

            // Pegando os dados por requisição e enviando ao Método pegandoDados()
            preparedStatement = connect.prepareStatement("select nome,cpf from clientes");
            resultSet = preparedStatement.executeQuery();
            pegandoDados(resultSet);

        }catch(Exception e){
            throw e;
        }finally{
            close();
        }    
    }

    /**
     * Pegando os dados da Tabela do Banco de dados
     * @param results
     * @throws SQLException
     */
    private void pegandoDados(ResultSet results) throws SQLException {
        System.out.println("Dados na Tabela clientes:\n");
        
        while(results.next()){
            String name = results.getString("nome");
            int cpf = results.getInt("cpf");

            System.out.println("Nome do Usuário: " + name);
            System.out.println("CPF do Usuário: " + cpf);
        }
    }

    private void close(){
        try{
            if(resultSet != null){resultSet.close();}
            if(statement != null){statement.close();}
            if(connect != null){connect.close();}
        }catch(Exception e){}
    }


}