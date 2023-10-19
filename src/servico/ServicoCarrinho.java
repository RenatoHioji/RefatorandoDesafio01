package servico;

import modelo.CarrinhoDeCompras;
import modelo.Produto;
import repositorio.RepositorioCarrinho;
import servico.interfaces.IServicoCarrinho;
import utilidade.LeitorCarrinho;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServicoCarrinho implements IServicoCarrinho {

    public ServicoCarrinho() {

    }
    private final RepositorioCarrinho repositorioCarrinho = new RepositorioCarrinho();
    private final List<CarrinhoDeCompras> carrinhoDeCompras = new ArrayList<>();
    private final ServicoCarrinhoAux servicoCarrinhoAux = new ServicoCarrinhoAux();
    private final LeitorCarrinho leitorCarrinho = new LeitorCarrinho();
    @Override
    public void mostrarProdutos() {
        List<Produto> produtos = repositorioCarrinho.mostrarProdutos();
        servicoCarrinhoAux.mostrarProdutos(produtos);
    }

    @Override
    public void filtrarProdutos() {
        List<Produto> produtos = repositorioCarrinho.filtrarProdutos(leitorCarrinho.lerNome());
        servicoCarrinhoAux.mostrarProdutos(produtos);
    }

    @Override
    public void adicionarCarrinhoProduto(){
        CarrinhoDeCompras carrinhoDeCompra =leitorCarrinho.adicionarCarrinhoProduto();
        Boolean existenteNoCarrinho = servicoCarrinhoAux.verificarProduto(carrinhoDeCompras, carrinhoDeCompra);
        Boolean estoqueDisponivel = verificarEstoque(carrinhoDeCompra);
        if(existenteNoCarrinho && estoqueDisponivel){
            repositorioCarrinho.adicionarProduto(carrinhoDeCompras, carrinhoDeCompra);
            System.out.println("Produto adicionado ao carrinho! \n");
        }else{
            System.out.println("Produto indisponível ou já existente no carrinho. \n");
        }
    }
    @Override
    public void removerCarrinhoProduto() {
        Long id = leitorCarrinho.removerCarrinhoProduto();
        for(CarrinhoDeCompras carrinhoDeCompra : carrinhoDeCompras){
            if(Objects.equals(carrinhoDeCompra.getIdProduto(), id)){
                repositorioCarrinho.removerProduto(carrinhoDeCompras, carrinhoDeCompra);
                System.out.println("Produto removido com sucesso! \n");
                return;
            }
        }
        System.out.println("Produto inexistente no carrinho! \n");
    }
    @Override
    public void atualizarCarrinho() {
        Long idAtualizar = leitorCarrinho.lerIdAtualizar();
        CarrinhoDeCompras produto = leitorCarrinho.atualizarCarrinhoProduto(idAtualizar);
        boolean estoqueDisponivel = verificarEstoque(produto);

        if (!estoqueDisponivel) {
            System.out.println("Estoque indisponível \n");
            return;
        }

        int index = servicoCarrinhoAux.pegarIndex(carrinhoDeCompras, idAtualizar);

        if (index != -1) {
            repositorioCarrinho.atualizarCarrinho(carrinhoDeCompras, produto, index);
            System.out.println("Produto atualizado no carrinho! \n");
        } else {
            System.out.println("Produto inexistente no carrinho! \n");
        }
    }
    @Override
    public void verCarrinho() {
        List<Long> ids = new ArrayList<>();
        carrinhoDeCompras.forEach(prod -> ids.add(prod.getIdProduto()));
        List<Produto> produtos = repositorioCarrinho.procurarProdutos(carrinhoDeCompras, ids);
        if (produtos.isEmpty()) {
            System.out.println("Carrinho de Compras Vazio");
        } else {
            servicoCarrinhoAux.mostrarDadosCarrinho(carrinhoDeCompras, produtos);
        }
    }

    @Override
    public void finalizarCompra() {
        this.verCarrinho();
        if(!leitorCarrinho.confirmarCompra().equals("1")){
            return;
        }
        Long idVendas = repositorioCarrinho.pegarIdVendas();
        carrinhoDeCompras.forEach(carrinhoDeCompra ->{
            repositorioCarrinho.finalizarCompra(carrinhoDeCompra, idVendas);
        });

        this.corrigirEstoque(carrinhoDeCompras);
        System.out.println("Compra finalizada com sucesso!");
    }
    @Override
    public void corrigirEstoque(List<CarrinhoDeCompras> carrinhoDeCompras) {
        carrinhoDeCompras.forEach(repositorioCarrinho::corrigirEstoque);

    }
    @Override
    public boolean verificarEstoque(CarrinhoDeCompras carrinhoDeCompra) {
        Produto produto = repositorioCarrinho.verificarEstoque(carrinhoDeCompra.getIdProduto());
        return carrinhoDeCompra.getQuantidade() <= produto.getEstoque();
    }

    @Override
    public void mostrarCompras() {
        List<CarrinhoDeCompras> carrinhoDeCompra;
        List<Long> ids = new ArrayList<>();
        carrinhoDeCompra = repositorioCarrinho.mostrarCompras();
        carrinhoDeCompra.forEach(prod -> ids.add(prod.getIdProduto()));
        List<Produto> produtos = repositorioCarrinho.procurarProdutos(carrinhoDeCompras, ids);
        carrinhoDeCompra = servicoCarrinhoAux.adicionarProdutoCarrinho(repositorioCarrinho.mostrarCompras(), produtos);
        carrinhoDeCompra.forEach(servicoCarrinhoAux::mostrarCompras);

    }
    @Override
    public String iniciarCarrinho() {
        return leitorCarrinho.lerIniciar();
    }

    public void fecharScanner() {
        leitorCarrinho.fecharScanner();
    }
}
