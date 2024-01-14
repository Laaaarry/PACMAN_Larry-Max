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
    private Points[][]pointsLayout=new Points[12][20];

    private Pacman pacman;

    public PointsLayout(Pacman p){
        this.pacman=p;
        spawnPoints();
    }

    public void spawnPoints(){
        for(int i=0;i<pointsLayout.length;i++)
        {
            for(int j=0;j<pointsLayout[i].length;j++)
            {
                if(!isWall[i][j]){
                    pointsLayout[i][j]=new Points(j*50+20,i*50+20, pacman.getRandomColor(), pacman);
                }
            }
        }
    }

    public void drawAllPoints(Graphics g){
        for(int i=0;i<pointsLayout.length;i++)
        {
            for(int j=0;j<pointsLayout[i].length;j++)
            {
                if(!isWall[i][j]){
                    pointsLayout[i][j].drawPoints(g);
                }
            }
        }
    }
}
