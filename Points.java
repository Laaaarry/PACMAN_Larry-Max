import java.awt.*;
import java.awt.geom.*;

public class Points extends SpriteBase{
    // instance variables
    private static int size=10; // size of sprite
    private int value=10; // points given when eaten
    private boolean isEaten = false; 
    Pacman pacman;

    public Points(int x,int y, Color color, Pacman p){
        super(new Ellipse2D.Double(x,y,size,size), color);
        this.pacman=p;
    }

    public void drawPoints(Graphics g){
        if(!isEaten){
            super.draw(g);
        }
    }
}
