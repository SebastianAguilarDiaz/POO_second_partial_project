package com.github.equipo1;

public class KidPlayer implements Player{

    int points = 0;

    @Override
    public void printMotivationalPhrase(){
        System.out.println("No te preocupes! Cada vez que volteas una carta, tu cerebro guarda un mapa secreto de donde estan escondidas. Lo estas haciendo increible y veras que en el proximo turno estaras mucho mas cerca de encontrar el par! Sigue intentandolo, campeon");
    }
    
    @Override
    public void printCongratsPhrase(){
        System.out.println("Felicidades! Tienes una memoria increible y acabas de encontrar un par. Tu cerebro esta trabajando a toda maquina y lo estas haciendo como todo un experto. Sigue adelante porque vas por muy buen camino para ganar el juego!");
    }

    @Override
    public void addPoints(){
        points += 4;
    }
    
    @Override
    public int getPoints(){
        return points;
    }
}
