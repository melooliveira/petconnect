package com.petconnect.model;

public class Cachorro extends Animal {
    private String porte;

    public Cachorro(String nome, int idade, String raca, String porte) {
        super(nome, idade, raca);
        this.porte = porte;
    }

    @Override
    public String getDescricaoDetalhada() {
        return "🐶 Cachorro: " + getDescricaoBase() + ", Porte: " + porte;
    }
}