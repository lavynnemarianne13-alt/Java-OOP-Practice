# RPG Combat System

*[Leia em português/Read in Portuguese](https://github.com/lavynnemarianne13-alt/Java-OOP-Practice/edit/main/rpg-combat-system/rpg-README.pt-br.md)*

A turn-based combat simulator built in Java to practice core Object-Oriented Programming principles: constructors, encapsulation, and collaboration between objects of the same class.

This project is part of a structured Java/OOP study path, focused on applying concepts to realistic business-rule scenarios rather than isolated syntax exercises.

## Overview

Two wizards face off in a turn-based duel. Each wizard belongs to one of three elements — **Fire**, **Water**, or **Earth** — which interact in a rock-paper-scissors style cycle:

- Fire is strong against Earth
- Earth is strong against Water
- Water is strong against Fire

When a wizard casts a spell, the elemental matchup determines whether the spell deals bonus damage (1.5x), reduced damage (0.5x), or normal damage (1.0x, for same-element matchups).

## Key Concepts Demonstrated

- **Encapsulation** — `life` and `mana` are private fields. They can only be changed through validated methods (`castSpellOn`, `restoreMana`); there is no way to set them directly from outside the class.
- **Object collaboration** — `castSpellOn(Wizard other)` shows how an instance method can read and modify the state of *another* instance of the same class, not just itself.
- **Defensive programming / business rules**:
  - A spell costs 10 mana. If the caster doesn't have enough mana, the spell fails silently — no mana is spent and no damage is dealt.
  - A wizard's life can never go below zero, regardless of how much damage is dealt.
- **Control flow** — the combat loop uses `for` to iterate turns (with an early exit via `break` once a wizard is defeated), `if/else` to alternate which wizard attacks, and `while` to validate user input for the mana-restore step.

## Class Diagram

```
┌─────────────────────────────────────┐
│              Wizard                 │
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

## How to Run

```bash
javac Rpg.java Wizard.java
java Rpg
```

## Sample Run

```
Name: Merlin
Element: FIRE
Mana: 50
Damage: 20

Name: Gandalf
Element: EARTH
Mana: 50
Damage: 15

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

## Project Structure

```
rpg-combat-system/
├── README.md
├── Rpg.java       # entry point — handles I/O and the combat loop
└── Wizard.java     # domain class — encapsulates all combat rules
```

- Extract elemental matchup logic into an `enum` with a dedicated method, instead of chained `if/else` comparisons.
- Add unit tests (JUnit) covering edge cases: insufficient mana, life clamping at zero, same-element matchups.
- Support more than two combatants.
