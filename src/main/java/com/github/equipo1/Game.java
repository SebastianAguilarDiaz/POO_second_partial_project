package com.github.equipo1;

import java.util.Scanner;

public class Game {

    private static String words[]=new String [5];
    
    
    private Scanner sc;
    
    private static final int NUM_OF_PLAYERS=2;
    
    private int pointsPerPlayer[]= new int [Game.NUM_OF_PLAYERS];
    private Player players[]=new Player[Game.NUM_OF_PLAYERS];

    public Game(Player players[], Scanner s){
        this.sc=s;

        Board board=new Board(Game.words);

        
        for(int i=0;i<Game.NUM_OF_PLAYERS;i++){
            this.players[i]=players[i];
            this.pointsPerPlayer[i]=0;
        }

        

        board.printBoard();

        // it iterates the player and ends only when the number of cards upwards its 10
        for(int i=0; board.getNumOfUpwardsCards()<10;i++){
            Turn actualTurn= new Turn(this.players[i],board,this.sc);
            
            // if the actual player succed on his turn, it means his guess had been correct
            if(actualTurn.succeed)this.pointsPerPlayer[i]+=this.players[i].getPointsPerCorrectGuess();

            // so it returns to be 0 after the i++
            if(i==Game.NUM_OF_PLAYERS-1) i=-1;

        }

        this.printEndGame();


    }

    private void printWinner(){
        if (this.getPointsPerPlayer(0)>this.getPointsPerPlayer(1)) System.out.println("Felicidades "+this.players[0].getName()+", has ganado!");
        else if(this.getPointsPerPlayer(1)>this.getPointsPerPlayer(0)) System.out.println("Felicidades "+this.players[1].getName()+", has ganado!");
        else System.out.println("Ha sido empate");

    }

    private void printActualGamePoints(){
        System.out.println("* Puntaje de la partida");
        for(int i=0; i<Game.NUM_OF_PLAYERS;i++){
            System.out.println(this.players[i].getName()+" obtuvo: "+ this.getPointsPerPlayer(i)+" puntos");
        }
    }

    private void printPlayersData(){
        System.out.println("<>< Nuevas estadísticas ><>\n");
        for(var n: this.players){
            n.addGamePlayed();
            n.printData();
            System.out.println();
        }
    }

    private void printEndGame(){
        // prints who won the game
        this.printWinner();
        System.out.println();
        
        // prints how many points each player earned
        this.printActualGamePoints();
        System.out.println();

        // prints the new statistics of each player
        this.printPlayersData();
    }
    
    public int getPointsPerPlayer(int numOfPlayer ){
        return this.pointsPerPlayer[numOfPlayer];
    }

    public static void askForTheWords(Scanner sc){

        System.out.println("* Ingresen 5 palabras de 6 letras:");


        for(int i=0; i< 5; i++){
            String x=sc.nextLine();
            
            // if the word hasn't the necesarry length we skip it
            if (x.length()!=6){
                System.out.println("El tamano de la palabra debe ser 6 letras");
                i--;
                
            }
            // else we save it and continue
            else
                Game.words[i]=x;
        }
        

    }

}