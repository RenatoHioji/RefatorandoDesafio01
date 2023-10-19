package servico;

import controlador.ControladorProduto;
import controlador.ControladorCarrinho;
import modelo.Produto;
import utilidade.Leitor;

import java.util.List;

public class ServicoTela {
    private final Leitor leitor = new Leitor();
    private final ControladorProduto controladorProduto = new ControladorProduto();
    private final ControladorCarrinho controladorCarrinho = new ControladorCarrinho();

    public ServicoTela() {

    }

    public String mostrarOpcoes() {
        return leitor.lerOpcao();
    }

    public void opcao1(){
        controladorProduto.verProdutos();
    }

    public void opcao2(){
        Produto produto = new Produto(leitor.lerNovoProduto());
        controladorProduto.adicionarProduto(produto);
    }

    public void opcao3(){
        Long idProduto = leitor.lerIdExcluir();
        controladorProduto.removerProduto(idProduto);
    }

    public void opcao4(){
        Long idAtualizar = leitor.lerIdAtualizar();
        Produto produto = new Produto(leitor.lerAtualizarProduto());
        controladorProduto.atualizarProduto(idAtualizar, produto);
    }

    public void opcao5() {
        controladorCarrinho.iniciarCarrinho();
    }


    public void fecharScanner(){
        leitor.fecharScanner();
        controladorCarrinho.fecharScanner();
    }

}
