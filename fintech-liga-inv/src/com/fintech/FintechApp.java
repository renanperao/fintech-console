package com.fintech;

import java.util.Scanner;

public class FintechApp {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean usuarioLogado = false;
    private static String usuarioAtual;

    public static void main(String[] args) {
        while (true) {
            mostrarMenuPrincipal();
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("1. Fazer login");
        System.out.println("2. Criar conta");
        System.out.println("3. Sair");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                fazerLogin();
                break;
            case 2:
                criarConta();
                break;
            case 3:
                System.out.println("Saindo do programa...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void fazerLogin() {
        System.out.print("Usuário: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        if (Usuario.fazerLogin(username, password)) {
            usuarioLogado = true;
            usuarioAtual = username;
            System.out.println("Login bem-sucedido.");
            mostrarMenuPrincipalLogado();
        } else {
            System.out.println("Usuário ou senha inválidos.");
        }
    }

    private static void criarConta() {
        System.out.print("Novo usuário: ");
        String username = scanner.nextLine();
        System.out.print("Nova senha: ");
        String password = scanner.nextLine();

        if (Usuario.criarConta(username, password)) {
            System.out.println("Conta criada com sucesso. Faça login para continuar.");
        }
    }

    private static void mostrarMenuPrincipalLogado() {
        while (usuarioLogado) {
            System.out.println("1. Acessar página de receitas");
            System.out.println("2. Acessar página de despesas");
            System.out.println("3. Acessar página de investimentos");
            System.out.println("4. Acessar objetivos financeiros");
            System.out.println("5. Encerrar programa");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    Receita.menuReceitas();
                    break;
                case 2:
                    Despesa.menuDespesas();
                    break;
                case 3:
                    Investimento.menuInvestimentos();
                    break;
                case 4:
                    ObjetivoFinanceiro.menuObjetivosFinanceiros();
                    break;
                case 5:
                    usuarioLogado = false;
                    System.out.println("Encerrando sessão...");
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    System.out.println();
            }
        }
    }
}
