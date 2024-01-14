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
    private Points[]points;
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
        maze=new Maze(this);
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
        checkCollisions();
        repaint();
        System.out.print("cycle\t");
    }
    // Paint methods
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;
        player.drawPacman(g);
        for(int i=0;i<ghosts.length;i++){
            ghosts[i].drawGhost(g);
        }
        maze.drawMaze(g);

    }
    // Game States

    // Game logic

    // does Pacman collide with a ghost?
    public void checkCollisions(){
        // creates a rectangle around player and ghosts
        Rectangle playerBox=player.getBounds();
        Rectangle[] ghostsBox=new Rectangle[ghosts.length];
        for(int i=0;i<ghostsBox.length;i++){
            ghostsBox[i]=ghosts[i].getBounds();
        }

        for(int i=0;i<ghostsBox.length;i++){
            if(playerBox.intersects(ghostsBox[i])){
                GameOver=true;
                GameRunning=false;
            }
        }
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
