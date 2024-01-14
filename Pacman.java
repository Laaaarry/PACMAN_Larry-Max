import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pacman extends JPanel implements ActionListener, KeyListener{
    // instance variables
    Timer timer = new Timer(100, this);

    // Game states
    boolean GameRunning = false;
    boolean GameOver = false;
    boolean GamePaused = true;
    boolean InMenu = true;

    // Game components
    private Player player;
    private Ghosts[] ghosts=new Ghosts[4];
    private Maze maze;
    private GridPiece[][]gridList;
    private PointsLayout points;
    private Points[]pointList;
    private int score=0;

    // Constructor
    public Pacman(){
        addKeyListener(this);
        setSize(1000,600);
        this.setBackground(Color.BLACK);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        this.setFocusable(true);
        Reset();
    }

    private void Reset(){
        score=0;
        maze=new Maze(this);
        gridList=maze.getLayout();
        points=new PointsLayout(this);
        pointList=points.getList();
        player=new Player(Color.YELLOW, this);
        for(int i=0;i<ghosts.length;i++){
            ghosts[i]=new Ghosts(getRandomColor(), this, 480,280);
        }

        timer.restart();
    }

    // all sprites will be in a random color for fun
    public Color getRandomColor() {
        Color color = new Color
        // the color will always be lighter since we want a dark background
        ((int) (Math.random() * 120 + 135), (int) (Math.random() * 120 + 135), (int) (Math.random() * 120 + 135));
        return color;
    }
    // Game Cycle
    public void GameCycle(){
        player.movePlayer();
        // move ghosts
        checkCollisions();
        points.checkRespawn();
        repaint();
        System.out.print("cycle\t");
    }
    // Paint methods
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;
        maze.drawMaze(g);
        points.drawAllPoints(g);
        player.drawPacman(g);
        for(int i=0;i<ghosts.length;i++){
            ghosts[i].drawGhost(g);
        }
        

    }
    // Game States

    // Game logic
    public void checkCollisions(){
        // creates a rectangle around player, ghosts and points
        Rectangle playerBox=player.getBounds();

        Rectangle[] ghostsBox=new Rectangle[ghosts.length];
        for(int i=0;i<ghostsBox.length;i++){
            ghostsBox[i]=ghosts[i].getBounds();
        }

        Rectangle[]pointsBox=new Rectangle[pointList.length];
        for(int i=0;i<pointsBox.length;i++)
        {
            pointsBox[i]=pointList[i].getBounds();
        }

        // checks if pacman collides with ghost
        for(int i=0;i<ghostsBox.length;i++){
            if(playerBox.intersects(ghostsBox[i])){
                GameOver=true;
                GameRunning=false;
            }
        }

        // checks if pacman eats a point
        for(int i=0;i<pointsBox.length;i++)
        {
            if(playerBox.intersects(pointsBox[i])){
                pointList[i].eaten();
                score+=pointList[i].scored();
            }
        }
    }

    public boolean inMazeX(){
        boolean inBoundsX=true;
        Rectangle projectionBox=player.getProjectionX();
        for(int i=0;i<gridList.length;i++){
            for(int j=0;j<gridList[i].length;j++){
                if(gridList[i][j].checkWall()){
                    Rectangle gridBox=gridList[i][j].getBounds();
                    if(projectionBox.intersects(gridBox)){
                        inBoundsX=false;
                    }
                }
            }
        }
        return inBoundsX;
    }

    public boolean inMazeY(){
        boolean inBoundsY=true;
        Rectangle projectionBox=player.getProjectionY();
        for(int i=0;i<gridList.length;i++){
            for(int j=0;j<gridList[i].length;j++){
                if(gridList[i][j].checkWall()){
                    Rectangle gridBox=gridList[i][j].getBounds();
                    if(projectionBox.intersects(gridBox)){
                        inBoundsY=false;
                    }
                }
            }
        }
        return inBoundsY;
    }
    // Event Listeners
    public void actionPerformed(ActionEvent e){
        if(GameRunning){
            GameCycle();
        }
    }
    public void keyPressed(KeyEvent e){
        
        int keyCode=e.getKeyCode();

        // starting/pausing the game
        if(keyCode==KeyEvent.VK_ENTER && !GameRunning){
            GameRunning=true;
            GamePaused=false;
            InMenu=false;
            GameOver=false;
        }
        if(keyCode==KeyEvent.VK_ESCAPE && GameRunning){
            GameRunning=false;
            GamePaused=true;
            InMenu=true;
        }
        
        // moving Pacman
        // 1 is up, 2 is right, 3 is down, 4 is left
        if(keyCode==KeyEvent.VK_UP && GameRunning){
            player.setSpeed(1);
        } 
        if(keyCode==KeyEvent.VK_RIGHT && GameRunning){
            player.setSpeed(2);
        } 
        if(keyCode==KeyEvent.VK_DOWN && GameRunning){
            player.setSpeed(3);
        } 
        if(keyCode==KeyEvent.VK_LEFT && GameRunning){
            player.setSpeed(4);
        } 
    }
    public void keyReleased(KeyEvent e){
        int keyCode=e.getKeyCode();

        // 0 resets speedX, 10 resets speedY
        if(keyCode==KeyEvent.VK_UP && GameRunning){
            player.setSpeed(10);
        } 
        if(keyCode==KeyEvent.VK_RIGHT && GameRunning){
            player.setSpeed(0);
        } 
        if(keyCode==KeyEvent.VK_DOWN && GameRunning){
            player.setSpeed(10);
        } 
        if(keyCode==KeyEvent.VK_LEFT && GameRunning){
            player.setSpeed(0);
        } 
    }
    public void keyTyped(KeyEvent e){

    }

    
}
