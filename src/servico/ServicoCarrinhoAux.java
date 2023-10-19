package servico;

import modelo.CarrinhoDeCompras;
import modelo.Produto;

import java.util.List;
import java.util.Objects;

public class ServicoCarrinhoAux {
    public void mostrarDadosCarrinho(List<CarrinhoDeCompras> carrinhoDeCompras, List<Produto> produtos) {
        carrinhoDeCompras = this.adicionarProdutoCarrinho(carrinhoDeCompras, produtos);
        System.out.println("Seu Carrinho de Compras \n");
        carrinhoDeCompras.forEach(carrinho -> {
            System.out.println("ID do produto: " + carrinho.getIdProduto());
            System.out.println("Nome do Produto: " + carrinho.getProduto().getNome());
            System.out.println("Valor do Produto: " + carrinho.getProduto().getValor());
            System.out.println("Quantidade do Produto: " + carrinho.getQuantidade());
            System.out.println("Valor total do Produto: " + carrinho.getProduto().getValor()*carrinho.getQuantidade() + " \n");
        });
        System.out.println("Valor total do carrinho é de: " + this.somarTotal(carrinhoDeCompras)+ "\n");
    }

    public List<CarrinhoDeCompras> adicionarProdutoCarrinho(List<CarrinhoDeCompras> carrinhoDeCompras, List<Produto> produtos) {
        produtos.forEach(produto -> {
            carrinhoDeCompras.forEach(carrinho -> {
                if(Objects.equals(carrinho.getIdProduto(), produto.getId())){
                    carrinho.setProduto(produto);
                }
            });
        });
        return carrinhoDeCompras;
    }

    public double somarTotal(List<CarrinhoDeCompras> carrinhoDeCompras) {
        return carrinhoDeCompras.stream().mapToDouble(carrinho ->
                        (carrinho.getProduto().getValor()*carrinho.getQuantidade())).sum();
    }

    public boolean verificarProduto(List<CarrinhoDeCompras> carrinhoDeCompras, CarrinhoDeCompras carrinhoDeCompra) {
        for (CarrinhoDeCompras prodCarrinho : carrinhoDeCompras) {
            if(Objects.equals(prodCarrinho.getIdProduto(), carrinhoDeCompra.getIdProduto())){
                return false;
            }
        }
        return true;
    }

    public void mostrarProdutos(List<Produto> produtos) {
        produtos.forEach(produto -> {
            System.out.println("Produto: " + produto.getId());
            System.out.println("Nome do produto: " + produto.getNome());
            System.out.println("Valor do produto: " + produto.getValor());
            System.out.println("Estoque do produto: " + produto.getEstoque() + "\n");
        });
    }


    public int pegarIndex(List<CarrinhoDeCompras> carrinhoDeCompras, Long productId) {
        for (int i = 0; i < carrinhoDeCompras.size(); i++) {
            if (Objects.equals(carrinhoDeCompras.get(i).getIdProduto(), productId)) {
                return i;
            }
        }
        return -1;
    }

    public void mostrarCompras(CarrinhoDeCompras produto) {
        System.out.println("ID_VENDA: " + produto.getId_vendas());
        System.out.println("Produto: " + produto.getProduto().getNome());
        System.out.println("Quantidade: " + produto.getQuantidade());
        System.out.println("Valor: " + produto.getProduto().getValor());
        System.out.println("Valor total do produto: " + produto.getProduto().getValor()*produto.getQuantidade() + " \n");
    }
}
