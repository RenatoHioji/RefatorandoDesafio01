package servico;

import modelo.Produto;
import repositorio.RepositorioProduto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ServicoProduto implements IServicoProduto{
    RepositorioProduto repositorioProduto = new RepositorioProduto();
    @Override
    public void adicionarProduto(Produto produto) throws Exception {
        if(this.verificarExistenciaProduto(produto.getId())){
            repositorioProduto.adicionarProduto(produto);
        }else{
            System.out.println("Produto já existente!");
        }
    }

    @Override
    public void removerProduto(Long idProduto) {
        if(!this.verificarExistenciaProduto(idProduto)) {
            repositorioProduto.removerProduto(idProduto);
        }else{
            System.out.println("Produto inexistente!");
        }
    }

    @Override
    public void atualizarProduto(Long idProduto, Produto produto) {
        if(this.verificarExistenciaProduto(idProduto)) {
            repositorioProduto.atualizarProduto(idProduto,produto);
        }else{
            System.out.println("Produto inexistente!");
        }
    }

    @Override
    public void verProdutos() throws SQLException {
        ResultSet produtos = repositorioProduto.verProdutos();
        while(produtos.next()){
                System.out.println("\n Produto: " + produtos.getLong("id"));
                System.out.println("\n Nome do Produto: " + produtos.getString("nome"));
                System.out.println("\n Estoque do Produto: " + produtos.getInt("estoque"));
                System.out.println("\n Valor do Produto: " + produtos.getDouble("valor"));
        }
    }

    @Override
    public void filtrarProdutos(String nome) throws SQLException {
        ResultSet dados = repositorioProduto.filtrarProdutos(nome);
        while(dados.next()){
            System.out.println("\n O Id do produto é: " + dados.getLong("id"));
            System.out.println("\n O nome do produto é: " + dados.getString("nome"));
            System.out.println("\n O valor do produto é: " + dados.getDouble("valor"));
            System.out.println("\n O estoque do produto é: " + dados.getInt("estoque"));
        }
    }

    @Override
    public boolean verificarExistenciaProduto(Long idProduto) {
        ResultSet dados = repositorioProduto.verificarExistenciaProduto(idProduto);
        return dados != null;
    }
}
