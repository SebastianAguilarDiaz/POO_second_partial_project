package com.github.equipo1;

import java.util.Scanner;

public class CardsGame {

    private static final int NUM_OF_PLAYERS=5;
    private Scanner sc;
    private Player players[]= new Player[CardsGame.NUM_OF_PLAYERS];

    CardsGame(Scanner s){
        this.sc=s;
        this.initialConfig();
    }
    public void registerPlayers(){
        for(int i =0; i<CardsGame.NUM_OF_PLAYERS ; i++){

            System.out.println("Jugador "+ (i+1)+", ingresa tu nombre: ");
            String name = this.sc.nextLine();
            System.out.println("Ingresa tu edad: ");
            int age=this.sc.nextInt();

            // cleans the buffer
            this.sc.nextLine();

            // depending on the age is the type of player 
            if(age<18)  this.players[i]=new KidPlayer(this.sc,name,age);
            else        this.players[i]=new AdultPlayer(this.sc, name, age);

            
        }
    }

    private void printPlayersNames(){
        for(int i=0; i<CardsGame.NUM_OF_PLAYERS;i++){
            System.out.print("Jugador " + (i+1) + ": ");
            System.out.println(this.players[i].getName());
        }
    }

    public void printPlayersData(){
        for(var n: this.players){
            n.printData();
            System.out.println();
        }
    }

    public void startAGame(){
        
        Game.askForTheWords(this.sc);
        Player gamePlayers[]=new Player [2];
        
        this.printPlayersNames();      
        
        System.out.println();
        System.out.println("Escribe el numero del primer jugador ");
        int x=this.sc.nextInt();
        gamePlayers[0]=this.players[x-1];

        System.out.println("Escribe el numero del segundo jugador ");
        int y=this.sc.nextInt();
        
        // if the user tries to select the same player twice
        while(y==x){
            System.out.println("Seleccione otro jugador");
            y=this.sc.nextInt();
        }

        // cleans the buffer
        sc.nextLine();


        gamePlayers[1]=this.players[y-1];

        Game actualGame= new Game(gamePlayers,this.sc);


        


        


    }

    public void setCardsFigure(){
        Card.printFiguresList();
        System.out.println();

        System.out.println("Escoja la figura");
        int fig=this.sc.nextInt();

        // cleans the buffer
        this.sc.nextLine();

        Card.setBackFigure(fig);
    }

    private void initialConfig(){
        this.registerPlayers();
        System.out.println();
        Card.setBackFigure();


    }

    
}
