import java.awt.*;

// a class that determines how many points to create and where the points are - Lawrence
public class PointsLayout {
    // essentially the same array as the one in Maze, except the 8 pieces at the center are "walls" - Lawrence
    private boolean[][]isWall={
        {true, true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true},
        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
        {true, false, true,  true,  false, true,  false, true,  true,  true,  true,  true,  true,  false, true,  false, true,  true,  false, true},
        {true, false, true,  true,  false, true,  false, false, false, false, false, false, false, false, true,  false, true,  true,  false,true},
        {true, false, false, false, false, false, false, true,  true,  true,  true,  true,  true,  false, false, false, false, false, false, true},
        {true, false, true,  false, true,  true,  false, true,  true, true, true, true, true,  false, true,  true,  false, true,  false, true},
        {true, false, true,  false, true,  true,  false, true,  true, true, true, true, true,  false, true,  true,  false, true,  false, true},
        {true, false, false, false, false, false, false, true,  true,  true,  true,  true,  true,  false, false, false, false, false, false, true},
        {true, false, true,  true,  false, true,  false, false, false, false, false, false, false, false, true,  false, true,  true,  false,true},
        {true, false, true,  true,  false, true,  false, true,  true,  true,  true,  true,  true,  false, true,  false, true,  true,  false, true},
        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
        {true, true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true}
        };
    // 1D array that stores all the points
    private Points[]pointsLayout;
    private Pacman pacman;

    // constructor
    public PointsLayout(Pacman p){
        this.pacman=p;
        spawnPoints();
    }

    // creates all the points that would exist in the game
    // checks the number of places that are available for a point (places that are not walls)
    // and sets the pointsLayout array to be that size
    // then fills that array with instances of Points
    public void spawnPoints(){
        int numberOfPoints=0;
        for(int i=0;i<isWall.length;i++)
        {
            for(int j=0;j<isWall[i].length;j++)
            {
                if(!isWall[i][j]){
                    numberOfPoints++;
                }
            }
        }
        pointsLayout=new Points[numberOfPoints];
        int count=0;
        for(int i=0;i<isWall.length;i++)
        {
            for(int j=0;j<isWall[i].length;j++)
            {
                if(!isWall[i][j]){
                    pointsLayout[count]=new Points(j*50+20,i*50+20, pacman.getRandomColor(), pacman);
                    count++;
                }
            }
        }
    }

    // loops through each point, and draws each point using the method in Points
    public void drawAllPoints(Graphics g){
        for(int i=0;i<pointsLayout.length;i++)
        {
            pointsLayout[i].drawPoints(g);     
        }
    }

    // loops through each point and calls the respawn method
    public void checkRespawn(){
        for(int i=0;i<pointsLayout.length;i++)
        {
            pointsLayout[i].respawn();
        }
    }

    // returns the array that contains all the Points
    public Points[] getList(){
        return pointsLayout;
    }
}
