package com.github.equipo1;

import java.util.Random;

public class Card {
    // card dimensions
    public  static final int  WIDTH=8;
    public  static final int  HEIGHT=8;
    private static final char FRONT_BOTTOM='-';
    private static final char BACKGROUND_CHARACTER=' ';


    // faces of the card
    private        char [][] front=new char[HEIGHT][WIDTH];
    private static char [][] back =new char[HEIGHT][WIDTH];
    

    // word that the card will have assigned
    private String word;

    private boolean cardUpwards=false;

    private static Random rand= new Random();
    

    
    public Card(String w){
        //first we save the word
        this.word=w;

        // then we set the front face of the card
        this.setFront();


    }

    // sets the front face of the card
    private void setFront(){
        for (int i=0;i<Card.HEIGHT;i++){

            for(int j=0; j<Card.WIDTH;j++){
                
                // if we are at the bottom the character must be the one specified
                if(i==Card.HEIGHT-1)     front[i][j]=Card.FRONT_BOTTOM;


                // else if we are on the spaces destined for the word the characters must be the word ones
                else if(i==3 && j<Card.WIDTH-1 && j>0 )  this.front[i][j]=this.word.charAt(j-1);

                // if neither of the other options were correct it because the character must be the background of the card
                else this.front[i][j]=Card.BACKGROUND_CHARACTER;
                
            }
        }

    }

    // returns true if the card is upwards
    public boolean cardUpwards(){
        return this.cardUpwards;
    }

    // flips the card and returns the new state of the card
    public boolean flip(){
        this.cardUpwards =! this.cardUpwards;
        return this.cardUpwards();
    }

    // returns the character of the card depending on its state
    public char character(int i, int j){
        if(this.cardUpwards()) return this.front[i][j];
        else                   return Card.back[i][j];
    }

    // compares if two cards have the same word
    public static boolean compare(Card a, Card b){
        // the function returns true when both words are equal
        return (a.word.equals(b.word))?true:false;
    }

    public static void setBackFigure(int fig){
        // generates a random letter
        char randChar=(char)(rand.nextInt(26)+0x41);

        // sets the back face of the card depending on the figure selected
        switch(fig){
            
            // square
            case 0:
                for(int i=0;i<Card.HEIGHT;i++){
                    for(int j=0;j<Card.WIDTH;j++){
                        // the first parentesis makes the big square and the second the small one

                        if((i>1 && i<6 && j>1 && j<6) && !(i>2 && i<5 && j>2 && j<5)) Card.back[i][j]=randChar;
                        else Card.back[i][j]='0';
                    }
                }
            break;
            // Diagonal Two squares
            case 1:
                for(int i = 0; i < Card.HEIGHT; i++){
                    for(int j = 0; j < Card.WIDTH; j++){
                        if((i > 0 && i < 4 && j > 0 && j < 4) || (i > 3 && i < 7 && j > 3 && j < 7)) {
                            Card.back[i][j] = randChar;
                        } else {
                            Card.back[i][j] = '0';
                        }
                    }
                }
            break;
            // X
            case 2:
                for(int i = 0; i < Card.HEIGHT; i++){
                    for(int j = 0; j < Card.WIDTH; j++){
                        //(X)  the first and the last empty lines && Make the principal diagonal and the second one
                        if((i > 0 && i < 7) && (i == j || i + j == 7)) {
                            Card.back[i][j] = randChar;
                        } else {
                            Card.back[i][j] = '0';
                        }
                    }
                }
            break;
            //cross
            case 3:
                for(int i = 0; i < Card.HEIGHT; i++){
                    for(int j = 0; j < Card.WIDTH; j++){
                        if(((i > 1 && i < 6) && (j>2 && j<5)) || ((i > 2 && i < 5) && (j>1 && j<6)) ) {
                            Card.back[i][j] = randChar;
                        } else {
                            Card.back[i][j] = '0';
                        }
                    }
                }
            break;
            // Diagonal 3 squares
            case 4:
                for(int i = 0; i < Card.HEIGHT; i++){
                    for(int j = 0; j < Card.WIDTH; j++){
                        // the first parenthesis makes the first square
                        // the second parenthesis makes the second square
                        // the third parenthesis makes the third square

                        if(((i > 0 && i < 3) && (j > 0 && j < 3)) ||((i > 2 && i < 5) && (j > 2 && j < 5))
                                || ((i > 4 && i < 7) && (j > 4 && j < 7)) ) {
                            Card.back[i][j] = randChar;
                        } else {
                            Card.back[i][j] = '0';
                        }
                    }
                }
            break;
            //chessboard
            case 5:
                for(int i = 0; i < Card.HEIGHT; i++){
                    for(int j = 0; j < Card.WIDTH; j++){
                        if ((i + j) % 2 == 0) {
                            Card.back[i][j] = randChar;
                        } else {
                            Card.back[i][j] = '0';
                        }
                    }
                }
            break;
            //Letter S (Sebastian)
            case 6:
                for(int i = 0; i < Card.HEIGHT; i++){
                    for(int j = 0; j < Card.WIDTH; j++){

                        // char S
                        if( ((i == 1 || i == 4 || i == 6) && (j > 0 && j < 7)) || ((i == 2 || i == 3) && j == 1) || (i == 5 && j == 6) ) {
                            Card.back[i][j] = randChar;
                        } else {
                            Card.back[i][j] = '0';
                        }
                    }
                }
            break;
            //Letter Y (Yazhwhan)
            case 7:
                for(int i = 0; i < Card.HEIGHT; i++){
                    for(int j = 0; j < Card.WIDTH; j++){
                        if( ((i > 0 && i < 4) && (i == j || i + j == 7)) || ((i > 3 && i < 7) && (j == 3 || j == 4)) ) {
                            Card.back[i][j] = randChar;
                        } else {
                            Card.back[i][j] = '0';
                        }
                    }
                }
            break;
            //Letter M (Mauricio)
            case 8:
                for(int i = 0; i < Card.HEIGHT; i++){
                    for(int j = 0; j < Card.WIDTH; j++){
                        if( ((i > 0 && i < 7) && (j == 1 || j == 6)) || ((i > 0 && i < 4) && (i == j || i + j == 7)) ) {
                            Card.back[i][j] = randChar;
                        } else {
                            Card.back[i][j] = '0';
                        }
                    }
                }
                break;
        }
    }

    // if there's no argument the figure must be the square
    public static void setBackFigure(){
        Card.setBackFigure(0);
    }


    public static void printFiguresList(){
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
    }

}
