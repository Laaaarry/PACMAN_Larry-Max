import java.awt.*;
import java.awt.geom.*;

public class Maze {
     Pacman pacman;
      private boolean[][]isWall={
        {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
        {true, false,true,true,false,true,false,true,true,true,true,true,true,false,true,false,true,true,false,true},
        {true,false,true,true,false,true,false,false,false,false,false,false,false,false,false,true,false,true,true,false,true},
        {true, false,false,false,false,false,false,true,true,true,true,true,true,false,false,false,false,false,false,true},
        {true, false,true,false,true,true,false,true,false,false,false,false,true,false,true,true,false,true,false,true},
        {true, false,true,false,true,true,false,true,false,false,false,false,true,false,true,true,false,true,false,true},
        {true, false,false,false,false,false,false,true,true,true,true,true,true,false,false,false,false,false,false,true},
        {true,false,true,true,false,true,false,false,false,false,false,false,false,false,false,true,false,true,true,false,true},
        {true, false,true,true,false,true,false,true,true,true,true,true,true,false,true,false,true,true,false,true},
        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
        {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
        };
         GridPiece[][]mapLayout=new GridPiece[20][12];



    public Maze(Pacman p){
        this.pacman=p;
    }
    public void createMaze()
    {
        for(int i=0;i<mapLayout.length;i++)
        {
            for(int j=0;j<mapLayout[i].length;i++)
            {
                GridPiece g1=new GridPiece (isWall[i][j],pacman.Color(),i*50,j*50,pacman);
                mapLayout[i][j]=g1;
            }
        }
    }
}
