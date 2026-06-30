# Bank Account System

*[Read in English](./README.md)*

Um sistema bancário via console construído em Java para praticar construtores, sobrecarga de construtores, `this` e encapsulamento — com ênfase em proteger o estado do objeto através de regras de negócio, em vez de setters públicos.

Este projeto faz parte de uma trilha estruturada de estudo de Java/OOP, focada em aplicar conceitos a cenários realistas com regras de negócio, em vez de exercícios isolados de sintaxe.

## Visão Geral

O programa gerencia duas contas bancárias e permite que o usuário realize depósitos, saques e transferências entre elas através de uma interface de menu via console.

Cada conta aplica restrições reais de um sistema bancário:

- O **número da conta é imutável** — definido uma única vez na criação e nunca alterado (atributo `final`, sem setter).
- O **nome do titular pode ser alterado** (ex: após uma mudança legal de nome), mas o **saldo não pode ser definido diretamente** — só pode ser modificado através de `deposit`, `withdraw` e `transferTo`.
- **Depósitos** só são aceitos para valores positivos; valores zero ou negativos são rejeitados.
- **Saques** cobram uma taxa fixa de $5.00 e *podem* deixar a conta com saldo negativo se os fundos forem insuficientes para cobrir a taxa.
- **Transferências** cobram uma taxa de $2.00, descontada apenas da conta de origem. Diferente do saque, uma transferência é recusada caso deixe o remetente com saldo negativo. Uma conta também não pode transferir para si mesma.

## Conceitos Demonstrados

- **Sobrecarga de construtores** — `BankAccount(number, holder)` para contas sem depósito inicial, e `BankAccount(number, holder, initialDeposit)` para contas que já iniciam com fundos. O segundo construtor chama o primeiro via `this(...)`, e depois reaproveita `deposit()` para aplicar o valor inicial — evitando lógica duplicada.
- **Encapsulamento** — `balance` não possui setter público. A única forma de alterá-lo é através de métodos que aplicam regras de negócio.
- **Atributos `final`** — o número da conta é declarado `final`, tornando a imutabilidade uma garantia imposta pelo compilador, não apenas uma convenção.
- **Colaboração entre objetos** — `transferTo(BankAccount other, double amount)` modifica o estado de duas instâncias diferentes em uma única operação.
- **Estruturas de controle** — o programa principal usa um loop `do/while` para o menu, um `switch` para seleção de operação, e um loop `while` para continuar pedindo ao usuário até que um valor de depósito inicial válido seja informado.

## Diagrama de Classe

```
┌──────────────────────────────────────────┐
│                BankAccount                │
├──────────────────────────────────────────┤
│ - number : final int                      │
│ - holder : String                         │
│ - balance : double                        │
├──────────────────────────────────────────┤
│ + deposit(amount: double) : void           │
│ + withdraw(amount: double) : void          │
│ + transferTo(other: BankAccount, amount: double) : void │
│ + getHolder() : String                     │
│ + setHolder(holder: String) : void          │
│ + getNumber() : int                        │
└──────────────────────────────────────────┘
```

## Como Executar

```bash
javac ContaBancaria.java BankAccount.java
java ContaBancaria
```

## Exemplo de Execução

```
Enter the first account number: 1001
Enter the account holder for the first account: Maria
Is there an initial deposit (y/n)? y
Enter initial deposit value: 500.00

Enter the second account number: 1002
Enter the account holder for the second account: Bob
Is there an initial deposit (y/n)? n

 BANKING OPERATIONS
1. DEPOSIT
2. WITHDRAW
3. TRANSFER
4. RETURN
Enter the desired operation: 3
From account number: 1001
To account number: 1002
Transfer amount: 200.00
Transferring $ 200.00 from Maria to Bob...

Enter the desired operation: 4

Account: 1001, Holder: Maria, Balance: 298.00
Account: 1002, Holder: Bob, Balance: 200.00
```

## Estrutura do Projeto

```
bank-account-system/
├── README.md
├── README.pt-br.md
├── ContaBancaria.java   # ponto de entrada — lida com I/O e o menu de operações
└── BankAccount.java      # classe de domínio — encapsula todas as regras da conta
```

## Possíveis Melhorias

- Substituir a busca linear `(accNumber == bankaccount1.getNumber()) ? bankaccount1 : bankaccount2` por uma `List<BankAccount>` para suportar um número arbitrário de contas.
- Adicionar testes unitários (JUnit) cobrindo casos extremos: saldo insuficiente em saque vs. transferência, rejeição de autotransferência, depósito com valores não positivos.
- Extrair a lógica do menu para uma classe separada, mantendo o `main` focado apenas em orquestração.
