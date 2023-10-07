package repositorio;

import conexao.Conexao;
import modelo.Produto;
import repositorio.interfaces.IRepositorioProduto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioProduto implements IRepositorioProduto {

    @Override
    public void adicionarProduto(Produto produto){
        try(Conexao conexao = new Conexao();
            Connection conectar = conexao.conecta();
            PreparedStatement preparar = conectar.prepareStatement("INSERT INTO produtos (id, nome, valor, estoque) VALUES (?, ?, ?, ?)")){

            preparar.setLong(1, produto.getId());
            preparar.setString(2, produto.getNome());
            preparar.setDouble(3, produto.getValor());
            preparar.setInt(4, produto.getEstoque());
            preparar.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removerProduto(Long idProduto){
        try(Conexao conexao = new Conexao();
            Connection conectar = conexao.conecta();
            PreparedStatement preparar = conectar.prepareStatement("DELETE FROM produtos WHERE id = ?")){


            preparar.setLong(1, idProduto);
            preparar.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizarProduto(Long idProduto, Produto produto) {
        try(Conexao conexao = new Conexao();
            Connection conectar = conexao.conecta();
            PreparedStatement preparar = conectar.prepareStatement("UPDATE produtos SET id = ?, nome = ?, valor = ?, estoque = ? WHERE id = ?")){

            preparar.setLong(1, idProduto);
            preparar.setString(2, produto.getNome());
            preparar.setDouble(3, produto.getValor());
            preparar.setInt(4, produto.getEstoque());
            preparar.setLong(5, idProduto);
            preparar.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Produto> verProdutos(){
        try(Conexao conexao = new Conexao();
            Connection conectar = conexao.conecta();
            PreparedStatement preparar = conectar.prepareStatement("SELECT * FROM produtos")){

            return this.arrayList(preparar);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Produto> arrayList(PreparedStatement preparar) {
            ResultSet produtos = null;
            List<Produto> listaProduto = new ArrayList<>();
            try {
                produtos = preparar.executeQuery();
                while(produtos.next()){
                    Produto produto = new Produto(
                            produtos.getLong("id"),
                            produtos.getString("nome"),
                            produtos.getDouble("valor"),
                            produtos.getInt("estoque"));

                    listaProduto.add(produto);
                }
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return listaProduto;
    }

    @Override
    public List<Produto> filtrarProdutos(String nome) {
        try(Conexao conexao = new Conexao();
        Connection conectar = conexao.conecta();
        PreparedStatement preparar = conectar.prepareStatement("SELECT * FROM produtos WHERE nome = ?")){

            preparar.setString(1, nome);
            return this.arrayList(preparar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }


    @Override
    public List<Produto> verificarExistenciaProduto(Long idProduto) {
        try(Conexao conexao = new Conexao();
            Connection conectar = conexao.conecta();
            PreparedStatement preparar = conectar.prepareStatement("SELECT * FROM produtos WHERE id = ?")){

            preparar.setLong(1, idProduto);
            return this.arrayList(preparar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
