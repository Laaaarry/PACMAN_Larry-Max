import java.awt.*;

// maze class creates the maze using instances of the GridPiece class
public class Maze {
    // instance variables
    Pacman pacman;
    
    // a 2D array mapping out the grid - Lawrence & Max
    // true means that piece in the grid is a wall, while false means that it isn't
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
    
    // a 2D array of "GridPiece" the same dimensions as the 2D array above
    private GridPiece[][]mapLayout=new GridPiece[12][20];

    // Color of the walls
    private Color MazeColor;

    // constructor
    public Maze(Pacman p, Color color){
        this.pacman=p;
        this.MazeColor=color;
        createMaze();

    }

    // creates the maze by looping through the mayLayout array, creating an instance of GridPiece for each element of the array
    // whether or not that GridPiece is a wall is determined by the array isWall - Max
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

    // draws the maze by looping through the 2D array and calling the 2D array
    public void drawMaze(Graphics g){
        for(int i=0;i<mapLayout.length;i++)
        {
            for(int j=0;j<mapLayout[i].length;j++)
            {
                mapLayout[i][j].drawGridPiece(g);
            }
        }
    }

    // returns the 2D array of GridPieces
    public GridPiece[][]getLayout(){
        return mapLayout;
    }
}
