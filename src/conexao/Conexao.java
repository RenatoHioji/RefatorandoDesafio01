package conexao;

import conexao.abstractClass.AConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao extends AConnection implements AutoCloseable {
    public Conexao(){
        super();
    }
    @Override
    public Connection conecta() {
        try {
            URL = "jdbc:mysql://localhost:3306/desafio01";
            USUARIO = "root";
            SENHA= "";
            criarConexao= DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.out.println("Falha ao conectar ao banco de dados...");
        }
        return criarConexao;
    }
    @Override
    public void close() throws Exception {
        criarConexao.close();
    }
}
