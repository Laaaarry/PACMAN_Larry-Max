import java.awt.*;
import java.awt.geom.*;
public class Ghosts extends SpriteBase {
    private static int radius = 50;
    private int xPos;
    private int yPos;
    private Pacman pacman;
    private Image sprite;
    private int speedX;
    private int speedY;

    public Ghosts(Image image, Color color, Pacman p, int x, int y){
        super(new Ellipse2D.Double(x,y,radius,radius),color);
        this.pacman=p;
        this.sprite=image;
        this.xPos=x;
        this.yPos=y;
    }

    public void moveGhost(){
        
    }
    public void drawGhost(Graphics g){
        //super.draw(g);
        //g.drawImage(sprite, xPos, yPos, pacman);
    }
}
