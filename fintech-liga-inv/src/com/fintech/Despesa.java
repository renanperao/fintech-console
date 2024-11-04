package com.fintech;

import java.util.ArrayList;
import java.util.Scanner;

public class Despesa extends Transacao {
    private static ArrayList<Transacao> despesas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Despesa(String descricao, double valor) {
        super(descricao, valor);
    }

    public void adicionarDespesa() {
        despesas.add(this);
        System.out.println("Despesa adicionada: " + descricao + " - Valor: " + valor);
    }

    public static void removerDespesa(String descricao) {
        despesas.removeIf(despesa -> despesa.getDescricao().equals(descricao));
        System.out.println("Despesa removida: " + descricao);
    }

    public static void editarDespesa(String descricao, double novoValor) {
        for (Transacao despesa : despesas) {
            if (despesa.getDescricao().equals(descricao)) {
                despesa.setValor(novoValor);
                System.out.println("Despesa editada: " + descricao + " - Novo valor: " + novoValor);
                return;
            }
        }
        System.out.println("Despesa não encontrada.");
    }

    public static void exibirDespesas() {
        System.out.println("Despesas:");
        for (Transacao despesa : despesas) {
            System.out.println(despesa.getDescricao() + ": " + despesa.getValor());
        }
    }

    public static void menuDespesas() {
        while (true) {
            System.out.println("1. Adicionar despesa");
            System.out.println("2. Remover despesa");
            System.out.println("3. Editar despesa");
            System.out.println("4. Listar despesas");
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
                    Despesa despesa = new Despesa(descricao, valor);
                    despesa.adicionarDespesa();
                    break;
                case 2:
                    System.out.print("Descrição da despesa a remover: ");
                    String descricaoRemover = scanner.nextLine();
                    Despesa.removerDespesa(descricaoRemover);
                    break;
                case 3:
                    System.out.print("Descrição da despesa a editar: ");
                    String descricaoEditar = scanner.nextLine();
                    System.out.print("Novo valor: ");
                    double novoValor = scanner.nextDouble();
                    scanner.nextLine();
                    Despesa.editarDespesa(descricaoEditar, novoValor);
                    break;
                case 4:
                    Despesa.exibirDespesas();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
