package com.petconnect.service;

import com.petconnect.model.Animal;
import com.petconnect.model.Adotante;
import java.util.ArrayList;
import java.util.List;

public class AdocaoService {
    private List<Animal> bancoDeAnimais = new ArrayList<>();
    private List<Adotante> bancoDeAdotantes = new ArrayList<>();

    // NOVO: Lista para guardar o histórico
    private List<String> historicoAdocoes = new ArrayList<>();

    public void cadastrarAnimal(Animal animal) {
        bancoDeAnimais.add(animal);
        System.out.println("✅ Animal cadastrado: " + animal.getNome());
    }

    public void cadastrarAdotante(Adotante adotante) {
        bancoDeAdotantes.add(adotante);
        System.out.println("✅ Adotante cadastrado: " + adotante.getNome());
    }

    // LISTAGEM EM FORMATO DE TABELA
    public void listarDisponiveis() {
        System.out.println("\n----------------------------------------------------------------------");
        System.out.println("                     🐶 ANIMAIS DISPONÍVEIS 🐱");
        System.out.println("----------------------------------------------------------------------");
        // Cabeçalho da Tabela
        System.out.printf("| %-15s | %-10s | %-15s | %-10s |%n", "NOME", "TIPO", "RAÇA", "IDADE");
        System.out.println("|-----------------|------------|-----------------|------------|");

        boolean temAnimal = false;
        for (Animal a : bancoDeAnimais) {
            if (a.getStatus().equals("Disponível")) {
                // Descobre se é Cachorro ou Gato pelo nome da classe
                String tipo = a.getClass().getSimpleName();

                // Imprime as linhas da tabela formatadas
                System.out.printf("| %-15s | %-10s | %-15s | %-10s |%n",
                        a.getNome(), tipo, a.getRaca(), a.getIdade() + " anos");
                temAnimal = true;
            }
        }
        System.out.println("----------------------------------------------------------------------");

        if (!temAnimal) {
            System.out.println("(Nenhum animal disponível no momento)");
        }
    }

    // NOVO: Método para mostrar o Histórico
    public void listarHistorico() {
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("                  📜 HISTÓRICO DE ADOÇÕES");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("| %-20s | %-20s | %-10s |%n", "ANIMAL", "ADOTANTE", "STATUS");
        System.out.println("|----------------------|----------------------|------------|");

        if (historicoAdocoes.isEmpty()) {
            System.out.println("|              Nenhuma adoção realizada ainda              |");
        } else {
            for (String registro : historicoAdocoes) {
                System.out.println(registro);
            }
        }
        System.out.println("-------------------------------------------------------------");
    }

    public void realizarAdocao(String nomeAnimal, String nomeAdotante) {
        Animal animalEncontrado = null;
        for (Animal a : bancoDeAnimais) {
            if (a.getNome().equalsIgnoreCase(nomeAnimal)) {
                animalEncontrado = a;
                break;
            }
        }

        Adotante adotanteEncontrado = null;
        for (Adotante ad : bancoDeAdotantes) {
            if (ad.getNome().equalsIgnoreCase(nomeAdotante)) {
                adotanteEncontrado = ad;
                break;
            }
        }

        if (animalEncontrado == null) {
            System.out.println("❌ Erro: Animal não encontrado.");
            return;
        }
        if (adotanteEncontrado == null) {
            System.out.println("❌ Erro: Adotante não cadastrado.");
            return;
        }
        if (!animalEncontrado.getStatus().equals("Disponível")) {
            System.out.println("⚠️ Este animal já foi adotado!");
            return;
        }

        // Efetiva a adoção
        animalEncontrado.setStatus("Adotado");

        // Salva no Histórico formatado para a tabela
        String registro = String.format("| %-20s | %-20s | %-10s |",
                animalEncontrado.getNome(),
                adotanteEncontrado.getNome(),
                "CONCLUÍDO");
        historicoAdocoes.add(registro);

        System.out.println("🎉 SUCESSO! " + animalEncontrado.getNome() + " adotado por " + adotanteEncontrado.getNome());
    }
}