import java.awt.*;
import java.awt.geom.*;

// SpriteBase class used as a basis for most sprites in the game
// Class taken from Lawrence's grade 11 compsci culminating
public class SpriteBase {
    // basic attributes of a sprite
    private Color color;
    private RectangularShape shape;

    // constructor
    public SpriteBase(RectangularShape shape, Color color) {
        this.color = color;
        this.shape = shape;
    }

    // returns the boundaries of the sprite. useful for checking for intersections
    public Rectangle getBounds() {
        return shape.getBounds();
    }

    // gets attributes of sprite using methods of the RectangularShape class
    // gets X-coordinate of the top right corner of the sprite
    public double getX() {
        return shape.getX();
    }

    // gets the Y-coordinate of the top right corner of the sprite
    public double getY() {
        return shape.getY();
    }

    // gets width (x) of object
    public double getWidth() {
        return shape.getWidth();
    }

    // gets height (y) of object
    public double getHeight() {
        return shape.getHeight();
    }

    // draws the sprite
    public void draw(Graphics g) {
        // uses Graphics2D because of of the RectangularShape
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fill(shape);
    }

    // moves the sprite by altering the sprite's coordinates while keeping its dimensions
    public void move(double xDir, double yDir) {
        shape.setFrame(getX() + xDir, getY() + yDir, getWidth(), getHeight());
    }

    // moves the sprite to a specified position
    public void resetPosition(int STARTx, int STARTy) {
        shape.setFrame(STARTx, STARTy, getWidth(), getHeight());
    }
}
