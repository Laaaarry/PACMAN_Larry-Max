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
    private GridPiece[][]mapLayout=new GridPiece[12][20];
    private Color MazeColor;


    public Maze(Pacman p, Color color){
        this.pacman=p;
        this.MazeColor=color;
        createMaze();

    }
    public void createMaze()
    {
        for(int i=0;i<mapLayout.length;i++)
        {
            for(int j=0;j<mapLayout[i].length;j++)
            {
                mapLayout[i][j]=new GridPiece (isWall[i][j],MazeColor,j*50,i*50,pacman);
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

    public GridPiece[][]getLayout(){
        return mapLayout;
    }
}
