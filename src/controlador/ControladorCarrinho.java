package controlador;

import controlador.interfaces.IControladorCarrinho;
import servico.ServicoCarrinho;
public class ControladorCarrinho implements IControladorCarrinho {

    private final ServicoCarrinho servicoCarrinho = new ServicoCarrinho();
    public ControladorCarrinho() {

    }
    @Override
    public void iniciarCarrinho() {
        String opcaoCarrinho = "1";
        while(!opcaoCarrinho.equals("9")){
            opcaoCarrinho = servicoCarrinho.iniciarCarrinho();
            switch(opcaoCarrinho){
                case "1":
                    servicoCarrinho.mostrarProdutos();
                    break;
                case "2":
                    servicoCarrinho.filtrarProdutos();
                    break;
                case"3":
                    servicoCarrinho.adicionarCarrinhoProduto();
                    break;
                case "4":
                    servicoCarrinho.removerCarrinhoProduto();
                    break;
                case"5":
                    servicoCarrinho.atualizarCarrinho();
                    break;
                case "6":
                    servicoCarrinho.verCarrinho();
                    break;
                case"7":
                    servicoCarrinho.finalizarCompra();
                    break;
                case "8":
                    servicoCarrinho.mostrarCompras();
                    break;
                default:
                    System.out.println("Voltando...");
                    break;
            }
        }
}

    public void fecharScanner() {
        servicoCarrinho.fecharScanner();
    }
}
