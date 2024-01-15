import java.awt.*;
import java.awt.geom.*;

// class of the "pacman" or the player, extends SpriteBase
public class Player extends SpriteBase {
    // attributes of the player (self-explanatory)
    private static int STARTx = 480;
    private static int STARTy = 400;
    private static int size = 40;
    private int baseSpeed = 10;
    private int speedX;
    private int speedY;
    private Pacman pacman; // panel for reference

    // constructor
    public Player(Color color, Pacman p) {
        // calls parent class constructor
        super(new Ellipse2D.Double(STARTx, STARTy, size, size), color);
        this.pacman = p;
    }

    // moves the player (called in the game cycle) - Lawrence & Max
    public void movePlayer() {
        // every time the movePlayer method is called, checks if the player will move "out of bounds" after the movement
        // if the player does, sets the speed to 0 to stop the player from moving
        if (!pacman.inMazeX()) {
            speedX = 0;
        }
        if (!pacman.inMazeY()) {
            speedY = 0;
        }
        // moves the player
        movePlayerX();
        movePlayerY();
    }

    // moves the player in the x-direction using the parent class' move method
    public void movePlayerX() {
        if (getX() + speedX >= 0 && (getX() + getWidth() + speedX <= pacman.getWidth())) {
            super.move(speedX, 0);
        }
    }

    // moves the player in the y-direction using the parent class' move method
    public void movePlayerY() {
        if (getY() + speedY >= 0 && (getY() + getHeight() + speedY <= pacman.getHeight())) {
            super.move(0, speedY);
        }
    }

    // sets the player's speed in response to the key listener in the Pacman class
    public void setSpeed(int direction) {
        if (direction == 1) {
            speedY = -baseSpeed;
        }
        if (direction == 2) {
            speedX = baseSpeed;
        }
        if (direction == 3) {
            speedY = baseSpeed;
        }
        if (direction == 4) {
            speedX = -baseSpeed;
        }
        if (direction == 0) {
            speedX = 0;
        }
        if (direction == 10) {
            speedY = 0;
        }
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

    // draws the player on the panel
    public void drawPacman(Graphics g) {
        super.draw(g);
    }

    // uses the parent class' method to move the player back to its starting position
    public void resetPosition() {
        super.resetPosition(STARTx, STARTy);
    }
}
