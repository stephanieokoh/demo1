package com.example.demo1;

public class ScoreOfPlayers {

    int score;
    String name;

    public ScoreOfPlayers()
    {
        score=10;
        name="Stephanie";
    }

    public ScoreOfPlayers(int s,String a)
    {
        score=s;
        name=a;
    }

    public void printScoreandName()
    {

        System.out.println("Score "+score);
        System.out.println("Name "+ name);

    }

    public void setName(String name1,int size) {
        //  for(int i=0; i<size; i++)
        // {
        name=name1;
        //}
    }

    public int getScore() {
        return score;
    }

    public String getName()
    {
        return name;
    }
    public void setScore(int score1, int size) {
        //for(int i=0; i<size; i++)
        // {
        score=score1;
        // }
    }

}
