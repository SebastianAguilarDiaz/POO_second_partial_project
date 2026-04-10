package com.github.equipo1;

import java.util.Scanner;

public class AppMenu {
    public static void main(String[] args) {
        
        
        Scanner sc=new Scanner(System.in);
        CardsGame actualCardsGame=new CardsGame(sc);
        

        int option=6;

        while(option!=0){
            AppMenu.printMenu();
            option=sc.nextInt();


            // cleans the buffer
            sc.nextLine();

            switch (option) {
                // end game
                case 0:

                    break;

                // play a game
                case 1:
                    actualCardsGame.startAGame();
                    break;

                // print the players data
                case 2:
                    actualCardsGame.printPlayersData();
                    break;

                // changes the back figure of the cards
                case 3:
                    actualCardsGame.setCardsFigure();
                    break;

                default:
                    break;
            }

        }
        System.out.println();
        actualCardsGame.printPlayersData();
        System.out.println();
        actualCardsGame.printGamesPlayed();
        actualCardsGame.printGrandWinner();

        sc.close();

    }
    public static void printMenu(){

        System.out.println("Escoja una opcion");
        System.out.println("(0) Salir");
        System.out.println("(1) Jugar partida");
        System.out.println("(2) Ver datos de los jugadores");
        System.out.println("(3) Cambiar figura de las cartas");



    }
}