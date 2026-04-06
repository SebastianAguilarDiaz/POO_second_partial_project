package com.github.equipo1;

import java.util.Scanner;

public class KidPlayer extends Player{

    public KidPlayer(Scanner sc, String n, int a){
        super(sc,n,a);

    }



    // prints the motivational phrase in case that the player failed
    @Override
    public void printMotivationalPhrase(){

        System.out.println(this.getName() + ", no te preocupes por no haber encontrado la pareja en este turno porque estas haciendo un trabajo realmente increible y estoy completamente seguro de que en el siguiente intento recordaras perfectamente donde estan todas las cartas para ganar el juego");
    
    }

    // prints the congrats phrase in case that the player succeeded
    @Override
    public void printCongratsPhrase(){

        System.out.println("Felicidades " + this.getName() + ", tienes una memoria realmente asombrosa y envidiable porque acabas de encontrar una pareja de cartas demostrando que pusiste muchisima atencion a cada uno de los movimientos en el tablero de juego sigue asi para ser el mejor jugador");
    
    }

    // adds point to the player score when he succeeded
    public void addPoints() {
        super.addPoints(4);
    }

}
