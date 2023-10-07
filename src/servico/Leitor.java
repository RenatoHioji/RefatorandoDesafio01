package servico;

import modelo.Produto;
import java.util.Scanner;

public class Leitor {
    Scanner leitura = new Scanner(System.in);

    public Leitor() {

    }
    public String lerOpcao() {
        String opcao = "";
        try{
            System.out.println("Seja bem-vindo!");
            System.out.println("Este é o nosso sistema de e-commerce!");
            System.out.println("""
                    Para começar, selecione uma das funções abaixo:\s
                    1. Listar todos os produtos\s
                    2. Quero cadastrar um novo produto!\s
                    3. Irei remover um produto já existente!\s
                    4. Tive uma nova ideia e irei atualizar um de nossos produtos!\s
                    5. Irei realizar compras\s
                    6. Sair""");
            opcao = leitura.nextLine();
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        return opcao;
    }

    public Produto lerNovoProduto() {
        Produto produto = new Produto();
        try {
            produto.setId(this.lerId());
            produto.setNome(this.lerNome());
            produto.setEstoque(this.lerEstoque());
            produto.setValor(this.lerValor());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return produto;
    }

    public Produto lerAtualizarProduto() {
        Produto produto = new Produto();
        try{
            produto.setId(this.lerId());
            produto.setNome(this.lerNome());
            produto.setEstoque(this.lerEstoque());
            produto.setValor(this.lerValor());
        }catch(RuntimeException e){
            System.out.println("Não foi possível adicionar um novo produto");
        }
        return produto;
    }

    public Long lerId() {
        System.out.println("Digite o ID do produto: ");
        while(true){
            try{
                return Long.parseLong(leitura.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Número inváldio. Por favor, digite um número");
            }
        }
    }
    public String lerNome() {
        System.out.println("Digite o nome do produce: ");
        return leitura.nextLine();
    }

    public Double lerValor() {
        System.out.println("Digite o valor do produto: ");
        while(true) {
            try {
                return Double.parseDouble(leitura.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Número ínválido. Por favor, digite um valor válido.");
            }
        }
    }
    public Integer lerEstoque(){
        System.out.println("Digite o estoque do produto: ");
        while(true){
            try{
                return Integer.parseInt(leitura.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Estoque inválido. Por favor, digite um número válido.");
            }
        }

    }
    public Long lerIdExcluir() {
        try{
            System.out.println("Digite o ID do produto a ser excluído: ");
            while (true) {
                try {
                    return Long.parseLong(leitura.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ID inválido. Por favor, digite um número válido.");
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Não foi possível ler o ID.");
        }
        return 0L;
    }

    public Long lerIdAtualizar() {
        try{
            System.out.println("Digite o ID do produto a ser atualizado: ");
            while(true){
                try{
                    return Long.parseLong(leitura.nextLine());
                }catch(NumberFormatException e){
                    System.out.println("ID inválido. Por favor, digite um número valido.");
                }
            }
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        return 0L;
    }

    public void fecharScanner(){
        leitura.close();
    }
}
