package repositorio;

import conexao.Conexao;
import modelo.CarrinhoDeCompras;
import modelo.Produto;
import repositorio.interfaces.IRepositorioCarrinho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCarrinho implements IRepositorioCarrinho {

    public RepositorioCarrinho() {

    }
    @Override
    public List<Produto> mostrarProdutos() {
        try(Conexao conexao = new Conexao();
            Connection conectar = conexao.conecta();
            PreparedStatement preparar = conectar.prepareStatement("SELECT * FROM produtos")){
            return this.arrayList(preparar);
        } catch (Exception e) {
            System.out.println("Não foi possível mostrar os produtos!");
        }
        return new ArrayList<>();
    }
    @Override
    public List<Produto> filtrarProdutos(String nome) {
        try(Conexao conexao = new Conexao();
            Connection conectar =conexao.conecta();
            PreparedStatement preparar = conectar.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ?")){
            preparar.setString(1, "%" + nome + "%");
            return this.arrayList(preparar);
        }catch (Exception e){
            System.out.println("Não foi possível ler os produtos com nome: " + nome);
        }
        return new ArrayList<>();
    }
    @Override
    public void adicionarProduto(List<CarrinhoDeCompras> carrinhoDeCompras, CarrinhoDeCompras produto) {
        carrinhoDeCompras.add(produto);
    }

    @Override
    public void removerProduto(List<CarrinhoDeCompras> carrinhoDeCompras, CarrinhoDeCompras carrinhoDeCompra) {
        carrinhoDeCompras.remove(carrinhoDeCompra);
    }

    @Override
    public void atualizarCarrinho(List<CarrinhoDeCompras> carrinhoDeCompras, CarrinhoDeCompras produto, Integer index) {
        carrinhoDeCompras.set(index, produto);
    }

    @Override
    public void finalizarCompra(CarrinhoDeCompras produto, Long idVendas) {
        try(Conexao conexao = new Conexao();
        Connection conectar = conexao.conecta();
        PreparedStatement preparar = conectar.prepareStatement(
                "INSERT INTO vendas (id_produto, quantidade, id_vendas) VALUES (?, ?, ?)")) {

            preparar.setLong(1, produto.getIdProduto());
            preparar.setInt(2, produto.getQuantidade());
            preparar.setLong(3, idVendas);
            preparar.executeUpdate();
        }catch(Exception e){
            System.out.println("Não foi possível finalizar a compra! \n");
        }
    }

    @Override
    public void corrigirEstoque(CarrinhoDeCompras produto) {
        try(Conexao conexao = new Conexao();
        Connection conectar = conexao.conecta();
        PreparedStatement preparar= conectar.prepareStatement("UPDATE produtos SET estoque = (SELECT new_estoque FROM (SELECT (estoque - ?) AS new_estoque FROM produtos WHERE id = ?) AS subquery)")){
            preparar.setInt(1, produto.getQuantidade());
            preparar.setLong(2, produto.getIdProduto());
            preparar.executeUpdate();
        }catch(Exception e){
            System.out.println("Não foi possível corrigir o estoque! \n");
        }
    }

    @Override
    public Produto verificarEstoque(Long id) {
        try (Conexao conexao = new Conexao();
             Connection conectar = conexao.conecta();
             PreparedStatement preparar = conectar.prepareStatement("SELECT * FROM produtos WHERE id = ?")) {
            preparar.setLong(1, id);
            return this.produto(preparar);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new Produto();
    }
    @Override
    public List<CarrinhoDeCompras> mostrarCompras() {
        try(Conexao conexao = new Conexao();
        Connection conectar = conexao.conecta();
        PreparedStatement preparar = conectar.prepareStatement("SELECT * FROM vendas ORDER BY id_vendas DESC")){
        return this.carrinhoArrayList(preparar);

        }catch(Exception e){
            System.out.println("Não foi possível listar suas compras!");
        }
        return new ArrayList<>();
    }



    @Override
    public List<Produto> procurarProdutos(List<CarrinhoDeCompras> carrinhoDeCompras, List<Long> ids) {
        try (Conexao conexao = new Conexao();
             Connection conectar = conexao.conecta();
             PreparedStatement preparar = conectar.prepareStatement("SELECT * FROM produtos")) {
            return this.arrayList(preparar);
        } catch (Exception e) {
            System.out.println("Não foi possível procurar os produtos! \n");
        }
        return new ArrayList<>();
    }
    public long pegarIdVendas(){
        try (Conexao conexao = new Conexao();
             Connection conectar = conexao.conecta();
             PreparedStatement preparar = conectar.prepareStatement("SELECT MAX(id_vendas) + 1 FROM vendas")) {
                ResultSet idVendas = preparar.executeQuery();
                if (idVendas.next()) {
                    return idVendas.getLong(1);
                }
        }catch(Exception e){
            System.out.println("Não foi possível gerar o ID de vendas! \n");
        }
        return 0;
    }



    private Produto produto(PreparedStatement preparar) {
        Produto produto = new Produto();
        try{
            ResultSet prod = preparar.executeQuery();
            while(prod.next()){
                        produto.setId(prod.getLong("id"));
                        produto.setNome(prod.getString("nome"));
                        produto.setValor(prod.getDouble("valor"));
                        produto.setEstoque(prod.getInt("estoque"));
            }
            return produto;
        } catch (SQLException e) {
            System.out.println("Erro na busca do estoque do produto! \n");
        }
        return produto;
    }
    private List<Produto> arrayList(PreparedStatement preparar){
        List<Produto> listaProduto = new ArrayList<>();
        try {
            ResultSet produtos = preparar.executeQuery();
            while(produtos.next()){
                Produto produto = new Produto(
                        produtos.getLong("id"),
                        produtos.getString("nome"),
                        produtos.getDouble("valor"),
                        produtos.getInt("estoque"));
                listaProduto.add(produto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaProduto;
    }

    private List<CarrinhoDeCompras> carrinhoArrayList(PreparedStatement preparar) {
        List<CarrinhoDeCompras> carrinhoDeCompras = new ArrayList<>();
        try{
            ResultSet carrinhos = preparar.executeQuery();
            while(carrinhos.next()){
                CarrinhoDeCompras produto = new CarrinhoDeCompras(
                        carrinhos.getLong("id_produto"),
                        carrinhos.getInt("quantidade"),
                        carrinhos.getInt("id_vendas")
                );
                carrinhoDeCompras.add(produto);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return carrinhoDeCompras;
    }

}
