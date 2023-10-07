package modelo;

import servico.ServicoTela;

import java.util.Scanner;

public class TelaPrincipal {
    public void mostrarMenu() throws Exception {
        String opcao = null;
        ServicoTela servicoTela = new ServicoTela();

        while (opcao != "6") {
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
                default:
                    System.out.println("Desligando...");
                    System.exit(0);
            }

        }
    }
}
