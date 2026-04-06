package com.github.equipo1;

import java.util.Scanner;


public abstract class Player {
    
    private String name;
    private int points;
    private int age;
    private int gamesPlayed;


    public Player(Scanner sc){
        // obtains the name of the player
        System.out.print("Por favor, ingresa el nombre del jugador: ");
        this.setName(sc.nextLine());

        // obtains the age of the player
        System.out.print("Por favor, ingresa la edad del jugador: ");
        this.setAge(sc.nextInt());;
        
        // cleans the buffer
        sc.nextLine();
        
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
    public void addPoints(int num){
        this.points+=num;
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
