package com.fintech;

import java.util.ArrayList;
import java.util.Scanner;

public class Receita extends Transacao {
    private static ArrayList<Transacao> receitas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Receita(String descricao, double valor) {
        super(descricao, valor);
    }

    public void adicionarReceita() {
        receitas.add(this);
        System.out.println("Receita adicionada: " + descricao + " - Valor: " + valor);
    }

    public static void removerReceita(String descricao) {
        receitas.removeIf(receita -> receita.getDescricao().equals(descricao));
        System.out.println("Receita removida: " + descricao);
    }

    public static void editarReceita(String descricao, double novoValor) {
        for (Transacao receita : receitas) {
            if (receita.getDescricao().equals(descricao)) {
                receita.setValor(novoValor);
                System.out.println("Receita editada: " + descricao + " - Novo valor: " + novoValor);
                return;
            }
        }
        System.out.println("Receita não encontrada.");
    }

    public static void exibirReceitas() {
        System.out.println("Receitas:");
        for (Transacao receita : receitas) {
            System.out.println(receita.getDescricao() + ": " + receita.getValor());
        }
    }

    public static void menuReceitas() {
        while (true) {
            System.out.println("1. Adicionar receita");
            System.out.println("2. Remover receita");
            System.out.println("3. Editar receita");
            System.out.println("4. Listar receitas");
            System.out.println("5. Voltar");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (escolha) {
                case 1:
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Valor: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Limpar buffer
                    Receita receita = new Receita(descricao, valor);
                    receita.adicionarReceita();
                    break;
                case 2:
                    System.out.print("Descrição da receita a remover: ");
                    String descricaoRemover = scanner.nextLine();
                    Receita.removerReceita(descricaoRemover);
                    break;
                case 3:
                    System.out.print("Descrição da receita a editar: ");
                    String descricaoEditar = scanner.nextLine();
                    System.out.print("Novo valor: ");
                    double novoValor = scanner.nextDouble();
                    scanner.nextLine(); // Limpar buffer
                    Receita.editarReceita(descricaoEditar, novoValor);
                    break;
                case 4:
                    Receita.exibirReceitas();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
