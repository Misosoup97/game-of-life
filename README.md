# Conway’s Game of Life (Java)

This is a **personal project** I built to explore my interest in **computational mathematics**. It’s a Java implementation of John Conway’s *Game of Life*, a zero-player simulation where cells live or die based on simple rules. Despite its simplicity, the simulation produces surprisingly complex and evolving patterns.

---

## 🔹 Features
- Interactive setup: add or remove cells before starting  
- Configurable number of generations  
- Grid output for each generation to visualize evolving states  
- Implements the core Game of Life rules:  
  - Any live cell with 2 or 3 neighbors survives  
  - Any dead cell with exactly 3 neighbors becomes alive  
  - All other cells die or remain dead  

---

## 🔹 Why I Built This
I created this project to deepen my understanding of **computational math** and explore how simple rule-based systems can generate complex emergent behavior — a concept relevant to **cellular automata, complexity theory, and computer science**.

---

## 🔹 How to Run
1. Clone the repository:  
   git clone https://github.com/Misosoup97/GameOfLife.git  
   cd game-of-life  

2. Compile and run:  
   javac Main.java  
   java Main  

---

## 🔹 Example Output
Do you want to add/remove a cell? Type "yes" or "no"  
no  
How many generations do you want to run?  
5  
 0 0 0 0 0  
 0 1 1 1 0  
 0 0 0 0 0  
 ...  

---

## 🔹 Future Improvements
- Add GUI visualization instead of console output  
- Save/load board states  
- Experiment with larger grids and random initialization  
