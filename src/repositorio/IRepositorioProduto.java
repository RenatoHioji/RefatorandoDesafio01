package repositorio;

import modelo.Produto;

import java.sql.ResultSet;

public interface IRepositorioProduto {
    void adicionarProduto(Produto produto) throws Exception;
    void removerProduto(Long idProduto) throws Exception;
    void atualizarProduto(Long idProduto, Produto produto);
    ResultSet verProdutos() throws Exception;
    ResultSet filtrarProdutos(String nome);
    ResultSet verificarExistenciaProduto(Long idProduto);
}

