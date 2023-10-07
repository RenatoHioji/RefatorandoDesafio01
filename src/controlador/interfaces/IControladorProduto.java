package controlador.interfaces;

import modelo.Produto;

public interface IControladorProduto {
    void adicionarProduto(Produto produto) throws Exception;
    void removerProduto(Long idProduto);
    void atualizarProduto(Long idProduto, Produto produto);

    void verProdutos() throws Exception;
}
