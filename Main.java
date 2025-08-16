/*
The Game of Life, created by John Conway, is a zero-player simulation that evolves based on an initial state and a set of simple rules. It consists of a grid of cells, each of which can be either alive or dead. The state of each cell in the next generation depends on its neighbors:

Any live cell with 2 or 3 live neighbors survives.
Any dead cell with exactly 3 live neighbors becomes alive.
All other cells die or remain dead due to underpopulation or overpopulation.
This simulation demonstrates how complex patterns can emerge from simple rules and is widely used in computer science and mathematics to explore cellular automata.
*/

import java.util.Scanner;

class Main{
  public static int alive = 1;
  public static int dead = 0;
  public static void main(String[] args){
    boolean run = true;
    int[][]preBoard = new int [22][22];
    int[][]newBoard = new int [22][22];
    for(int row = 0; row<preBoard.length; row++)
    {
      for(int col = 0; col<preBoard[0].length; col++)
      {
        preBoard[row][col]=0;
        newBoard[row][col]=0;
      }
    }
    while(run){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Do you want to add/remove a cell? Type \"yes\" or \"no\" ");
      String userInput = scanner.nextLine();
      if(userInput.equals("no")){
        System.out.println("How many generations do you want to run? " );
        int genNum = scanner.nextInt();
        aliveCell(10, 10, preBoard);
        aliveCell(10, 9, preBoard);
        aliveCell(10, 8, preBoard);
        gameOfLife(genNum, preBoard, newBoard);
        run = false;
      }
      if(userInput.equals("yes")){
        System.out.println("How many cells do you want to add to the board? Enter a number: ");
        int numAdd = scanner.nextInt();
        for(int i = 0; i<numAdd; i++){
          System.out.println("Give the x and y coordinate of a single cell that you would like to add separate by a space: ");
          int xVal = scanner.nextInt();
          int yVal = scanner.nextInt();
          aliveCell(yVal, xVal, preBoard);
        }
        System.out.println("How many cells do you want to remove to the board? Enter a number: ");
        int numKill = scanner.nextInt();
        for(int i = 0; i<numKill; i++){
          System.out.println("Give the x and y coordinate of a single cell that you would like to remove separate by a space: ");
          int xVal = scanner.nextInt();
          int yVal = scanner.nextInt();
          killCell(yVal, xVal, preBoard);
        }
        System.out.println("How many generations do you want to run? " );
        int genNum = scanner.nextInt();
        gameOfLife(genNum, preBoard, newBoard);
        run=false;
      }
    
        
    }
  }
  public static void printBoard(int[][]preBoard){
    for(int row = 1; row<preBoard.length-1; row++)
    {
      String strLine = "";
      for(int col = 1; col<preBoard[0].length-1; col++)
      {
        strLine+= " " + preBoard[row][col];
      }
    System.out.println(strLine);
    }
  }
  public static void killCell(int yIndex, int xIndex, int[][]preBoard){
    preBoard[yIndex+1][xIndex+1] = 0;
  }
  public static void aliveCell(int yIndex, int xIndex, int[][]preBoard)
  { 
    preBoard[yIndex+1][xIndex+1] = 1;
    
  }
  public static void gameOfLife(int numOfGens, int[][]preBoard, int[][]newBoard){
    for(int i = 0; i<numOfGens; i++){
    for(int row = 1; row<preBoard.length-1; row++)
    {
      for(int col = 1; col<preBoard[0].length-1; col++)
      {
        if(preBoard[row][col]==alive){
          int numDead=0;
          if(preBoard[row-1][col]==dead){
            numDead++;
          }
          if(preBoard[row-1][col-1]==dead){
            numDead++;
          }
          if(preBoard[row-1][col+1]==dead){
            numDead++;
          }
          if(preBoard[row][col+1]==dead){
            numDead++;
          }
          if(preBoard[row][col-1]==dead){
            numDead++;
          }
          if(preBoard[row+1][col-1]==dead){
            numDead++;
          }
          if(preBoard[row+1][col]==dead){
            numDead++;
          }
          if(preBoard[row+1][col+1]==dead){
            numDead++;
          }
          if(numDead<2){
            newBoard[row][col]=dead;
          }
          else if(numDead==6 || numDead==5){
            newBoard[row][col]=alive;
          }
          else{
            newBoard[row][col]=dead;
          }
          
        }
        else{
          int numDead=0;
          if(preBoard[row-1][col]==dead){
            numDead++;
          }
          if(preBoard[row-1][col-1]==dead){
            numDead++;
          }
          if(preBoard[row-1][col+1]==dead){
            numDead++;
          }
          if(preBoard[row][col+1]==dead){
            numDead++;
          }
          if(preBoard[row][col-1]==dead){
            numDead++;
          }
          if(preBoard[row+1][col-1]==dead){
            numDead++;
          }
          if(preBoard[row+1][col]==dead){
            numDead++;
          }
          if(preBoard[row+1][col+1]==dead){
            numDead++;
          }
          if(numDead==5){
            newBoard[row][col]=alive;
          }
        }
      }
    }
    System.out.println();
    printBoard(preBoard);
    for(int row = 0; row<preBoard.length; row++)
    {
      for(int col = 0; col<preBoard[0].length; col++)
      { 
      preBoard[row][col]=newBoard[row][col];
      }
    }
    }
  }
}
/*Any live cell with fewer than two live neighbours dies, as if by underpopulation.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overpopulation.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.*/