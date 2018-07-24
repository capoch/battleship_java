package com.company;

import java.util.Random;
import java.util.Scanner;

class Battleship {

    public static void main(String[] args) {
        char[][] board = newBoard();
        int playerShips = 5;
        int CPUShips = 5;
        displayBoard(board);
        deployPlayerShips(board);
        displayBoard(board);
        deployCPUShips(board);
        displayBoard(board);
        playerTurn(board);
	// write your code here
    }

    public static char[][] newBoard() {
        char[][] board = new char[10][10];

        for(int i = 0; i < board.length; i++) {
            for(int j= 0; j < board[i].length; j++)
                board[i][j]= ' ';
        }
        return board;
    }

    public static void displayBoard(char[][] board) {
        System.out.println("  0123456789  ");

        for(int i = 0; i < board.length; i++) {
            System.out.print(i+"|");
            for(int j= 0; j < board[i].length; j++)
                System.out.print(board[i][j]);
            System.out.println("|"+i);
        }

        System.out.println("  0123456789  ");
    }

    private static void deployPlayerShips(char[][] board) {
        Scanner input = new Scanner(System.in);
        int x = 10;
        int y = 10;
        System.out.println("Deploy your ships:");

        for(int i = 0; i < 5; i++) {
            Boolean fieldNotOccupied = true;
            while(fieldNotOccupied) {
                System.out.println("Enter X coordinate for your ship(" + i + "): ");
                x = input.nextInt();
                System.out.println("Enter Y coordinate for your ship(" + i + "): ");
                y = input.nextInt();
                if (x >= 0 && x < 10 && y >= 0 && y < 10 && board[x][y] == ' ')
                    fieldNotOccupied = false;
            }
            board[x][y] = '@';
        }
    }

    private static void deployCPUShips(char[][] board) {
        System.out.println("CPU is deploying ships");
        int x = 10;
        int y = 10;
        Random rand = new Random();
        for(int i = 0; i < 5; i++) {
            Boolean fieldNotOccupied = true;
            while(fieldNotOccupied) {
                x = rand.nextInt(10);
                y = rand.nextInt(10);
                if (x >= 0 && x < 10 && y >= 0 && y < 10 && board[x][y] == ' ')
                    fieldNotOccupied = false;
            }
            board[x][y] = '^';
        }
    }

    private static void playerTurn(char[][] board) {

        Scanner input = new Scanner(System.in);
        int x = 10;
        int y = 10;
        System.out.println("Deploy your ships:");

        Boolean fieldNotOccupied = true;
        while(fieldNotOccupied) {
            System.out.println("Enter X coordinate for attack: ");
            x = input.nextInt();
            System.out.println("Enter Y coordinate for attack: ");
            y = input.nextInt();
            if (x >= 0 && x < 10 && y >= 0 && y < 10 && board[x][y] != '@')
                fieldNotOccupied = false;
        }
        if (board[x][y]=='^') {
            System.out.println("Hit!!!");
            board[x][y]='#';
            CPUShips -= 1;
        }
        else {
            System.out.println("Only Water");
            board[x][y]='~';
        }
    }
}
