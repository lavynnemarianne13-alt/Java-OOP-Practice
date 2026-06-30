# Java OOP Practice

*[Read in English/Leia em inglês](https://github.com/lavynnemarianne13-alt/Java-OOP-Practice/blob/main/README.md)*

Uma coleção de exercícios em Java desenvolvidos durante o estudo de fundamentos de Programação Orientada a Objetos, como parte de uma trilha de aprendizado estruturada de 24 meses em direção a um cargo de DevSecOps / Cloud Security Engineer no mercado internacional de trabalho.

Cada projeto aplica conceitos de OOP a um domínio pequeno, porém realista — priorizando regras de negócio e colaboração entre objetos em vez de prática isolada de sintaxe. O objetivo de cada exercício não é apenas "fazer compilar", mas modelar o estado corretamente, protegê-lo através de encapsulamento, e tratar casos extremos da forma como um sistema real precisaria.

## Projetos

| Projeto | Conceitos | Descrição |
|---|---|---|
| [RPG Combat System](https://github.com/lavynnemarianne13-alt/Java-OOP-Practice/tree/main/rpg-combat-system) | Encapsulamento, colaboração entre objetos, estruturas de controle (`for`, `if/else`, `while`) | Duelo por turnos entre dois magos, com multiplicadores de dano elemental e gerenciamento de mana |
| [Bank Account System](https://github.com/lavynnemarianne13-alt/Java-OOP-Practice/tree/main/bank-account-system) | Sobrecarga de construtores, `this`, imutabilidade (`final`), encapsulamento | Aplicação bancária via console com suporte a depósitos, saques e transferências com regras de taxa |

*(Mais projetos serão adicionados conforme a trilha de estudo avança — veja o roadmap abaixo.)*

## No que estou focando

Ao longo desses exercícios, estou praticando deliberadamente:

- **Encapsulamento como ferramenta de design**, não como uma formalidade — os atributos são privados e só podem ser alterados por meio de métodos que aplicam regras reais (ex: um saldo não pode ficar abaixo do que uma regra de transferência permite; a mana de um mago não pode ficar negativa).
- **Colaboração entre objetos** — métodos como `castSpellOn(Wizard other)` e `transferTo(BankAccount other, ...)` que leem e modificam o estado de outra instância, não apenas de `this`.
- **Sobrecarga de construtores e `this`** — múltiplas formas de construir o mesmo tipo de objeto (ex: uma conta com ou sem depósito inicial), sem duplicar lógica.
- **Estruturas de controle defensivas e legíveis** — uso deliberado de `if`, `while` e `for`: `while` para "continuar perguntando até ser válido", `if` para validação pontual, `for` para iteração limitada com saída antecipada via `break`.

## Como Executar Qualquer Projeto

Cada pasta de projeto é autocontida. De dentro da pasta do projeto:

```bash
javac *.java
java <NomeDaClassePrincipal>
```

Consulte o README de cada projeto para o nome exato da classe principal e um exemplo de execução.

## Sobre Esta Trilha

Sou estudante de Engenharia de Software em transição para DevSecOps e Cloud Security, construindo uma base em Java antes de avançar para Linux, Docker, CI/CD e ferramentas voltadas à segurança. Este repositório acompanha a parte inicial e fundamental dessa trilha —o restante do roadmap (plataformas de nuvem, conteinerização, certificações de segurança) está sendo construído em paralelo e vai aparecer em repositórios futuros.

- [ ] Sistema de gestão de funcionários (List, lógica de aumento salarial encapsulada)
- [ ] Sistema de catálogo de produtos (comparação entre arrays e listas)
- [ ] Exercícios refatorados com cobertura de testes JUnit
