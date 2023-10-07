package controlador.interfaces;

import modelo.CarrinhoDeCompras;
import modelo.Produto;

import java.util.List;

public interface IControladorCarrinho {
    void adicionarProduto(List<CarrinhoDeCompras> carrinhoDeComprasList, Produto produto);
    void removerProduto(List<CarrinhoDeCompras> carrinhoDeCompras, Produto produto);
    void verCarrinho(List<CarrinhoDeCompras> carrinhoDeCompras);
    void atualizarCarrinho(List<CarrinhoDeCompras> carrinhoDeCompras);

}
