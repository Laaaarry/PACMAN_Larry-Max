import java.awt.*;
import java.awt.geom.*;

// the entire game "map" is a grid comprised of 50 by 50 blocks - Lawrence
public class GridPiece extends SpriteBase{
    // instance variables
    private boolean isWall; // whether the block is a wall or not
    public static double gridSize=50;
    private Pacman pacman;

    // constructor
    public GridPiece(boolean isWall, Color color, int x, int y, Pacman p){
        // parent class constructor
        super(new Rectangle2D.Double(x,y,gridSize,gridSize),color);
        this.isWall=isWall;
        this.pacman=p;
        this.isWall=isWall;
    }

    public void drawGridPiece(Graphics g){
        // only draws piece if it is a wall
        if(isWall){
            super.draw(g);
        }
    }
    
    public boolean checkWall(){
        // returns whether this piece is a wall or not
        return isWall;
    }
}
