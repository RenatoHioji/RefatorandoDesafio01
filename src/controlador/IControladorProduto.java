package controlador;

import modelo.Produto;

import java.util.List;

public interface IControladorProduto {
    void adicionarProduto(Produto produto);
    void removerProduto(Long idProduto);
    void atualizarProduto(Long idProduto, Produto produto);
    List<Produto> verProdutos();
}
