package utilidade;

import servico.ServicoTela;

import java.util.Objects;


public class TelaPrincipal {
    private final ServicoTela servicoTela = new ServicoTela();
    public void mostrarMenu() throws Exception {
        String opcao = null;

        while (!Objects.equals(opcao, "6")) {
            opcao = servicoTela.mostrarOpcoes();
            switch (opcao) {
                case "1":
                    servicoTela.opcao1();
                    break;
                case "2":
                    servicoTela.opcao2();
                    break;
                case "3":
                    servicoTela.opcao3();
                    break;
                case "4":
                    servicoTela.opcao4();
                    break;
                case "5":
                    servicoTela.opcao5();
                    break;
                case "6":
                    servicoTela.fecharScanner();
                    System.out.println("Deslingando...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida! \n");
                    break;
            }
        }
    }
}
