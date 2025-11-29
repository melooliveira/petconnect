package com.petconnect.model;

public abstract class Animal {
    private String nome;
    private int idade;
    private String raca;
    private String status; // Disponível, Adotado

    public Animal(String nome, int idade, String raca) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.status = "Disponível";
    }

    // --- GETTERS E SETTERS CORRIGIDOS (Implementando Regra 01: Encapsulamento) ---
    public String getNome() { return nome; }

    // NOVO: Getters que faltavam e estavam dando erro de "cannot find symbol"
    public int getIdade() { return idade; }
    public String getRaca() { return raca; }
    // -----------------------------------------------------------------------------

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Método auxiliar para as filhas usarem
    public String getDescricaoBase() {
        return "Nome: " + nome + ", Idade: " + idade + ", Raça: " + raca + ", Status: " + status;
    }

    public abstract String getDescricaoDetalhada();
}