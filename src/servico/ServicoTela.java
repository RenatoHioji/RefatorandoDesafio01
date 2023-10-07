package servico;

import controlador.ControladorProduto;
import modelo.Produto;

public class ServicoTela {
    Leitor leitor = new Leitor();
    ControladorProduto controladorProduto = new ControladorProduto();


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

    }

    public void fecharScanner(){
        leitor.fecharScanner();
    }

}
