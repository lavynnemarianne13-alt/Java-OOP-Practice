# RPG Combat System

*[Read in English](./README.md)*

Um simulador de combate por turnos construído em Java para praticar princípios fundamentais de Programação Orientada a Objetos: construtores, encapsulamento e colaboração entre objetos da mesma classe.

Este projeto faz parte de uma trilha estruturada de estudo de Java/OOP, focada em aplicar conceitos a cenários realistas com regras de negócio, em vez de exercícios isolados de sintaxe.

## Visão Geral

Dois magos se enfrentam em um duelo por turnos. Cada mago pertence a um de três elementos — **Fogo**, **Água** ou **Terra** — que interagem em um ciclo no estilo pedra-papel-tesoura:

- Fogo é forte contra Terra
- Terra é forte contra Água
- Água é forte contra Fogo

Quando um mago lança um feitiço, a relação elemental determina se o feitiço causa dano bônus (1.5x), dano reduzido (0.5x), ou dano normal (1.0x, em confrontos do mesmo elemento).

## Conceitos Demonstrados

- **Encapsulamento** — `life` e `mana` são atributos privados. Eles só podem ser alterados através de métodos validados (`castSpellOn`, `restoreMana`); não há forma de defini-los diretamente de fora da classe.
- **Colaboração entre objetos** — `castSpellOn(Wizard other)` mostra como um método de instância pode ler e modificar o estado de *outra* instância da mesma classe, não apenas a si mesmo.
- **Programação defensiva / regras de negócio**:
  - Um feitiço custa 10 de mana. Se o lançador não tiver mana suficiente, o feitiço falha silenciosamente — nenhuma mana é gasta e nenhum dano é causado.
  - A vida de um mago nunca pode ficar abaixo de zero, independentemente do dano causado.
  - `restoreMana` só aceita valores positivos; valores zero ou negativos são rejeitados.
- **Estruturas de controle** — o loop de combate usa `for` para iterar os turnos (com saída antecipada via `break` quando um mago é derrotado), `if/else` para alternar qual mago ataca, e `while` para validar a entrada do usuário na etapa de restauração de mana.

## Diagrama de Classe

```
┌─────────────────────────────────────┐
│              Wizard                  │
├─────────────────────────────────────┤
│ - name : String                     │
│ - element : String                  │
│ - mana : int                        │
│ - damage : int                      │
│ - life : double                     │
├─────────────────────────────────────┤
│ + castSpellOn(other: Wizard) : void │
│ + restoreMana(amount: int) : void   │
│ + getName() : String                │
│ + getLife() : double                │
│ + getElement() : String             │
└─────────────────────────────────────┘
```

## Como Executar

```bash
javac Rpg.java Wizard.java
java Rpg
```

## Exemplo de Execução

```
Name: Merlin
Element: FIRE
Mana: 50
Damage: 20

Name: Gandalf
Element: EARTH
Mana: 50
Damage: 15

Restore mana for Merlin? Enter amount (0 to skip): 0

How many turns? 3

=== Turn 1 ===
Merlin casts a spell on Gandalf
Merlin, mana: 40, life: 100.0, element: FIRE
Gandalf, mana: 50, life: 70.0, element: EARTH

=== Turn 2 ===
Gandalf casts a spell on Merlin
Merlin, mana: 40, life: 92.5, element: FIRE
Gandalf, mana: 40, life: 70.0, element: EARTH

=== Turn 3 ===
Merlin casts a spell on Gandalf
Merlin, mana: 30, life: 92.5, element: FIRE
Gandalf, mana: 40, life: 40.0, element: EARTH

END OF COMBAT
```

## Estrutura do Projeto

```
rpg-combat-system/
├── README.md
├── README.pt-br.md
├── Rpg.java       # ponto de entrada — lida com I/O e o loop de combate
└── Wizard.java     # classe de domínio — encapsula todas as regras de combate
```

## Possíveis Melhorias

- Extrair a lógica de relação elemental para um `enum` com um método dedicado, em vez de comparações encadeadas com `if/else`.
- Adicionar testes unitários (JUnit) cobrindo casos extremos: mana insuficiente, limite de vida em zero, confrontos do mesmo elemento.
- Suportar mais de dois combatentes.
