package conexao.abstractClass;

import java.sql.Connection;

public abstract class AConnection {
    protected Connection criarConexao;
    protected String URL;
    protected String USUARIO;
    protected String SENHA;

    protected abstract Connection conecta();
    protected abstract void fecharConexao();
}
