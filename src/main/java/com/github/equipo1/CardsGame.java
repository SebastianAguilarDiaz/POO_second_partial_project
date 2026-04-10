package com.github.equipo1;

import java.util.Scanner;

public class CardsGame {

    private static final int NUM_OF_PLAYERS=5;
    private Scanner sc;
    private Player players[]= new Player[CardsGame.NUM_OF_PLAYERS];
    private int gamesPlayed=0;

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
        System.out.println();
        Game.askForTheWords(this.sc);
        Player gamePlayers[]=new Player [2];
        
        System.out.println();
        this.printPlayersNames();      
        
        System.out.println();
        System.out.println("Escribe el numero del primer jugador ");
        int x=this.sc.nextInt();
        while(!(x>=1 && x<=5)){
            System.out.println("");
        }
        gamePlayers[0]=this.players[x-1];

        System.out.println("Escribe el numero del segundo jugador ");
        int y=this.sc.nextInt();
        
        // if the user tries to select the same player twice
        while(y==x){
            System.out.println("Seleccione otro jugador");
            y=this.sc.nextInt();
        }
        System.out.println();
        
        // cleans the buffer
        sc.nextLine();


        gamePlayers[1]=this.players[y-1];

        Game actualGame= new Game(gamePlayers,this.sc);

        gamesPlayed++;

    }

    public void setCardsFigure(){
        Card.printFiguresList();
        System.out.println();

        System.out.println("≡ Lista de Figuras:");
        System.out.println("┌ 0. Cuadrado");
        System.out.println("├ 1. Diagonal de 2 cuadros");
        System.out.println("├ 2. X");
        System.out.println("├ 3. Cruz");
        System.out.println("├ 4. Diagonal 3 cuadros");
        System.out.println("├ 5. Celdas");
        System.out.println("├ 6. S");
        System.out.println("├ 7. Y");
        System.out.println("└ 8. M");
        System.out.println("≡ Escoja el indice de la figura: ");
        int fig=this.sc.nextInt();
        System.out.println();

        // cleans the buffer
        this.sc.nextLine();

        Card.setBackFigure(fig);
    }

    public void printGamesPlayed(){
        System.out.println("Se han jugado "+this.gamesPlayed+ " juegos");
    }

    private void initialConfig(){
        this.registerPlayers();
        System.out.println();
        Card.setBackFigure();
    }

}