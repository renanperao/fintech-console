package com.fintech;

import java.util.ArrayList;
import java.util.Scanner;

public class Investimento {
    private static ArrayList<Transacao> investimentos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void adicionarInvestimento(String descricao, double valor) {
        investimentos.add(new Transacao(descricao, valor));
        System.out.println("Investimento adicionado: " + descricao + " - Valor: " + valor);
    }

    public static void removerInvestimento(String descricao) {
        investimentos.removeIf(investimento -> investimento.getDescricao().equals(descricao));
        System.out.println("Investimento removido: " + descricao);
    }

    public static void editarInvestimento(String descricao, double novoValor) {
        for (Transacao investimento : investimentos) {
            if (investimento.getDescricao().equals(descricao)) {
                investimento.setValor(novoValor);
                System.out.println("Investimento editado: " + descricao + " - Novo valor: " + novoValor);
                return;
            }
        }
        System.out.println("Investimento não encontrado.");
    }

    public static void exibirInvestimentos() {
        System.out.println("Investimentos:");
        for (Transacao investimento : investimentos) {
            System.out.println(investimento.getDescricao() + ": " + investimento.getValor());
        }
    }

    public static void menuInvestimentos() {
        while (true) {
            System.out.println("1. Adicionar investimento");
            System.out.println("2. Remover investimento");
            System.out.println("3. Editar investimento");
            System.out.println("4. Listar investimentos");
            System.out.println("5. Voltar");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Valor: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();
                    Investimento.adicionarInvestimento(descricao, valor);
                    break;
                case 2:
                    System.out.print("Descrição do investimento a remover: ");
                    String descricaoRemover = scanner.nextLine();
                    Investimento.removerInvestimento(descricaoRemover);
                    break;
                case 3:
                    System.out.print("Descrição do investimento a editar: ");
                    String descricaoEditar = scanner.nextLine();
                    System.out.print("Novo valor: ");
                    double novoValor = scanner.nextDouble();
                    scanner.nextLine();
                    Investimento.editarInvestimento(descricaoEditar, novoValor);
                    break;
                case 4:
                    Investimento.exibirInvestimentos();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
