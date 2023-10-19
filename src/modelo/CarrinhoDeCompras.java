package modelo;

public class CarrinhoDeCompras {
    Long idProduto;
    int quantidade;
    int id_vendas;
    Produto produto;

    public CarrinhoDeCompras() {

    }
    public int getId_vendas() {
        return id_vendas;
    }
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public CarrinhoDeCompras(Long idProduto, int quantidade, int id_vendas) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.id_vendas = id_vendas;
    }
    public CarrinhoDeCompras(Long idProduto, int quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }
}
