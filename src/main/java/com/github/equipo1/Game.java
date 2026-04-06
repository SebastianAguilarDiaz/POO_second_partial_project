package com.github.equipo1;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private static String words[]=new String [5];
    private static Card   cards[][]=new Card[Board.height][Board.width];
    private Scanner sc;


    public Game(Player players[], Scanner s){
        this.sc=s;

        Board board=new Board(cards);

        
        int pairsPerPlayer[]= new int [2];
        pairsPerPlayer[0]=0;
        pairsPerPlayer[1]=0;
        

        board.printBoard();
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
        
        for(var n: players){
            n.addGamePlayed();
            n.printData();
            System.out.println();
        }


    }

    public static void askForTheWords(Scanner sc){

        System.out.println("Ingresen 5 palabras de 6 letras");


        for(int i=0; i< 5; i++){
            String x=sc.nextLine();
            
            // if the word hasn't the necesarry length we skip it
            if (x.length()!=6){
                System.out.println("El tamano de la palabra debe ser 6 letras");
                i--;
                
            }
            // else we save it and continue
            else
                words[i]=x;
        }
        
        // every time we ask for new words we will need to create new cards
        createCards();
    }

    private static void createCards(){
        // so we cant count how many cards of each word we have
        int wordsAdded[]=new int[5];
        
        // there are 0 cards of each word at the beggining
        for(int i=0;i<5;i++){
            wordsAdded[i]=0;
        }

        for(int i=0;i<Board.height;i++){
            for(int j=0;j<Board.width;j++){
                Random rand=new Random();
                
                int x = rand.nextInt(5);

                if (wordsAdded[x]==2)
                    // the word has already 2 cards of it
                    j--;
                
                else{

                    // we create a card with the word 
                    cards[i][j]=new Card(Game.words[x]);
                    
                    // we have one more card with that word
                    wordsAdded[x]++;
                }
            }
        }






        
    }
}
