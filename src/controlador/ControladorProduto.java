package controlador;

import modelo.Produto;
import servico.ServicoProduto;

public class ControladorProduto implements IControladorProduto{

    ServicoProduto servicoProduto = new ServicoProduto();
    public ControladorProduto() {
    }

    @Override
    public void adicionarProduto(Produto produto) throws Exception {
        servicoProduto.adicionarProduto(produto);
    }

    @Override
    public void removerProduto(Long idProduto) {
        servicoProduto.removerProduto(idProduto);
    }

    @Override
    public void atualizarProduto(Long idProduto, Produto produto) {
        servicoProduto.atualizarProduto(idProduto, produto);
    }

    @Override
    public void verProdutos() throws Exception {
        servicoProduto.verProdutos();
    }
}
