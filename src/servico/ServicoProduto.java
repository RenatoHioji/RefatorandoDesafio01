package servico;

import modelo.Produto;
import repositorio.RepositorioProduto;
import servico.interfaces.IServicoProduto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ServicoProduto implements IServicoProduto {
    RepositorioProduto repositorioProduto = new RepositorioProduto();
    @Override
    public void adicionarProduto(Produto produto) {
        if(this.verificarExistenciaProduto(produto.getId())){
            System.out.println("Produto já existente! \n");
        }else{
            repositorioProduto.adicionarProduto(produto);
            System.out.println("Produto adicionado com sucesso \n");
        }
    }

    @Override
    public void removerProduto(Long idProduto) {
        if(this.verificarExistenciaProduto(idProduto)) {
            repositorioProduto.removerProduto(idProduto);
            System.out.println("Produto removido com sucesso! \n");
        }else{
            System.out.println("Produto inexistente! \n");
        }
    }

    @Override
    public void atualizarProduto(Long idAtualizar, Produto produto) {
        if(this.verificarExistenciaProduto(idAtualizar)) {
            repositorioProduto.atualizarProduto(idAtualizar,produto);
            System.out.println("Produto atualizado com sucesso!");
        }else{
            System.out.println("Produto inexistente! \n");
        }
    }
    @Override
    public void verProdutos(){
        List<Produto> produtos = repositorioProduto.verProdutos();
        this.mostrarProdutos(produtos);
    }
    @Override
    public void filtrarProdutos(String nome){
        List<Produto> dados = repositorioProduto.filtrarProdutos(nome);
        this.mostrarProdutos(dados);
    }

    @Override
    public boolean verificarExistenciaProduto(Long idProduto){
        List<Produto> dados = repositorioProduto.verificarExistenciaProduto(idProduto);
        return !dados.isEmpty();
    }
    private void mostrarProdutos(List<Produto> produtos) {
        produtos.forEach(produto -> {
            System.out.println("Produto: " + produto.getId());
            System.out.println("Nome do Produto: " + produto.getNome());
            System.out.println("Estoque do Produto: " + produto.getEstoque());
            System.out.println("Valor do Produto: " + produto.getValor() + "\n");
        });
    }

}
