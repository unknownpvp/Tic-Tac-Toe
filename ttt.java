/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class ttt {
        public static boolean userWin = false;
        public static boolean botWin = false;
        public static String[][] game = new String[3][3];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] ttt = new String[9]; 
        Scanner input = new Scanner(System.in);
        Random botMove = new Random();
        
        int user;
        int bot;
        int turn = 1;
        int count = 0;
        int type = 0;
        int winner = -1;
        int playAgain = 0;
        
        boolean cross = false;
        boolean naught = false;
        
        String firstName = " ";
        
        System.out.println("Welcome to TIC-TAC-TOE! You will go against a Computer. ");
        
        System.out.print("Please type your first name: ");
        firstName = input.next();
        System.out.print("Do you want to be naughts (O) or crosses (X)? Please type 0 for naughts or 1 for crosses: ");
        type = input.nextInt();
        
        //print board for user
        board();
        
        //assign mark for user and other for the bot
        if (type==0)
        {
           naught = true;  
        }
        else
        {
           cross = true;         
        }
        
        //create board of spaces
        for (int i=0;i<9;i++)
        {
            ttt[i]=" ";           
        }
        
        //loops the moves from user and computer
        while (!userWin && !botWin && count<9)
        {
            if(turn==0)
            {
                
                do //generate random bot move
                {
                    bot = botMove.nextInt(9);
                } 
                while (!ttt[bot].equals(" "));
                {
                    System.out.print("Computer's turn. \n");
                    botChoice(ttt,bot,naught,cross);
                    turn = 1;
                }
            }
            else if (turn==1)
            {
                
                do //generate user move
                {
                    System.out.printf("%s, please enter a number to place your mark: ",firstName);
                    user = input.nextInt();
                } 
                while (!ttt[user].equals(" "));
                {
                    System.out.println("Your turn. ");
                    userChoice(ttt,user,naught,cross);
                    turn = 0;
                }
            }
            
            //print board and check if their is winner
            winner = turn; 
            showBoard(ttt);
            endGame();
            count++;
            
            
        }
           
            //print winner
            switch (winner) 
            {
                case 0:
                    System.out.printf("You win, %s!\n",firstName);
                    break;
                case 1:
                    System.out.printf("%s you lost against a computer. Better luck next time!\n",firstName);
                    break;
                default:
                    System.out.printf("It's a draw. Good game %s.\n",firstName);
                    break;
            }
            
        
    }
    
    public static void board()
    {
        //print board of indices
        System.out.println("The board below has numbers which indicates the location. ");
        System.out.println();
        System.out.print(" 0 | 1 | 2 ");
        System.out.println();
        System.out.print("-----------");
        System.out.println();
        System.out.print(" 3 | 4 | 5 ");
        System.out.println();
        System.out.print("-----------");
        System.out.println();
        System.out.print(" 6 | 7 | 8 ");
        System.out.println();
        System.out.println();
    }
    
    public static void showBoard(String[] ttt)
    {
        //shows board of assigned locations in array that is looped
        for (int i=0;i<9;i++)
        {
            if (i==0)
            {
                System.out.printf(" %s | %s | %s ",ttt[0],ttt[1],ttt[2]);
                System.out.println();
                System.out.print("-----------");
                System.out.println();
                System.out.printf(" %s | %s | %s ",ttt[3],ttt[4],ttt[5]);
                System.out.println();
                System.out.print("-----------");
                System.out.println();
                System.out.printf(" %s | %s | %s ",ttt[6],ttt[7],ttt[8]);
                System.out.println();   
                game[0][0]=ttt[0];
                game[1][0]=ttt[1];
                game[2][0]=ttt[2];
                game[0][1]=ttt[3];
                game[1][1]=ttt[4];
                game[2][1]=ttt[5];
                game[0][2]=ttt[6];
                game[1][2]=ttt[7];
                game[2][2]=ttt[8];
                 
            }
            
        }
    }
    
    public static void userChoice(String[] ttt, int user, boolean naught, boolean cross)
    {
        //grabs the user choice between naughts and crosses
        if (naught)
        {
            ttt[user] = "O";
        }
        else if (cross)
        {
            ttt[user] = "X";
        }
        
    }
    
    public static void botChoice(String[] ttt,int bot, boolean naught, boolean cross)
    {
        //assigns the other mark for the bot
        if (naught)
        { 
            ttt[bot] = "X";
        }
        else if (cross)
        {
            ttt[bot] = "O";
        }
        
    }
    
    public static void endGame()
    {
        //check crosswin
        //check row1
        if (game[0][0].equals("X") && game[1][0].equals("X") && game[2][0].equals("X"))
        {
            userWin = true;
        }
        //check row2 horizontal
        else if (game[0][1].equals("X") && game[1][1].equals("X") && game[2][1].equals("X"))
        {
            userWin = true;       
        }
        //check row3 horizontal
        else if (game[0][2].equals("X") && game[1][2].equals("X") && game[2][2].equals("X"))
        {
            userWin = true;     
        }
        //check col1 vertical
        else if (game[0][0].equals("X") && game[0][1].equals("X") && game[0][2].equals("X"))
        {
            userWin = true;    
        }
        //check col2 vertical
        else if (game[1][0].equals("X") && game[1][1].equals("X") && game[1][2].equals("X"))
        {
            userWin = true;    
        }
        //check col3 vertical
        else if (game[2][0].equals("X") && game[2][1].equals("X") && game[2][2].equals("X"))
        {
            userWin = true;    
        }
        //check diagonal (\)
        else if (game[0][0].equals("X") && game[1][1].equals("X") && game[2][2].equals("X"))
        {
            userWin = true;   
        }
        //check diagonal (/)
        else if (game[2][0].equals("X") && game[1][1].equals("X") && game[0][2].equals("X"))
        {
            userWin = true;  
        }
        else
        {
            userWin = false;
        }
        
        //check naughtwin
        //check row1
        if (game[0][0].equals("O") && game[1][0].equals("O") && game[2][0].equals("O"))
        {
            botWin = true;
        }
        //check row2 horizontal
        else if (game[0][1].equals("O") && game[1][1].equals("O") && game[2][1].equals("O"))
        {
            botWin = true;       
        }
        //check row3 horizontal
        else if (game[0][2].equals("O") && game[1][2].equals("O") && game[2][2].equals("O"))
        {
            botWin = true;     
        }
        //check col1 vertical
        else if (game[0][0].equals("O") && game[0][1].equals("O") && game[0][2].equals("O"))
        {
            botWin = true;    
        }
        //check col2 vertical
        else if (game[1][0].equals("O") && game[1][1].equals("O") && game[1][2].equals("O"))
        {
            botWin = true;    
        }
        //check col3 vertical
        else if (game[2][0].equals("O") && game[2][1].equals("O") && game[2][2].equals("O"))
        {
            botWin = true;    
        }
        //check diagonal (\)
        else if (game[0][0].equals("O") && game[1][1].equals("O") && game[2][2].equals("O"))
        {
            botWin = true;   
        }
        //check diagonal (/)
        else if (game[2][0].equals("O") && game[1][1].equals("O") && game[0][2].equals("O"))
        {
            botWin = true;  
        }
        else
        {
            botWin = false;
        }
    }
    
}
