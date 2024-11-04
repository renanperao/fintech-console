package com.fintech;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private static Map<String, String> usuarios = new HashMap<>();
    private String username;
    private String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static boolean criarConta(String username, String password) {
        if (usuarios.containsKey(username)) {
            System.out.println("Usuário já existe.");
            return false;
        }
        usuarios.put(username, password);
        return true;
    }

    public static boolean fazerLogin(String username, String password) {
        return usuarios.containsKey(username) && usuarios.get(username).equals(password);
    }
}
