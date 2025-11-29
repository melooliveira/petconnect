package com.petconnect;

import com.petconnect.model.Cachorro;
import com.petconnect.model.Gato;
import com.petconnect.model.Adotante;
import com.petconnect.service.AdocaoService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Inicializa o sistema vazio
        AdocaoService sistema = new AdocaoService();
        boolean rodando = true;

        System.out.println("=== 🐾 SISTEMA PETCONNECT INICIADO (Base Limpa) 🐾 ===");

        while (rodando) {
            System.out.println("\n-------------------------------------------------------------");
            System.out.println("MENU PRINCIPAL:");
            System.out.println("1 - Cadastrar Cachorro");
            System.out.println("2 - Cadastrar Gato");
            System.out.println("3 - Cadastrar Adotante");
            System.out.println("4 - Listar Animais Disponíveis (TABELA)");
            System.out.println("5 - Realizar Adoção");
            System.out.println("6 - Ver Histórico de Adoções (TABELA)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            // Tratamento para evitar erro se digitar letra em vez de número
            if (!scanner.hasNextInt()) {
                System.out.println("❌ Por favor, digite apenas números.");
                scanner.next(); // Limpa o buffer
                continue;
            }

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o "Enter" do teclado

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastro de Cachorro ---");
                    System.out.print("Nome: ");
                    String nomeCao = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeCao = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.print("Raça: ");
                    String racaCao = scanner.nextLine();
                    System.out.print("Porte (Pequeno/Médio/Grande): ");
                    String porte = scanner.nextLine();

                    sistema.cadastrarAnimal(new Cachorro(nomeCao, idadeCao, racaCao, porte));
                    break;

                case 2:
                    System.out.println("\n--- Cadastro de Gato ---");
                    System.out.print("Nome: ");
                    String nomeGato = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeGato = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.print("Raça: ");
                    String racaGato = scanner.nextLine();
                    System.out.print("Tipo de Pelo (Curto/Longo): ");
                    String pelo = scanner.nextLine();

                    sistema.cadastrarAnimal(new Gato(nomeGato, idadeGato, racaGato, pelo));
                    break;

                case 3:
                    System.out.println("\n--- Cadastro de Adotante ---");
                    System.out.print("Nome: ");
                    String nomeAdotante = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String fone = scanner.nextLine();

                    sistema.cadastrarAdotante(new Adotante(nomeAdotante, fone));
                    break;

                case 4:
                    sistema.listarDisponiveis();
                    break;

                case 5:
                    System.out.println("\n--- Nova Adoção ---");
                    System.out.print("Digite o Nome do Animal: ");
                    String animalAlvo = scanner.nextLine();
                    System.out.print("Digite o Nome do Adotante: ");
                    String pessoaAlvo = scanner.nextLine();

                    sistema.realizarAdocao(animalAlvo, pessoaAlvo);
                    break;

                case 6:
                    sistema.listarHistorico();
                    break;

                case 0:
                    rodando = false;
                    System.out.println("Encerrando o sistema... Até mais! 👋");
                    break;

                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}