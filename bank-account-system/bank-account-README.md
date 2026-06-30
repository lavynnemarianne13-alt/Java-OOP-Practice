# Bank Account System

*[Leia em português/Read in Portuguese](https://github.com/lavynnemarianne13-alt/Java-OOP-Practice/blob/main/bank-account-system/bank-README.pt-br.md)*

A console-based banking system built in Java to practice constructors, constructor overloading, `this`, and encapsulation with an emphasis on protecting object state through business rules rather than public setters.

This project is part of a structured Java/OOP study path, focused on applying concepts to realistic business-rule scenarios rather than isolated syntax exercises.

## Overview

The program manages two bank accounts and lets the user perform deposits, withdrawals, and transfers between them through a menu-driven console interface.

Each account enforces real banking constraints:

- An account's **number is immutable** set once at creation and never changed (`final` field, no setter).
- The **holder's name can be changed** (e.g. after a legal name change), but the **balance cannot be set directly** — it can only be modified through `deposit`, `withdraw`, and `transferTo`.
- **Deposits** are only accepted for positive amounts; zero or negative values are rejected.
- **Withdrawals** charge a fixed $5.00 fee and *can* leave the account with a negative balance if funds are insufficient to cover the fee.
- **Transfers** charge a $2.00 fee, deducted only from the sending account. Unlike withdrawals, a transfer is rejected outright if it would leave the sender with a negative balance. An account also cannot transfer to itself.

## Key Concepts Demonstrated

- **Constructor overloading**  `BankAccount(number, holder)` for accounts with no initial deposit, and `BankAccount(number, holder, initialDeposit)` for accounts that start with funds. The second constructor calls the first via `this(...)`, then reuses `deposit()` to apply the initial value — avoiding duplicated logic.
- **Encapsulation**  `balance` has no public setter. The only way to change it is through methods that enforce business rules.
- **`final` fields** the account number is declared `final`, making immutability a compiler-enforced guarantee, not just a convention.
- **Object collaboration** `transferTo(BankAccount other, double amount)` modifies the state of two different instances in a single operation.
- **Control flow** the main program uses a `do/while` menu loop, a `switch` for operation selection, and a `while` loop to keep prompting the user until a valid initial deposit value is entered.

## Class Diagram

```
┌─────────────────────────────────────────────────────────┐
│                       BankAccount                       │
├─────────────────────────────────────────────────────────┤
│ - number : final int                                    │
│ - holder : String                                       │
│ - balance : double                                      │
├─────────────────────────────────────────────────────────┤
│ + deposit(amount: double) : void                        │
│ + withdraw(amount: double) : void                       │
│ + transferTo(other: BankAccount, amount: double) : void │
│ + getHolder() : String                                  │
│ + setHolder(holder: String) : void                      │
│ + getNumber() : int                                     │
└─────────────────────────────────────────────────────────┘
```

## How to Run

```bash
javac Bank.java BankAccount.java
java Bank
```

## Sample Run

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

## Project Structure

```
bank-account-system/
├── README.md
├── Bank.java  # entry point — handles I/O and the operations menu
└── BankAccount.java  # domain class — encapsulates all account rules
```


- Replace the linear `(accNumber == bankaccount1.getNumber()) ? bankaccount1 : bankaccount2` lookup with a `List<BankAccount>` to support an arbitrary number of accounts.
- Add unit tests (JUnit) covering edge cases: insufficient balance on withdrawal vs. transfer, self-transfer rejection, deposit with non-positive values.
- Extract menu logic into a separate class to keep `main` focused on orchestration only.
