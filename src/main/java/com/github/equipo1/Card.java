package com.github.equipo1;

public class Card {
    // card dimensions
    public  static final int  width=8;
    public  static final int  height=8;
    private static final char frontBottom='-';
    private static final char backgroundCharacter=' ';


    // faces of the card
    public        char [][] front=new char[height][width];
    public static char [][] back =new char[height][width];
    

    // word that the card will have asigned
    private String word;



    
    public Card(String w){
        //first we save the word
        this.word=w;
        for (int i=0;i<Card.height;i++){

            for(int j=0; j<Card.width;j++){
                
                // if we are a the bottom the character must be the one specified
                if(i==Card.height-1)     front[i][j]=frontBottom;


                // else if we are on the spaces destinated for the word the characters must the word ones
                else if(i==3 && j<Card.width-1 && j>0 )  this.front[i][j]=this.word.charAt(j-1);

                // if neither of the other options were correct it because the character must be the background of the card
                else this.front[i][j]=Card.backgroundCharacter;
                
            }
        }


    }

    public static boolean compare(Card a, Card b){
        // the function returns true when both words are equal
        return (a.word.equals(b.word))?true:false;
    }

    public static void setBackFigure(int fig){
        
        switch(fig){
            
            // square
            case 0:
                for(int i=0;i<Card.height;i++){
                    for(int j=0;j<Card.width;j++){
                        // the first parentesis makes the big square and the second the small one
                        if((i>1 && i<6 && j>1 && j<6) && !(i>2 && i<5 && j>2 && j<5)) Card.back[i][j]='x';
                        else Card.back[i][j]='0';
                    }
                }
            
        }
    }


}
