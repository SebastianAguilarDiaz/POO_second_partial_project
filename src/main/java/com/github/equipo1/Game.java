package com.github.equipo1;

import java.util.Scanner;

public class Game {

    Game(Player players[], Board board,Scanner sc){


        
        
        int pairsPerPlayer[]= new int [2];
        pairsPerPlayer[0]=0;
        pairsPerPlayer[1]=0;

        // it iterates the player and ends only when the number of cards upwards its 10
        for(int i=0;i<2 && board.numOfUpwardsCards<10;i++){
            Turn actualTurn= new Turn(players[i],board,sc);
            
            // if the actual player succed on his turn, it means his guess had been correct
            if(actualTurn.succeed)pairsPerPlayer[i]++;

            // so it returns to be 0 after the i++
            if(i==1) i=-1;

        }

        if     (pairsPerPlayer[0]>pairsPerPlayer[1]) System.out.println("Felicidades has ganado "+players[0].getName());
        else if(pairsPerPlayer[1]>pairsPerPlayer[0]) System.out.println("Felicidades has ganado "+players[1].getName());
        else System.out.println("Ha sido empate");
        


    }

}
