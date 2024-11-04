package com.fintech;

public class Objetivo {
    private String descricao;
    private double valorObjetivo;
    private double valorGuardado;

    public Objetivo(String descricao, double valorObjetivo, double valorGuardado) {
        this.descricao = descricao;
        this.valorObjetivo = valorObjetivo;
        this.valorGuardado = valorGuardado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorObjetivo() {
        return valorObjetivo;
    }

    public void setValorObjetivo(double valorObjetivo) {
        this.valorObjetivo = valorObjetivo;
    }

    public double getValorGuardado() {
        return valorGuardado;
    }

    public void setValorGuardado(double valorGuardado) {
        this.valorGuardado = valorGuardado;
    }
}
