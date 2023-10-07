package servico.interfaces;

import modelo.Produto;

import java.sql.SQLException;

public interface IServicoProduto {
    void adicionarProduto(Produto produto) throws Exception;
    void removerProduto(Long idProduto);
    void atualizarProduto(Long idProduto, Produto produto);
    void verProdutos() throws Exception;
    void filtrarProdutos(String nome) throws SQLException;
    boolean verificarExistenciaProduto(Long idProduto);
}
