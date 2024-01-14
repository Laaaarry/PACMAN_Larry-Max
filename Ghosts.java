import java.awt.*;
import java.awt.geom.*;
public class Ghosts extends SpriteBase {
    private static int radius = 40;
    private int counter=0;
    private int xPos;
    private int yPos;
    private Pacman pacman;
    private int speedX;
    private int speedY;

    public Ghosts(Color color, Pacman p, int x, int y){
        super(new Rectangle2D.Double(x,y,radius,radius),color);
        this.pacman=p;
        this.xPos=x;
        this.yPos=y;
    }

    public void moveGhost(){
        counter++;
        if(counter>=10){
            
        }
    }
    public void drawGhost(Graphics g){
        super.draw(g);
        //g.drawImage(sprite, xPos, yPos, pacman);
    }
}
