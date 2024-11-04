package com.fintech;

import java.util.ArrayList;
import java.util.Scanner;

public class ObjetivoFinanceiro {
    private static ArrayList<Objetivo> objetivos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void adicionarObjetivo(String descricao, double valorObjetivo, double valorGuardado) {
        objetivos.add(new Objetivo(descricao, valorObjetivo, valorGuardado));
        System.out.println("Objetivo financeiro adicionado: " + descricao);
        System.out.println();
    }

    public static void removerObjetivo(String descricao) {
        objetivos.removeIf(objetivo -> objetivo.getDescricao().equals(descricao));
        System.out.println("Objetivo financeiro removido: " + descricao);
        System.out.println();
    }

    public static void editarObjetivo(String descricao, double novoValorObjetivo, double novoValorGuardado) {
        for (Objetivo objetivo : objetivos) {
            if (objetivo.getDescricao().equals(descricao)) {
                objetivo.setValorObjetivo(novoValorObjetivo);
                objetivo.setValorGuardado(novoValorGuardado);
                System.out.println("Objetivo financeiro editado: " + descricao);
                System.out.println();
                return;
            }
        }
        System.out.println("Objetivo financeiro não encontrado.");
        System.out.println();
    }

    public static void exibirObjetivos() {
        System.out.println("Objetivos financeiros:");
        for (Objetivo objetivo : objetivos) {
            double percentualConclusao = (objetivo.getValorGuardado() / objetivo.getValorObjetivo()) * 100;
            System.out.printf("Descrição: %s - Valor do objetivo: %.2f - Valor guardado: %.2f - Conclusão: %.2f%%%n",
                    objetivo.getDescricao(), objetivo.getValorObjetivo(), objetivo.getValorGuardado(), percentualConclusao);
        }
        System.out.println();
    }

    public static void menuObjetivosFinanceiros() {
        while (true) {
            System.out.println("1. Adicionar objetivo financeiro");
            System.out.println("2. Remover objetivo financeiro");
            System.out.println("3. Editar objetivo financeiro");
            System.out.println("4. Listar objetivos financeiros");
            System.out.println("5. Voltar");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Valor do objetivo: ");
                    double valorObjetivo = scanner.nextDouble();
                    System.out.print("Valor guardado: ");
                    double valorGuardado = scanner.nextDouble();
                    scanner.nextLine();
                    adicionarObjetivo(descricao, valorObjetivo, valorGuardado);
                    break;
                case 2:
                    System.out.print("Descrição do objetivo a remover: ");
                    String descricaoRemover = scanner.nextLine();
                    removerObjetivo(descricaoRemover);
                    break;
                case 3:
                    System.out.print("Descrição do objetivo a editar: ");
                    String descricaoEditar = scanner.nextLine();
                    System.out.print("Novo valor do objetivo: ");
                    double novoValorObjetivo = scanner.nextDouble();
                    System.out.print("Novo valor guardado: ");
                    double novoValorGuardado = scanner.nextDouble();
                    scanner.nextLine();
                    editarObjetivo(descricaoEditar, novoValorObjetivo, novoValorGuardado);
                    break;
                case 4:
                    exibirObjetivos();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
                    System.out.println();
            }
        }
    }
}
