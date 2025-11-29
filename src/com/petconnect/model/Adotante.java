package com.petconnect.model;

public class Adotante {
    private String nome;
    private String telefone;

    public Adotante(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "Adotante: " + nome + " (Tel: " + telefone + ")";
    }
}