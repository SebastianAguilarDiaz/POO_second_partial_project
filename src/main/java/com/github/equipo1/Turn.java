package com.github.equipo1;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Turn {

    private Board board;
    private Scanner sc;
    public boolean succeed=false;


    public Turn(Player p, Board b, Scanner s) {
    
        this.board = b;
        this.sc = s;
        

        int card1=this.flipCard(p);
        int card2=this.flipCard(p);

        // if the player succeed the cards must remain upwards and the player must earn some points
        if (board.compareCards(card1, card2)){
            p.addPoints();
            p.printCongratsPhrase();
            this.succeed=true;
        }

        
        // else the cards must return to their previous status an also the board
        else{
            p.printMotivationalPhrase();
            // waits to seconds if the guess is incorrect
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            
            
            
            board.flipCard(card1);
            board.flipCard(card2);
            
            Board.clearScreen();
            board.printBoard();
        }


    }

    private int flipCard(Player player){


        System.out.println("Jugador "+ player.getName()+ ", selecciona una carta para voltear ");
        int card=this.sc.nextInt();
        
        // if the card is already upwards
        while(this.board.getCardStatus(card)){
            System.out.println("Selecciona una carta valida ");
            card=this.sc.nextInt();
            
            // cleans the buffer
            this.sc.nextLine();



        }
        

        // flips the card cleans the screen and then prints the board
        board.flipCard(card);
        Board.clearScreen();
        board.printBoard();
        

        return card;

    }
}
