package servico.interfaces;

import modelo.CarrinhoDeCompras;
import modelo.Produto;

import java.util.List;

public interface IServicoCarrinho {
    void adicionarCarrinhoProduto();
    void removerCarrinhoProduto();
    void verCarrinho();
    void atualizarCarrinho();

    void finalizarCompra();
    void corrigirEstoque(List<CarrinhoDeCompras> carrinhoDeCompras);
    boolean verificarEstoque(CarrinhoDeCompras carrinhoDeCompra);
    void mostrarCompras();

    String iniciarCarrinho();

    void filtrarProdutos();

    void mostrarProdutos();
}
