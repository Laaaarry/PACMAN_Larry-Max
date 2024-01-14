import java.awt.*;
import java.awt.geom.*;
public class GridPiece extends SpriteBase{
    private boolean isWall;
    public static double gridSize=50;
    private Pacman pacman;

    public GridPiece(boolean isWall, Color color, int x, int y, Pacman p){
        super(new Rectangle2D.Double(x,y,gridSize,gridSize),color);
        this.isWall=isWall;
        this.pacman=p;
        this.isWall=isWall;
    }

    public void drawGridPiece(Graphics g){
        if(isWall){
            super.draw(g);
        }
    }
    
    public boolean checkWall(){
        return isWall;
    }
}
