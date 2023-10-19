package controlador;

import controlador.interfaces.IControladorProduto;
import modelo.Produto;
import servico.ServicoProduto;

public class ControladorProduto implements IControladorProduto {

    ServicoProduto servicoProduto = new ServicoProduto();
    public ControladorProduto() {
    }

    @Override
    public void adicionarProduto(Produto produto){
        servicoProduto.adicionarProduto(produto);
    }

    @Override
    public void removerProduto(Long idProduto) {
        servicoProduto.removerProduto(idProduto);
    }

    @Override
    public void atualizarProduto(Long idAtualizar, Produto produto) {
        servicoProduto.atualizarProduto(idAtualizar, produto);
    }

    @Override
    public void verProdutos(){
        servicoProduto.verProdutos();
    }
}
