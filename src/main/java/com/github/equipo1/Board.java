package com.github.equipo1;


public class Board {

    public static final int width=5;
    public static final int height=2;


    public Card matrix[][]=new Card [Board.height][Board.width];

    // its true if the card is upwards
    public boolean upwardsCards[][]=new boolean [Board.height][Board.width];

    public int numOfUpwardsCards=0;



    public Board(Card m[][]){


        for(int i=0;i<Board.height;i++){
            for(int j=0;j<Board.width;j++){
                matrix[i][j]=m[i][j];
                // the cards must be upwards at the beginning 
                upwardsCards[i][j]=false;
            }
        }


    }


    public void printBoard(){
        for(int row=0; row < Board.height; row++){
            for(int cardRow=0;cardRow<Card.height;cardRow++){
                for(int column=0;column<Board.width;column++){
                    for(int cardColumn=0;cardColumn<Card.width;cardColumn++){

                        // if the card is upwards it prints its front face else, prints the back face
                        if (upwardsCards[row][column]) System.out.print(this.matrix[row][column].front[cardRow][cardColumn]);
                        else System.out.println(Card.back[cardRow][cardColumn]);
                    }
                    
                }
            }
        }
        
    }

    // recives a number from 1 to 10 and flips that card
    public void flipCard(int num){
        num--;
        
        // if the card is already upwards it would be backwards so the number of upwards cards decreases by one
        if(upwardsCards[num/5][num%5]) this.numOfUpwardsCards--;
        else this.numOfUpwardsCards++;


        this.upwardsCards[num/5][num%5] = !this.upwardsCards[num/5][num%5];

    }



}
