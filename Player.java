import java.awt.*;
import java.awt.geom.*;

public class Player extends SpriteBase{
    private static int STARTx = 480;
    private static int STARTy = 405;
    private static int size = 40;
    private int baseSpeed=10;
    private int speedX;
    private int speedY;
    private Pacman pacman;
    
    public Player(Color color, Pacman p){
        super( new Ellipse2D.Double(STARTx,STARTy,size,size),color);
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
    public void setSpeed(int direction){
        if(direction==1){
            speedY=-baseSpeed;
        }
        if(direction==2){
            speedX=baseSpeed;
        }
        if(direction==3){
            speedY=baseSpeed;
        }
        if(direction==4){
            speedX=-baseSpeed;
        }
        if(direction==0){
            speedX=0;
        }
        if(direction==10){
            speedY=0;
        }
    }
    public void drawPacman(Graphics g){
        super.draw(g);
        //g.drawImage(sprite, xPos, yPos, pacman);
    }
}
