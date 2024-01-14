import java.awt.*;
import java.awt.geom.*;

public class Player extends SpriteBase{
    private static int STARTx = 475;
    private static int STARTy = 400;
    private static int radius = 50;
    private int xPos=STARTx;
    private int yPos=STARTy;
    private int speedX;
    private int speedY;
    private Pacman pacman;
    
    public Player(Color color, Pacman p){
        super( new Ellipse2D.Double(STARTx,STARTy,radius,radius),color);
        this.pacman=p;
    }

    public void movePlayer(){
        if(getX()+speedX >=0 && (getX() + getWidth() + speedX <= pacman.getWidth())){
            super.move(speedX,0);
        }
        if(getY()+speedY >=0 && (getY() + getHeight() + speedY <= pacman.getHeight())){
            super.move(0,speedY);
        }
    }
    public void drawPacman(Graphics g){
        super.draw(g);
        //g.drawImage(sprite, xPos, yPos, pacman);
    }
}
