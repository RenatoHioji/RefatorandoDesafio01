package repositorio;

import modelo.CarrinhoDeCompras;
import modelo.Produto;

import java.util.List;

public interface IRepositorioCarrinho {
    void adicionarProduto(List<CarrinhoDeCompras> carrinhoDeComprasList, Produto produto);
    void removerProduto(List<CarrinhoDeCompras> carrinhoDeCompras, Produto produto);
    void verCarrinho(List<CarrinhoDeCompras> carrinhoDeCompras);
    void atualizarCarrinho(List<CarrinhoDeCompras> carrinhoDeCompras);
    double  somarTotal(Long idCarrinho);
    void finalizarCompra(List<CarrinhoDeCompras> carrinhoDeCompras, Long idCarrinho);
    void corrigirEstoque(List<CarrinhoDeCompras> carrinhoDeCompras, Long idCarrinho);
    boolean verificarEstoque(List<CarrinhoDeCompras> carrinhoDeCompras, Long idCarrinho);
    Long criarIdCarrinho();
    void mostrarCompras();
}
