package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Scanner;

public class HelloController {
    @FXML
    private Label welcomeText;

    // here is the matrix for the chess board

    char[][] g= new char[8][8];

    //these variables are for the track of the positions of the king and knight in the game
    int king_x=2;
    int king_y=1;
    int knight_x=2;
    int knight_y=2;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Special Game of Chess.");
        game();
    }

    public boolean check_king(int u,int v)
    {
        if (u == king_x + 1 && king_y == v) {
            return true;
        } else if (v == king_y && u == king_x - 1) {
            return true;
        } else if (u == king_x && v == king_y - 1) {
            return true;
        } else if (u == king_x && v == king_y + 1) {
            return true;
        } else if (u == king_x - 1 && v == king_y - 1) {
            return true;
        } else if (u == king_x - 1 && v == king_y + 1) {
            return true;
        } else if (u == king_x + 1 && v == king_y - 1) {
            return true;
        } else if (u == king_x + 1 && v == king_y + 1) {
            return true;
        }

        return false;
    }

    public boolean isKingAttackingKnight(int u,int v)
    {

        if(u==king_x+1 && king_y==v) {
            return true;
        }
        else if(v==king_y && u==king_x-1)
        {
            return true;
        }
        else if(u==king_x && v==king_y-1)
        {
            return true;
        }
        else if(u==king_x && v==king_y+1)
        {
            return true;
        }
        else if(u==king_x-1 && v== king_y-1)
        {
            return true;
        }
        else if(u==king_x-1 && v==king_y+1)
        {
            return true;
        }
        else if(u==king_x+1 && v==king_y-1)
        {
            return true;
        }
        else if(u==king_x+1 && v==king_y+1)
        {
            return true;
        }

        return false;

    }

    public boolean isKnightAttackingKing(int u,int v)
    {
        if(u==king_x+2 && v==king_y+1 )
        {
            return true;
        }
        else if(u==king_x-2 && v==king_y+1)
        {
            return true;
        }
        else if(u==king_x+2 && v==king_y-1)
        {
            return true;
        }
        else if(u==king_x-2 && v==king_y-1)
        {
            return true;
        }
        else if(u==king_x+1 && v==king_y+2)
        {
            return true;
        }
        else if(u==king_x+1 && v==king_y-2)
        {
            return true;
        }
        else if(u==king_x-1 && v==king_y+2)
        {
            return true;
        }
        else if(u==king_x-1 && v==king_y-2)
        {
            return true;
        }

        return false;
    }

    public void print_board()
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                System.out.print(g[i][j]+" ");
            }
            System.out.println();
        }
    }

    public boolean check_knight(int u,int v)
    {
        if(u==knight_x+2 && v==knight_y+1 )
        {
            return true;
        }
        else if(u==knight_x-2 && v==knight_y+1)
        {
            return true;
        }
        else if(u==knight_x+2 && v==knight_y-1)
        {
            return true;
        }
        else if(u==knight_x-2 && v==knight_y-1)
        {
            return true;
        }
        else if(u==knight_x+1 && v==knight_y+2)
        {
            return true;
        }
        else if(u==knight_x+1 && v==knight_y-2)
        {
            return true;
        }
        else if(u==knight_x-1 && v==knight_y+2)
        {
            return true;
        }
        else if(u==knight_x-1 && v==knight_y-2)
        {
            return true;
        }

        return false;
    }

    public void game()
    {
        Scanner sc= new Scanner(System.in);
        int Player_Score=0;
        String Player_name;

        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                g[i][j]='0';
            }
        }

        // we represent our king by the character k
        // initializing the king
        g[king_x][king_y]='K';

        // we represent our knight as N and Goal as Winning Point
        // initializing the goal and the knight
        g[knight_x][knight_y]='N';
        g[0][6]='W';

        System.out.println("Here is our Game Board as follow:");
        print_board();

        int u=0,v=0;
        int piece=0;

        System.out.println("Enter Your Name Please:");
        Player_name=sc.next();

        System.out.println("Welcome to our Special Game "+ Player_name);

        while(g[u][v]!='W' )
        {
            //Here first of all we are taking input from the user that which piece he wants to move so that we can move that piece
            System.out.println("Enter the Piece you want to move, 1 for moving the king and 2 for moving the knight");
            piece=sc.nextInt();

            //here we are taking input from the user and asking for that which position he wants to move on
            System.out.println("Enter the row number:");
            u=sc.nextInt();
            System.out.println("Enter the column number:");
            v=sc.nextInt();

            //if the user enters 1 then we are moving the king
            if(piece==1)
            {
                //here we are checking whether the user enters the position which is in the range of the king like the real rules of the chess
                if(check_king(u,v))
                {
                    // here we are cheking if the position is valid and also the king or knight is attacking to any one or not
                    if(isKingAttackingKnight(u,v) || isKnightAttackingKing(u,v) )
                    {
                        g[king_x][king_y]='0';
                        king_y=v;
                        king_x=u;
                        g[king_x][king_y]='K';
                        System.out.println("Successfully Moved");
                        print_board();
                        Player_Score++;
                    }
                    else
                    {
                        System.out.println("Sorry, Invalid Move.");
                    }
                }
                else
                {
                    System.out.println("Sorry, Invalid Move outer.");
                }
            }


            // similarly as above we are discussing here
            else if(piece==2)
            {
                if(check_knight(u,v))
                {
                    if(isKingAttackingKnight(u,v) || isKnightAttackingKing(u,v) )
                    {
                        g[knight_x][knight_y]='0';
                        knight_y=v;
                        knight_x=u;
                        g[knight_x][knight_y]='N';
                        System.out.println("Successfully Moved");
                        print_board();
                        Player_Score++;
                        System.out.println("The score of the Player is : " + Player_Score);
                    }
                    else
                    {
                        System.out.println("Sorry, Invalid Move.");
                    }
                }
                else
                {
                    System.out.println("Sorry, Invalid Move outer");
                }

            }
            else
            {
                System.out.println("You chosed the wrong piece.");
            }
        }

        System.out.println("The score of the Player is : " + Player_Score);


        ScoreOfPlayers s= new ScoreOfPlayers(Player_Score, Player_name);


        // here we are outputing/encoding the data to XML file



    }


}