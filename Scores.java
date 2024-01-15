import java.awt.*;
public class Scores 
{
    private Pacman p;
    private int highScore=0;
    
    public Scores(Pacman p)
    {
        this.p=p;
    }
    
    //setting scoreboard
    public void setScore(Graphics g)
    {
        p.GameText("Score: "+p.score,0,600,Color.WHITE,15,g);
    }
    
    public void setHighScore(Graphics g)
    {
        if(p.score>highScore)
        {
            highScore=p.score;
        }
            p.GameText("High Score: "+highScore,100,600,Color.WHITE,15,g);
    }
}
