package repositorio.interfaces;

import modelo.Produto;

import java.util.List;

public interface IRepositorioProduto {
    void adicionarProduto(Produto produto) throws Exception;
    void removerProduto(Long idProduto) throws Exception;
    void atualizarProduto(Long idProduto, Produto produto);
    List<Produto> verProdutos() throws Exception;
    List<Produto> filtrarProdutos(String nome);
    List<Produto> verificarExistenciaProduto(Long idProduto);
}

