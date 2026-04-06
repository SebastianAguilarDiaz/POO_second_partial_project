package com.github.equipo1;

import java.util.Scanner;

public class AdultPlayer extends Player{

    private int failedAttempts=0;

    AdultPlayer(Scanner sc, String n, int a){
        super(sc,n,a);
    
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

    @Override
    public void addGamePlayed(){
        super.addGamePlayed();
        this.failedAttempts=0;
    }



}
