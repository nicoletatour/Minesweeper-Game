# Minesweeper-Game
A simple two‑player Minesweeper played in the terminal. Players take turns opening cells on a square grid. If you uncover a mine you score a point; otherwise the cell shows how many neighboring mines there are. The game ends when all mines are found — highest score wins.

## Requirements
- Java 8 or newer

## How to Play (Rules)
- Players alternate turns entering the coordinates of a cell to open.
- If the cell **contains a mine**, it’s revealed (`*`) and that player’s **score increases by 1**.
- If the cell **does not** contain a mine, it opens and shows the **number of adjacent mines**.
- **Already opened** cells cannot be chosen; you’ll be asked again.
- The game finishes when **all mines** have been found; the final scoreboard is printed.

## Project Structure
- `Game.java` — CLI entry point: asks for size, number of mines, and player names.
- `MineSweeper.java` — Game controller: turn handling and scorekeeping.
- `MineField.java` — The board: grid generation, random mine placement, neighbor linking, printing.
- `Cell.java` — A single cell: state (`open`/`mine`) and neighbor count display.
- `Player.java` — Player model: name, score, reads moves from standard input.

## Build & Run
```bash
javac *.java
java Game
```

## Notes
- This is a classroom assignment; feel free to adapt or extend.
