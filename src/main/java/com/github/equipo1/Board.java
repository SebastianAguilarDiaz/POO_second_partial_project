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
                    System.out.print(' ');
                    
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        
    }

    // returns true if the card is upwards
    public boolean getCardStatus(int num){
        num--;
        return (this.upwardsCards[num/5][num%5])?true:false;
    }

    // returns the of both cards are the same
    public boolean compareCards(int num1, int num2){
        num1--;
        num2--;
        return Card.compare(this.matrix[num1/5][num1%5], this.matrix[num2/5][num2%5]);

     }

    // recives a number from 1 to 10 and flips that card
    public void flipCard(int num){
        
        
        // if the card is already upwards it would be backwards so the number of upwards cards decreases by one
        if(this.getCardStatus(num)) this.numOfUpwardsCards--;
        else this.numOfUpwardsCards++;
        
        num--;

        this.upwardsCards[num/5][num%5] = !this.upwardsCards[num/5][num%5];

    }

    // clears the screen
    public static void clearScreen(){
    
    }



}
