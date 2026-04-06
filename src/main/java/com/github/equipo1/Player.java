package com.github.equipo1;

import java.util.Scanner;


public abstract class Player {
    
    private String name;
    protected int points=0;
    private int age;
    private int gamesPlayed=0;


    public Player(Scanner sc, String n, int a){

        this.setName(n);

        this.setAge(a);;
        

        
        this.points=0;

    }


    // returns the age of the player
    public int getAge(){
        return this.age;
    }

    // sets the age of the player
    public void setAge(int a){
        this.age=a;
    }



    // sets the name of the player    
    public void setName(String n){
        this.name=n;
    }

    // returns the name of the player
    public String getName(){
        return this.name;
    }





    // prints the motivational phrase in case that the player failed 
    public void printMotivationalPhrase(){

    }
    
    // prints the congrats phrase in case that the player succeeded
    public void printCongratsPhrase(){

    }
    
    // adds points to the player when he succeeded
    public void addPoints(){
        this.points+=2;
    }


    // returns the score of the player
    public int getPoints(){
        return this.points;
    }

    // adds one to the games played
    public void addGamePlayed(){
        this.gamesPlayed++;
    }

    // returns the games played
    public int getGamesPlayed(){
        return this.gamesPlayed;
    }

    // prints the info of the player 
    public void printData(){
        System.out.println("Nombre: "+this.getName());
        System.out.println("Edad: "+this.getAge());
        System.out.println("Puntos: "+this.getPoints());
        System.out.println("Juegos jugados: "+this.getGamesPlayed());
        
    }
}
