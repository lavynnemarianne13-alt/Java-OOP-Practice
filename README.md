# Java OOP Practice 

*[Read in Portuguese/Leia em português](https://github.com/lavynnemarianne13-alt/Java-OOP-Practice/blob/main/README.pt-br.md)*

A collection of Java exercises built while studying Object-Oriented Programming fundamentals, as part of a structured 24-month learning path toward a DevSecOps / Cloud Security Engineer role in the international job market.

Each project applies OOP concepts to a small but realistic domain — favoring business rules and object collaboration over isolated syntax practice. The goal of each exercise is not just "make it compile," but to model state correctly, protect it through encapsulation, and handle edge cases the way a real system would need to.

## Projects

| Project | Concepts | Description |
|---|---|---|
| [RPG Combat System](https://github.com/lavynnemarianne13-alt/Java-OOP-Practice/tree/main/rpg-combat-system) | Encapsulation, object collaboration, control flow (`for`, `if/else`, `while`) | Turn-based duel between two wizards, with elemental damage multipliers and mana management |
| [Bank Account System](https://github.com/lavynnemarianne13-alt/Java-OOP-Practice/tree/main/bank-account-system) | Constructor overloading, `this`, immutability (`final`), encapsulation | Console banking app supporting deposits, withdrawals, and transfers with fee rules |

*(More projects will be added as the study path progresses — see roadmap below.)*

## What I'm Focusing On

Across these exercises, I'm deliberately practicing:

- **Encapsulation as a design tool**, not a checkbox — fields are private and changed only through methods that enforce real constraints (e.g. a balance can't go below what a transfer rule allows; a wizard's mana can't go negative).
- **Object-to-object collaboration** — methods like `castSpellOn(Wizard other)` and `transferTo(BankAccount other, ...)` that read and modify the state of another instance, not just `this`.
- **Constructor overloading and `this`** — multiple ways to build the same kind of object (e.g. an account with or without an initial deposit), without duplicating logic.
- **Defensive, readable control flow** — using `if`, `while`, and `for` deliberately: `while` for "keep asking until valid," `if` for one-time validation, `for` for bounded iteration with early exit via `break`.

## How to Run Any Project

Each project folder is self-contained. From inside a project's folder:

```bash
javac *.java
java <MainClassName>
```

See each project's own README for the exact class name and a sample run.

## About This Path

I'm a Software Engineering student transitioning toward DevSecOps and Cloud Security, building a foundation in Java before moving into Linux, Docker, CI/CD, and security-focused tooling. This repository tracks the early, foundational part of that path — the rest of the roadmap (cloud platforms, containerization, security certifications) is being built in parallel and will surface in future repositories.

