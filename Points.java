import java.awt.*;
import java.awt.geom.*;

// sprite for the "pac-dots" that the player eats to earn points
public class Points extends SpriteBase{
    // instance variables
    private static int size=10; // size of sprite
    private int value=10; // points given when eaten
    private boolean isEaten = false; // determines whether the point exists or has been eaten
    private int counter=0; // counter used to determine when to "respawn" the point
    private Pacman pacman; // reference for panel

    // constructor
    public Points(int x,int y, Color color, Pacman p){
        // calls parent class constructor
        super(new Ellipse2D.Double(x,y,size,size), color);
        this.pacman=p;
    }

    // draws the sprite if the point has not been eaten
    public void drawPoints(Graphics g){
        if(!isEaten){
            super.draw(g);
        }
    }

    // called after the point is eaten
    public void eaten(){
        isEaten=true;
    }

    // returns the value of the point to add to the score
    public int scored(){
        return value;
    }

    // called every game cycle
    // once the counter reaches a certain number (when a certain amount of time has passed)
    // the point is "respanwed"
    public void respawn(){
        if(isEaten){
            counter++;
            if(counter>=100){
                isEaten=false;
                counter=0;
            }
        }
    }

    // checks if the point has been eaten or not
    public boolean isEaten(){
        return isEaten;
    }
}
