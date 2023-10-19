package utilidade;

import modelo.CarrinhoDeCompras;
import java.util.Scanner;

public class LeitorCarrinho {

    private Scanner leitura = new Scanner(System.in);
    public CarrinhoDeCompras adicionarCarrinhoProduto() {
        return new CarrinhoDeCompras(this.lerIdProduto(), this.lerQuantidade());
    }

    private int lerQuantidade() {
        while(true) {
            System.out.println("Digite a quantidade do produto: ");
            try {
                return Integer.parseInt(leitura.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Quantidade inválida. Digite novamente.");
            }
        }
    }

    public Long removerCarrinhoProduto() {
        System.out.println("Digite o ID do produto a ser removido do carrinho: ");
        while(true){
            try{
                return Long.parseLong(leitura.nextLine());
            }catch(NumberFormatException e){
            System.out.println("Número inválido.");
            }
        }
    }

    public String lerIniciar() {
        System.out.println("Seja bem-vindo ao carrinho de compras, para continuar selecione uma das opções abaixo: \n"
                + "1. Buscar por todos os produtos cadastrados. \n"
                + "2. Buscar um produto específico por nome. \n"
                + "3. Adicionar produto ao meu carrinho. \n"
                + "4. Remover produto ao meu carrinho. \n"
                + "5. Atualizar um produto do meu carrinho. \n"
                + "6. Ver meu carrinho. \n"
                + "7. Finalizar compra. \n"
                + "8. Mostrar mihnas compras. \n"
                + "9. Sair. \n");
        return leitura.nextLine();
    }

    public String lerNome() {
        System.out.println("Digite o nome para filtrar os produtos: ");
        return leitura.nextLine();
    }
    public Long lerIdProduto(){
        System.out.println("Digite o ID do produto a ser adicionado no carrinho: ");
        while(true){
            try {
                return Long.parseLong(leitura.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Número de ID inválido. Digite novamente.");
            }
        }
    }

    public void fecharScanner(){
        leitura.close();
    }

    public Long lerIdAtualizar() {
        System.out.println("Digite o ID do produto a ser atualizado: ");
        while(true){
            try{
                return Long.parseLong(leitura.nextLine());
            }catch(NumberFormatException e){
                System.out.println("ID inválido, tente novamente.");
            }
        }

    }

    public CarrinhoDeCompras atualizarCarrinhoProduto(Long id) {
        return new CarrinhoDeCompras(id, this.lerProdutoQuantidadeAtualizar());
    }

    private Integer lerProdutoQuantidadeAtualizar() {
        System.out.println("Digite a quantidade nova desse produto!");
        while(true){
            try{
                return Integer.parseInt(leitura.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Digite uma quantidade válida!");
            }
        }
    }

    public String confirmarCompra() {
        System.out.println("Deseja Finalizar a Compra? \n1. Sim \n2. Não");
        return leitura.nextLine();
    }
}
