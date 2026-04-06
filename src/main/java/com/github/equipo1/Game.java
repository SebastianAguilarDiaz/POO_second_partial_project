package com.github.equipo1;

import java.util.Scanner;

public class Game {
    private String words[]=new String [5];
    private Card cards[][]=new Card[Board.height][Board.width];
    private Scanner sc;


    Game(Player players[], Board board,Scanner s){
        this.sc=s;

        this.askForTheWords();
        
        
        int pairsPerPlayer[]= new int [2];
        pairsPerPlayer[0]=0;
        pairsPerPlayer[1]=0;

        // it iterates the player and ends only when the number of cards upwards its 10
        for(int i=0;i<2 && board.numOfUpwardsCards<10;i++){
            Turn actualTurn= new Turn(players[i],board,this.sc);
            
            // if the actual player succed on his turn, it means his guess had been correct
            if(actualTurn.succeed)pairsPerPlayer[i]++;

            // so it returns to be 0 after the i++
            if(i==1) i=-1;

        }

        if     (pairsPerPlayer[0]>pairsPerPlayer[1]) System.out.println("Felicidades has ganado "+players[0].getName());
        else if(pairsPerPlayer[1]>pairsPerPlayer[0]) System.out.println("Felicidades has ganado "+players[1].getName());
        else System.out.println("Ha sido empate");
        


    }

    private void askForTheWords(){

        System.out.println("Ingresen 5 palabras de 6 letras");


        for(int i=0; i< 5; i++){
            String x=this.sc.nextLine();
            
            // if the word hasn't the necesarry length we skip it
            if (x.length()!=6){
                System.out.println("El tamano de la palabra debe ser 6 letras");
                i--;
                
            }
            // else we save it and continue
            else
                words[i]=x;
        }

    }

    private void createCards(){

        
    }
}
