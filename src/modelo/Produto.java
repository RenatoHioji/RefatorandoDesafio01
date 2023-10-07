package modelo;

public class Produto {
    Long id;
    Double valor;
    String nome;
    int estoque;


    public Produto(Long id, String nome,Double  valor, int estoque) {
        super();
        this.id = id;
        this.valor = valor;
        this.nome = nome;
        this.estoque = estoque;
    }

    public Produto() {

    }

    public Produto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
        this.estoque = produto.getEstoque();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}
