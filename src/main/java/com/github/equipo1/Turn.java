package com.github.equipo1;

import java.util.Scanner;

public class Turn {

    private Player player;
    private Board board;
    private Scanner sc;


    public Turn(Player player, Board board, Scanner sc) {
        this.player = player;
        this.board = board;
        this.sc = sc;


    }

    private void flipCard(int n){

        this.board.flipCard(n);
        Board.clearScreen();
        this.board.printBoard();

    }
}
