package com.github.equipo1;

import java.util.Random;

public class Board {

    public static final int WIDTH=5;
    public static final int HEIGHT=2;


    private Card matrix[][]=new Card [Board.HEIGHT][Board.WIDTH];



    private int numOfUpwardsCards=0;

    public String words[]=new String[5];


    public Board(String words[]){

        for(int i=0;i<5;i++)
            this.words[i]=words[i];
        
        createCards();


    }


    // prints the cards on the board
    public void printBoard(){

        for(int row=0; row < Board.HEIGHT; row++){

            for(int cardRow=0;cardRow<Card.HEIGHT;cardRow++){
                
                for(int column=0;column<Board.WIDTH;column++){
                    
                    for(int cardColumn=0;cardColumn<Card.WIDTH;cardColumn++){

                        // if the card is upwards it prints its front face else, prints the back face
                        System.out.print(matrix[row][column].character(cardRow, cardColumn));
                    
                    }
                    System.out.print('\t');
                    
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        
    }

    // returns the number of cards that are upwards
    public int getNumOfUpwardsCards(){
        return this.numOfUpwardsCards;
    }

    // returns true if both cards are the same, recieves numbers from 1 to 10
    public boolean compareCards(int num1, int num2){
        num1--;
        num2--;
        return Card.compare(this.matrix[num1/5][num1%5], this.matrix[num2/5][num2%5]);

     }

    // recieves a number from 1 to 10 and returns true if the card is upwards
    public boolean getCardStatus(int card){
        card--;
        return this.matrix[card/5][card%5].cardUpwards();
    }
    
    // recives a number from 1 to 10 and flips that card
    public void flipCard(int num){
        
        num--;


        // if after the flip the card is upwards the numOfUpwardsCards must increment by one, else it must decrement by one 
        if(this.matrix[num/5][num%5].flip()) this.numOfUpwardsCards++;
        else this.numOfUpwardsCards--;
        
        

        

    }

    // clears the screen
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // creates the matrik of carts based on the words 
    private void createCards(){
        // so we cant count how many cards of each word we have
        int wordsAdded[]=new int[5];
        
        // there are 0 cards of each word at the beggining
        for(int i=0;i<5;i++){
            wordsAdded[i]=0;
        }

        for(int i=0;i<Board.HEIGHT;i++){
            for(int j=0;j<Board.WIDTH;j++){
                Random rand=new Random();
                
                int x = rand.nextInt(5);

                if (wordsAdded[x]==2)
                    // the word has already 2 cards of it
                    j--;
                
                else{

                    // we create a card with the word 
                    this.matrix[i][j]=new Card(this.words[x]);
                    
                    // we have one more card with that word
                    wordsAdded[x]++;
                }
            }
        }






        
    }

}
