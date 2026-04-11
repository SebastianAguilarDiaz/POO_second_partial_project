package com.github.equipo1;

import java.util.Scanner;
import java.util.Random;

public class AdultPlayer extends Player{

    private int failedAttempts=0;
    private Random random = new Random();
    private  String failPhrases[] = {
            "Sigue intentando",
            "Quizas la proxima",
            "Estuvo cerca",
            "Suerte para la proxima",
            "Fallaste esta vez"};
    private  String congratsPhrases[] = {
            "Felicidades",
            "Genial",
            "Lo lograste",
            "Algo bien",
            "Bien hecho"};

    AdultPlayer(Scanner sc, String name, int age){
        super(sc,name,age);
        this.setPointsPerCorrectGuess(2);
    }

    @Override
    public void printMotivationalPhrase(){
        this.failedAttempts++;
        
        if(this.failedAttempts>=1){
            int randomP = random.nextInt(failPhrases.length);
            //Print random fail phrase
            System.out.println(failPhrases[randomP] + " " + this.getName());
        }
    }

    @Override
    public void printCongratsPhrase(){
        int randomP = random.nextInt(congratsPhrases.length);
        //Print random congrats phrase
        System.out.println(congratsPhrases[randomP] + " " + this.getName() + "!");
    }

    @Override
    public void addGamePlayed(){
        super.addGamePlayed();
        this.failedAttempts=0;
    }



}
