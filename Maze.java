import java.awt.*;
import java.awt.geom.*;

public class Maze {
     Pacman pacman;
      private boolean[][]isWall={
        {true, true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true},
        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
        {true, false, true,  true,  false, true,  false, true,  true,  true,  true,  true,  true,  false, true,  false, true,  true,  false, true},
        {true, false, true,  true,  false, true,  false, false, false, false, false, false, false, false, true,  false, true,  true,  false,true},
        {true, false, false, false, false, false, false, true,  true,  true,  true,  true,  true,  false, false, false, false, false, false, true},
        {true, false, true,  false, true,  true,  false, true,  false, false, false, false, true,  false, true,  true,  false, true,  false, true},
        {true, false, true,  false, true,  true,  false, true,  false, false, false, false, true,  false, true,  true,  false, true,  false, true},
        {true, false, false, false, false, false, false, true,  true,  true,  true,  true,  true,  false, false, false, false, false, false, true},
        {true, false, true,  true,  false, true,  false, false, false, false, false, false, false, false, true,  false, true,  true,  false,true},
        {true, false, true,  true,  false, true,  false, true,  true,  true,  true,  true,  true,  false, true,  false, true,  true,  false, true},
        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
        {true, true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true}
        };
        GridPiece[][]mapLayout=new GridPiece[12][20];



    public Maze(Pacman p){
        this.pacman=p;
        createMaze();
    }
    public void createMaze()
    {
        for(int i=0;i<mapLayout.length;i++)
        {
            for(int j=0;j<mapLayout[i].length;j++)
            {
                mapLayout[i][j]=new GridPiece (isWall[i][j],pacman.getRandomColor(),j*50,i*50,pacman);
            }
        }
    }

    public void drawMaze(Graphics g){
        for(int i=0;i<mapLayout.length;i++)
        {
            for(int j=0;j<mapLayout[i].length;j++)
            {
                mapLayout[i][j].drawGridPiece(g);
            }
        }
    }
}
