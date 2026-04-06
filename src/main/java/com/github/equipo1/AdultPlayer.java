package com.github.equipo1;

import java.util.Scanner;

public class AdultPlayer extends Player{

    private int failedAttempts=0;

    AdultPlayer(Scanner sc){
        super(sc);
    
    }

    @Override
    public void printMotivationalPhrase(){
        this.failedAttempts++;
        
        if(this.failedAttempts>1) System.out.println("Sigue intentando "+this.getName());
    }

    @Override
    public void printCongratsPhrase(){
        System.out.println("Felicidades "+ this.getName());
    }

    // adds points to the player score when he succeeded
    public void addPoints() {
        this.failedAttempts=0;
        super.addPoints(2);
    }


}
