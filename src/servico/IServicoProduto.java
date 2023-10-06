package servico;

import modelo.Produto;

import java.util.List;

public interface IServicoProduto {
    void adicionarProduto(Produto produto);
    void removerProduto(Long idProduto);
    void atualizarProduto(Long idProduto, Produto produto);
    List<Produto> verProdutos();
    void filtrarProdutos(String nome);
    boolean verificarExistenciaProduto(Long idProduto);
}
