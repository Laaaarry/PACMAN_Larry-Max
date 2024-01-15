import java.awt.*;
// class for displaying the scores and keeping track of the high score
public class Scores 
{
    // instance variables
    private Pacman p;
    private int highScore=0;
    
    // constructor
    public Scores(Pacman p)
    {
        this.p=p;
    }
    
    //setting scoreboard
    public void setScore(Graphics g)
    {
        p.GameText("Score: "+p.score,80,580,Color.WHITE,15,g);
    }
    
    public void setHighScore(Graphics g)
    {
        if(p.score>highScore)
        {
            highScore=p.score;
        }
            p.GameText("High Score: "+highScore,200,580,Color.WHITE,15,g);
    }

    // a method that returns the high score
    public int getHighScore(){
        return highScore;
    }
}
