import java.awt.*;
import java.awt.geom.*;
// Lawrence and Max
public class Ghosts extends SpriteBase {
    // instance variables
    private static int size = 40;
    private int initialCounter=0; // we needed the ghosts to move out of their box
    private int randomizationCounter=99; 
    // every 100 game cycles, the ghost's speed is randomized, 
    // but we want the ghosts to start moving instantly after their initialization period ends
    private Pacman pacman;
    private int baseSpeed = 10;
    private int speedX;
    private int speedY;

    // constructor
    public Ghosts(Color color, Pacman p, int x, int y){
        super(new Rectangle2D.Double(x,y,size,size),color);
        this.pacman=p;
    }

    // moves the ghost up, out of their box in the first few cycles of the game
    public void initGhost(){
        speedY=-baseSpeed;
        moveGhostY();
        initialCounter++;
    }
    
    // the main function for moving ghosts
    public void moveGhost(){
        // if the game has just started, moves the ghost up and out of the box, through the walls
        if(initialCounter<12){
            initGhost();
        }
        // otherwise, uses random movements
        else{
            randomMovement();
            baseMovement();
        }
    }

    // the basic movement method
    // uses same type of code as Player class to ensure it doesn't go through walls
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

    // changes the x and y speeds of the ghosts randomly
    // every 100 cycles or when the current speed is 0
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

    // randomly sets the x-direction to be left or right
    public void randomMovementX(){
        double random = Math.random();
        if(random>0.5){
            speedX=baseSpeed;
        }
        else{
            speedX=-baseSpeed;
        }
    }

    // randomly sets the y-direction to be up or down
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

    // draws the ghost
    public void drawGhost(Graphics g){
        super.draw(g);
    }

    // Lawrence & Max
    // creates and returns a "projection" of the ghost after moving in the x or y direction
    // used to check if the ghost is still "in bounds"
    // (uses same code as Player class)
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
