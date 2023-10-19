package repositorio.interfaces;

import modelo.CarrinhoDeCompras;
import modelo.Produto;

import java.util.List;

public interface IRepositorioCarrinho {
    List<Produto> mostrarProdutos();
    List<Produto> filtrarProdutos(String nome);
    void adicionarProduto(List<CarrinhoDeCompras> carrinhoDeCompras, CarrinhoDeCompras produto);
    void removerProduto(List<CarrinhoDeCompras> carrinhoDeCompras, CarrinhoDeCompras produto);
    void atualizarCarrinho(List<CarrinhoDeCompras> carrinhoDeCompras, CarrinhoDeCompras produto, Integer index);
    void finalizarCompra(CarrinhoDeCompras produto, Long idVendas);
    void corrigirEstoque(CarrinhoDeCompras produto);
    Produto verificarEstoque(Long id);
    List<CarrinhoDeCompras> mostrarCompras();
    List<Produto> procurarProdutos(List<CarrinhoDeCompras> carrinhoDeCompras, List<Long> ids);



}
