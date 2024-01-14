import java.awt.*;

public class PointsLayout {
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
    private Points[]pointsLayout;

    private Pacman pacman;

    public PointsLayout(Pacman p){
        this.pacman=p;
        spawnPoints();
    }

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

    public void drawAllPoints(Graphics g){
        for(int i=0;i<pointsLayout.length;i++)
        {
            pointsLayout[i].drawPoints(g);     
        }
    }

    public void checkRespawn(){
        for(int i=0;i<pointsLayout.length;i++)
        {
            pointsLayout[i].respawn();
        }
    }

    public Points[] getList(){
        return pointsLayout;
    }
}
