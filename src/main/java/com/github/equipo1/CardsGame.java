package com.github.equipo1;

import java.util.Scanner;

public class CardsGame {

    private static final int NUM_OF_PLAYERS=5;
    private static final int MAX_GAMES=10;
    private Scanner sc;

    private Player players[]= new Player[CardsGame.NUM_OF_PLAYERS];
    private Game games[]= new Game[CardsGame.MAX_GAMES];

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
            System.out.print("Jugador "+(i+1)+": ");
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
        // checks if max games reached
        if(this.gamesPlayed >= CardsGame.MAX_GAMES){
            System.out.println("! Se ha alcanzado el maximo de "+CardsGame.MAX_GAMES+" partidas.");
            System.out.println();
            return;
        }

        Game.askForTheWords(this.sc);
        Player gamePlayers[]=new Player [2];
        
        System.out.println();
        this.printPlayersNames();      
        
        System.out.println();
        System.out.println("Escribe el numero del primer jugador");
        int x=this.sc.nextInt();

        // verifies the user enters a valid player number
        while(!(x>=1 && x<=5)){
            System.out.println("Escribe un numero de jugador valido");
            x=this.sc.nextInt();
        }
        gamePlayers[0]=this.players[x-1];

        System.out.println("Escribe el numero del segundo jugador ");
        int y=this.sc.nextInt();
        
        // if the user tries to select the same player twice or enters an invalid number
        while(!(y>=1 && y<=5) || y==x){
            if(!(y>=1 && y<=5)){
                System.out.println("Escribe un numero de jugador valido");
                y=this.sc.nextInt();
            }
            else {
                System.out.println("Seleccione otro jugador");
                y=this.sc.nextInt();
            }
        }
        System.out.println();
        
        // cleans the buffer
        sc.nextLine();


        gamePlayers[1]=this.players[y-1];

        this.games[gamesPlayed]=new Game(gamePlayers, this.sc);

        gamesPlayed++;

    }

    public void setCardsFigure(){
        System.out.println("≡ Lista de Figuras");
        System.out.println("┌ 0. Cuadrado");
        System.out.println("├ 1. Diagonal de 2 cuadros");
        System.out.println("├ 2. X");
        System.out.println("├ 3. Cruz");
        System.out.println("├ 4. Diagonal 3 cuadros");
        System.out.println("├ 5. Celdas");
        System.out.println("├ 6. S");
        System.out.println("├ 7. Y");
        System.out.println("└ 8. M");
        System.out.println("≡ Escoja el indice de la figura");
        int fig=this.sc.nextInt();
        System.out.println();

        // cleans the buffer
        this.sc.nextLine();

        Card.setBackFigure(fig);
    }

    public void printGamesPlayed(){
        System.out.println("Se han jugado "+this.gamesPlayed+ " juegos");
    }

    // prints stats of all games and finds best and worst
    public void printGamesStats(){
        if(this.gamesPlayed == 0){
            System.out.println("No se jugaron partidas.");
            return;
        }

        System.out.println("\n<><>< ESTADISTICAS DE PARTIDAS ><><>");
        for(int i=0; i<this.gamesPlayed; i++){
            this.games[i].printGameStats(i+1);
        }

        // find game with most correct guesses
        int maxCorrect=0;
        // find game with most failed guesses
        int maxFailed=0;

        // so we can know the max of correct and failed guesses in all the games
        for(int i=0; i<this.gamesPlayed; i++){
            if(this.games[i].getCorrectGuesses() > maxCorrect){
                maxCorrect=this.games[i].getCorrectGuesses();
            }
            if(this.games[i].getFailedGuesses() > maxFailed){
                maxFailed=this.games[i].getFailedGuesses();
            }
        }


        // prints every game with the max of correct guesses
        System.out.print("\nPartida(s) con mas aciertos ( " + maxCorrect + " ): ");

        for(int i=0; i<this.gamesPlayed; i++){
            if(this.games[i].getCorrectGuesses()==maxCorrect){
                System.out.print((i+1)+", ");

            }
        }

        // prints every game with the max of failed guesses 
        System.out.print("\nPartida(s) con mas fallos ( " + maxFailed + " ) : ");
        
        for(int i=0; i<this.gamesPlayed; i++){
            if(this.games[i].getFailedGuesses()==maxFailed){
                System.out.print((i+1)+", ");

            }
        }
        System.out.println();

    }

    private void initialConfig(){
        this.registerPlayers();
        System.out.println();
        Card.setBackFigure();
    }

    public void printGrandWinner() {
        System.out.println();
        System.out.println("<><>< RESULTADO FINAL ><><>");

        int maxPoints = this.players[0].getPoints();

        for (int i = 1; i < CardsGame.NUM_OF_PLAYERS; i++) {
            if (this.players[i].getPoints() > maxPoints) {
                maxPoints = this.players[i].getPoints();
            }
        }
        System.out.println("Ganador(es):");

        for (int i = 0; i < CardsGame.NUM_OF_PLAYERS; i++) {
            if (this.players[i].getPoints() == maxPoints) {
                System.out.println("-> "+this.players[i].getName()+"! - Puntaje total: "+maxPoints+"\tVictorias: "+this.players[i].getGamesWon());
            }
        }

    }
}