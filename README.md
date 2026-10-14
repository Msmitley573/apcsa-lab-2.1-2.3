# Lab 2.1-2.3 — Boolean Expressions and if Statements

Seven short methods in `SelectionLab.java`, each one a piece of TicketKiosk,
the movie-ticket program from your Unit 2A notes. The instructions for each
part are in the comment block directly above the method, so read them there —
this page is just the map.

Plan on 30 to 45 minutes.

## What you will practice

- Writing a Boolean expression with a relational operator, and returning it.
- Choosing between `<` and `<=` by testing the boundary value itself.
- Why `==` on two Strings compares references, and `equals` compares
  characters.
- Two-way selection with `if`-`else`, and one-way selection with `if`.
- Putting sequenced steps in the right order, because the order changes the
  answer.

## Getting started

1. Open this folder in your editor.
1. Open `src/main/java/SelectionLab.java`. That is the only file you change.
1. Work down the file. Each part is marked with a comment that starts with
   `TODO`; replace the placeholder line under it with your own code.

To run your program and see your output:

```sh
mvn -q compile exec:java
```

Your teacher will run a separate set of tests on your work when you turn it in.

## The parts

| Part | Method | What it is about |
| --- | --- | --- |
| 1 | `isChild(int)` | a relational expression is already true or false |
| 2 | `isMatinee(int)` | `<` or `<=`: check the boundary |
| 3 | `wants3D(String)` | `equals`, not `==`, on Strings |
| 4 | `startingPrice(int)` | two-way selection, `if`-`else` |
| 5 | `addSurcharge(int, boolean)` | one-way selection, `if` |
| 6 | `ticketCents(int, int, boolean)` | the order of the steps matters |
| 7 | `formatPrice(int)` | a one-way `if` that adds a missing `0` |

## Before you turn it in

- [ ] Every placeholder line under a `TODO` has been replaced with real code.
- [ ] `mvn -q compile exec:java` runs without errors.
- [ ] You tested the boundaries: `isChild(12)` is `true` and
      `isMatinee(17)` is `false`.
- [ ] Part 3 uses `equals`. `main` passes a `new String`, so `==` shows up
      there as `false`.
- [ ] Part 5 returns the price you were given when the guest did not choose
      3D, and there is no semicolon right after `if (wants3D)`.
- [ ] Part 6 sets the starting price before taking off any discount.
- [ ] Part 7 gives `"$9.00"` for 900 and `"$6.10"` for 610.
- [ ] You did not rename any method, change any parameter list, or change any
      return type. The grader compiles against those exact signatures, so a
      rename means a zero even if your logic is perfect.

`main` is not graded, so you may change it however you like.

## Optional extension, not graded

Write the seven steps of TicketKiosk's algorithm (lines 8 to 16 of the full
program in your notes) as a diagram: a box for each action, a diamond for each
true or false decision, and arrows labeled true and false. Then mark which
steps are sequencing, which are selection, and where repetition would go.
