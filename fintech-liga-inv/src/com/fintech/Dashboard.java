package com.fintech;

import java.util.ArrayList;

public class Dashboard {
    private String usuario;
    private ArrayList<String> notificacoes = new ArrayList<>();

    public Dashboard(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ArrayList<String> getNotificacoes() {
        return notificacoes;
    }

    public void adicionarNotificacao(String notificacao) {
        notificacoes.add(notificacao);
    }

    public void acessarPerfil() {
        System.out.println("Acessando perfil do usuário: " + usuario);
    }

    public void acessarNotificacoes() {
        System.out.println("Notificações:");
        for (String notificacao : notificacoes) {
            System.out.println(notificacao);
        }
    }
}
