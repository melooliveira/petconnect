package com.petconnect.model;

public class Gato extends Animal {
    private String nivelPelo;

    public Gato(String nome, int idade, String raca, String nivelPelo) {
        super(nome, idade, raca);
        this.nivelPelo = nivelPelo;
    }

    @Override
    public String getDescricaoDetalhada() {
        return "🐱 Gato: " + getDescricaoBase() + ", Pelo: " + nivelPelo;
    }
}