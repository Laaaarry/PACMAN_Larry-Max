import java.awt.*;
import java.awt.geom.*;

public class Maze {
    private Pacman pacman;//I think this needs to be not private
    private boolean[][]isWall={
        {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
        {true, false},
        {true, false},
        {true, false},
        {true, false},
        {true, false},
        {true, false},
        {true, false},
        {true, false},
        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
        {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
        };
        private GridPiece[][]mapLayout=new GridPiece[20][12];//I think this needs to be not private too



    public Maze(Pacman p){
        this.pacman=p;
    }
    public void createMaze(){
        
    }
}
