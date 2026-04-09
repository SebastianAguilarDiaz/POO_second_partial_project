package com.github.equipo1;

import java.util.Random;
import java.util.Scanner;

public class KidPlayer extends Player{

    private Random random = new Random();
    private  String failPhrases[] = {
            "no pasa nada si te equivocas, asi es como aprendemos, confia en ti y veras que pronto lo lograras!",
            "no te rindas! Eres genial por intentarlo. Cada error te acerca mas a la victoria!",
            "esta vez fallaste, pero la proxima estoy seguro de que lo vas a conseguir!",
            "eres mas capaz de lo que crees, solo tienes que confiar en ti, sigue intentando!",
            "no te preocupes por no haber encontrado la pareja en este turno, porque estas haciendo un trabajo realmente increible y estoy completamente seguro de que en el siguiente intento recordaras perfectamente donde estan todas las cartas para ganar el juego"
    };
    private  String congratsPhrases[] = {
            "eres super genial! sigue asi y llegaras a ser el mejor en el juego!",
            "Cada vez que lo logras estoy mas feliz por ti, cuando lo logras estoy mas seguro que puedes lograr todas las metas que te propongas!",
            "tienes una memoria realmente asombrosa y envidiable: acabas de encontrar una pareja de cartas! Pusiste muchisima atencion a cada uno de los movimientos en el tablero de juego. Sigue asi para ser el mejor jugador!",
            "Eres la persona mas brillante que he conocido, sigue asi y veras como este juego pronto sera tuyo! Domina la partida!",
            "Lo lograste esta vez! asi que puedes hacerlo otra vez, confia en ti! cada logro es una victoria para tu persona!",
    };

    public KidPlayer(Scanner sc, String name, int age){
        super(sc,name,age);
        this.setPointsPerCorrectGuess(4);
    }



    // prints the motivational phrase in case that the player failed
    @Override
    public void printMotivationalPhrase(){
        int randomP = random.nextInt(failPhrases.length);
        System.out.println(this.getName() + ", " + failPhrases[randomP]);
    
    }

    // prints the congrats phrase in case that the player succeeded
    @Override
    public void printCongratsPhrase(){
        int randomP = random.nextInt(congratsPhrases.length);
        System.out.println("Felicidades " + this.getName() + "! " + congratsPhrases[randomP]);
    
    }


}
