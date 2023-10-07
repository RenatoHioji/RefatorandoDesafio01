package servico;

import modelo.Produto;

import java.util.Scanner;

public class Leitor {

    public Leitor() {

    }

    public Produto lerNovoProduto(){
        Produto produto = new Produto();
        try(Scanner leitura = new Scanner(System.in)){
            System.out.println("Digite o ID do produto: ");
            produto.setId(Long.parseLong(leitura.nextLine()));
            System.out.println("\n Digite o nome do produto: ");
            produto.setNome(leitura.nextLine());
            System.out.println("\n Digite o valor do produto: ");
            produto.setValor(Double.parseDouble(leitura.nextLine()));
            System.out.println("\n Digite o estoque do produto: ");
            produto.setEstoque(Integer.parseInt(leitura.nextLine()));
        }catch(RuntimeException e){
            System.out.println("Não foi possível adicionar um novo produto");
        }
        return produto;
    }

    public Long lerIdExcluir(){
        Long idExcluir = 0L;
        try(Scanner leitura = new Scanner(System.in)){
            System.out.println("Digite o ID do produto a ser excluído: ");
            idExcluir = Long.parseLong(leitura.nextLine());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        return idExcluir;
    }


    public String lerOpcao() {
        String opcao = "";
        try(Scanner leitura = new Scanner(System.in)){
            System.out.println("Seja bem-vindo!");
            System.out.println("Este é o nosso sistema de e-commerce!");
            System.out.println("Para começar, selecione uma das funções abaixo: \n"
                    + "1. Listar todos os produtos \n"
                    + "2. Quero cadastrar um novo produto! \n"
                    + "3. Irei remover um produto já existente! \n"
                    + "4. Tive uma nova ideia e irei atualizar um de nossos produtos! \n"
                    + "5. Irei realizar compras \n"
                    + "6. Sair");
            opcao = leitura.nextLine();
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        return opcao;
    }


    public Long lerIdAtualizar() {
        Long idAtualizar = 0L;
        try(Scanner leitura = new Scanner(System.in)){
            System.out.println("Digite o ID do produto a ser atualizado: ");
            idAtualizar = Long.parseLong(leitura.nextLine());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        return idAtualizar;
    }

    public Produto lerAtualizarProduto() {
        Produto produto = new Produto();
        try(Scanner leitura = new Scanner(System.in)){
            System.out.println("Digite o novo ID do produto: ");
            produto.setId(Long.parseLong(leitura.nextLine()));
            System.out.println("\n Digite o novo nome do produto: ");
            produto.setNome(leitura.nextLine());
            System.out.println("\n Digite o novo valor do produto: ");
            produto.setValor(Double.parseDouble(leitura.nextLine()));
            System.out.println("\n Digite o novo estoque do produto: ");
            produto.setEstoque(Integer.parseInt(leitura.nextLine()));
        }catch(RuntimeException e){
            System.out.println("Não foi possível adicionar um novo produto");
        }
        return produto;
    }
}
