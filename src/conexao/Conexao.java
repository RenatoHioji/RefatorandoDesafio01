package conexao;

import conexao.abstractClass.AConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao extends AConnection {
    public Conexao(){
        super();
    }
    @Override
    protected Connection conecta() {
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
    protected void fecharConexao() {
        try {
            if (criarConexao != null) {
                criarConexao.close();
                System.out.println("Conexão foi fechada com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível desconectar...");
        }
    }
}
