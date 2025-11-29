# 🐾 PetConnect - Sistema de Gestão de Adoções
O PetConnect é um sistema desenvolvido em Java para auxiliar ONGs e abrigos de animais a centralizar o cadastro de animais e registrar pessoas interessadas na adoção. O objetivo é criar uma "ponte" digital entre o abrigo e o adotante, garantindo transparência e controle no processo.


# 📋 Sobre o Projeto
Atualmente, o processo de divulgação de animais é descentralizado e o controle é manual, gerando informações desencontradas. O PetConnect soluciona isso gerenciando o ciclo de vida da adoção, garantindo que animais já adotados não apareçam disponíveis para novos tutores.


Este projeto foi desenvolvido como requisito avaliativo da disciplina de Linguagem de Programação I, focado na aplicação prática dos pilares da Orientação a Objetos.


# 🚀 Funcionalidades
O sistema opera via terminal (CLI) com um menu interativo e tabelas formatadas, atendendo aos seguintes requisitos:


Cadastro de Animais: Registro de Cachorros e Gatos com características específicas (Herança/Polimorfismo).

Cadastro de Adotantes: Registro de interessados com nome e telefone.


Listagem de Disponíveis: Visualização em tabela apenas dos animais com status "Disponível".

Processo de Adoção: Vínculo entre um adotante e um animal, com validação de regras de negócio.

Histórico de Adoções: Registro auditável de todas as adoções realizadas com sucesso.


Controle de Status: Atualização automática do status do animal para "Adotado" após o sucesso da operação.

# 🛠️ Tecnologias e Estrutura
Linguagem: Java (JDK 17+)

IDE: IntelliJ IDEA

Arquitetura: Organização em camadas (simulando padrão Spring Boot):

model: Classes de domínio (Animal, Cachorro, Gato, Adotante).

service: Regras de negócio e gerenciamento de listas.

Main: Interação com o usuário (Menu).

Estrutura de Diretórios
Bash
```
src/
└── com.petconnect
    ├── Main.java            # Ponto de entrada (Menu Interativo)
    ├── model
    │   ├── Animal.java      # Classe Abstrata (Encapsulamento)
    │   ├── Cachorro.java    # Herança e Polimorfismo
    │   ├── Gato.java        # Herança e Polimorfismo
    │   └── Adotante.java    # Objeto de domínio
    └── service
        └── AdocaoService.java # Lógica e Regras de Negócio
```

# 📚 Conceitos de OO Aplicados
O projeto implementa rigorosamente as regras de negócio solicitadas:


Encapsulamento: Todos os atributos são privados (private) e acessados via métodos públicos (getters/setters).


Herança: As classes Cachorro e Gato herdam atributos comuns da classe abstrata Animal.


Polimorfismo: O método getDescricaoDetalhada() é sobrescrito nas classes filhas para exibir comportamentos específicos.

Abstração: Uso de classe abstrata para impedir a instância de um "Animal" genérico.

# ▶️ Como Executar
Pré-requisitos: Ter o Java (JDK) instalado.

Clonar o repositório:

Bash

git clone https://github.com/melooliveira/petconnect.git
Abrir no IntelliJ:

Abra o IntelliJ IDEA.

Vá em File > Open e selecione a pasta do projeto.

Rodar:

Abra o arquivo src/com/petconnect/Main.java.

Clique no botão de Play (verde) ao lado do método main.

# ✒️ Autor

João Victor de Oliveira Melo - Desenvolvimento e Documentação.