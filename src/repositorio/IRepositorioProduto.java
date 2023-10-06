package repositorio;

import modelo.Produto;

import java.util.List;

public interface IRepositorioProduto {
    void adicionarProduto(Produto produto);
    void removerProduto(Long idProduto);
    void atualizarProduto(Long idProduto, Produto produto);
    List<Produto> verProdutos();
    void filtrarProdutos(String nome);
    boolean verificarExistenciaProduto(Long idProduto);
}

