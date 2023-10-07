package repositorio;

import conexao.Conexao;
import modelo.Produto;
import repositorio.interfaces.IRepositorioProduto;

import java.sql.*;

public class RepositorioProduto implements IRepositorioProduto {
    private Connection conectar;
    private Statement declaracao;

    @Override
    public void adicionarProduto(Produto produto){
        try(Conexao conexao = new Conexao()){
            String query = "INSERT INTO produtos (id, nome, valor, estoque) VALUES (?, ?, ?, ?)";
            PreparedStatement preparar = conectar.prepareStatement(query);
            preparar.setLong(1, produto.getId());
            preparar.setString(2, produto.getNome());
            preparar.setDouble(3, produto.getValor());
            preparar.setInt(4, produto.getEstoque());
            preparar.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removerProduto(Long idProduto){
        try(Conexao conexao = new Conexao()){
            conectar = conexao.conecta();
            String query = "DELETE FROM produtos WHERE id = ?";
            PreparedStatement preparar = conectar.prepareStatement(query);
            preparar.setLong(1, idProduto);
            preparar.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizarProduto(Long idProduto, Produto produto) {
        try(Conexao conexao = new Conexao()){
            conectar = conexao.conecta();
            String query = "UPDATE produtos SET id = ?, nome = ?, valor = ?, estoque = ? WHERE id = ?";
            PreparedStatement preparar = conectar.prepareStatement(query);
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
    public ResultSet verProdutos(){
        try(Conexao conexao = new Conexao()){
            conectar = conexao.conecta();
            String query = "SELECT * FROM produtos";
            PreparedStatement preparar = conectar.prepareStatement(query);
            return preparar.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet filtrarProdutos(String nome) {
        ResultSet resultado = null;
        try(Conexao conexao = new Conexao()){
            conectar = conexao.conecta();
            String query = "SELECT * FROM produtos WHERE nome = ?";
            PreparedStatement preparar = conectar.prepareStatement(query);
            preparar.setString(1, nome);
            resultado = preparar.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }


    @Override
    public ResultSet verificarExistenciaProduto(Long idProduto) {
        ResultSet resultado = null;
        try(Conexao conexao = new Conexao()){
            conectar = conexao.conecta();
            String query = "SELECT * FROM produtos WHERE id = ?";
            PreparedStatement preparar = conectar.prepareStatement(query);
            preparar.setLong(1, idProduto);
            resultado = preparar.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }
}
