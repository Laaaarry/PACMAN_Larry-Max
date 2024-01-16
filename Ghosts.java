import java.util.*;
import java.awt.*;
import java.awt.geom.*;
public class Ghosts extends SpriteBase {
    private static int size = 40;
    private int initialCounter=0;
    private int randomizationCounter=99;
    private int xPos;
    private int yPos;
    private Pacman pacman;
    private int baseSpeed = 10;
    private int speedX;
    private int speedY;

    public Ghosts(Color color, Pacman p, int x, int y){
        super(new Rectangle2D.Double(x,y,size,size),color);
        this.pacman=p;
        this.xPos=x;
        this.yPos=y;
    }

    public void initGhost(){
        speedY=-baseSpeed;
        moveGhostY();
        initialCounter++;
    }
    public void moveGhost(){
        if(initialCounter<12){
            initGhost();
        }
        else{
            randomMovement();
            baseMovement();
        }
    }

    public void baseMovement(){
        if (!pacman.GhostsInMazeX(getProjectionX())) {
            speedX = 0;
        }
        if (!pacman.GhostsInMazeY(getProjectionY())) {
            speedY = 0;
        }
        moveGhostX();
        moveGhostY();
    }

    public void randomMovement(){
        randomizationCounter++;
        if(randomizationCounter==100){
            randomMovementX();
            randomMovementY();
            randomizationCounter=0;
        }
        if(speedX==0){
            randomMovementX();
        }
        if(speedY==0){
            randomMovementY();
        }

    }

    public void randomMovementX(){
        double random = Math.random();
        if(random>0.5){
            speedX=baseSpeed;
        }
        else{
            speedX=-baseSpeed;
        }
    }

    public void randomMovementY(){
        double random = Math.random();
        if(random>0.5){
            speedY=baseSpeed;
        }
        else{
            speedY=-baseSpeed;
        }
    }

    // moves the ghost in the x-direction using the parent class' move method
    public void moveGhostX() {
        if (getX() + speedX >= 0 && (getX() + getWidth() + speedX <= pacman.getWidth())) {
            super.move(speedX, 0);
        }
    }

    // moves the ghost in the y-direction using the parent class' move method
    public void moveGhostY() {
        if (getY() + speedY >= 0 && (getY() + getHeight() + speedY <= pacman.getHeight())) {
            super.move(0, speedY);
        }
    }

    public void drawGhost(Graphics g){
        super.draw(g);
    }

    // Lawrence & Max
    // creates and returns a "projection" of the player after moving in the x or y direction
    // used to check if the player is still "in bounds"
    public Rectangle getProjectionX() {
        Rectangle projection = this.getBounds();
        projection.setBounds((int) projection.getX() + speedX, (int) projection.getY(), (int) projection.getWidth(),
                (int) projection.getHeight());
        return projection;
    }

    public Rectangle getProjectionY() {
        Rectangle projection = this.getBounds();
        projection.setBounds((int) projection.getX(), (int) projection.getY() + speedY, (int) projection.getWidth(),
                (int) projection.getHeight());
        return projection;
    }
}
