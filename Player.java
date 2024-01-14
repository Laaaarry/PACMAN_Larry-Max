import java.awt.*;
import java.awt.geom.*;

public class Player extends SpriteBase{
    private static int STARTx = 480;
    private static int STARTy = 400;
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
        if(!pacman.inMazeX()){
            speedX=0;
        }
        if(!pacman.inMazeY()){
            speedY=0;
        }
        movePlayerX();
        movePlayerY();
    }

    public void movePlayerX(){
        if(getX()+speedX >=0 && (getX() + getWidth() + speedX <= pacman.getWidth())){
            super.move(speedX,0);
        }
    }

    public void movePlayerY(){
        if(getY()+speedY >=0 && (getY() + getHeight() + speedY <= pacman.getHeight())){
            super.move(0,speedY);
        }
    }

    public void setSpeed(int direction){
        if(direction==1){
            speedY=-baseSpeed;
            //speedX=0;
        }
        if(direction==2){
            speedX=baseSpeed;
            //speedY=0;
        }
        if(direction==3){
            speedY=baseSpeed;
            //speedX=0;
        }
        if(direction==4){
            speedX=-baseSpeed;
            //speedY=0;
        }
        if(direction==0){
            speedX=0;
        }
        if(direction==10){
            speedY=0;
        }
    }

    public Rectangle getProjectionX(){
        Rectangle projection = this.getBounds();
        projection.setBounds((int)projection.getX()+speedX, (int)projection.getY(), (int)projection.getWidth(), (int)projection.getHeight());
        return projection;
    }
    public Rectangle getProjectionY(){
        Rectangle projection = this.getBounds();
        projection.setBounds((int)projection.getX(), (int)projection.getY()+speedY, (int)projection.getWidth(), (int)projection.getHeight());
        return projection;
    }
    public void drawPacman(Graphics g){
        super.draw(g);
        //g.drawImage(sprite, xPos, yPos, pacman);
    }
}
