import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pacman extends JPanel implements ActionListener, KeyListener{
    // instance variables
    Timer timer = new Timer(1000, this);

    boolean GameRunning = false;
    boolean GameOver = false;
    boolean GamePaused = true;
    boolean InMenu = true;

    // Game components
    private Player player;
    private Ghosts[] ghosts=new Ghosts[4];
    private Maze maze;

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
        player=new Player(Color.YELLOW, this);
        for(int i=0;i<ghosts.length;i++){
            ghosts[i]=new Ghosts(getRandomColor(), this, 480,280);
        }

        timer.restart();
    }

    // all sprites will be in a random color for fun
    private Color getRandomColor() {
        Color color = new Color
        // the color will always be lighter since we want a dark background
        ((int) (Math.random() * 120 + 135), (int) (Math.random() * 120 + 135), (int) (Math.random() * 120 + 135));
        return color;
    }
    // Game Cycle
    public void GameCycle(){
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

    }
    // Game States

    // Game logic

    // Event Listeners
    public void actionPerformed(ActionEvent e){
        if(GameRunning){
            GameCycle();
        }
    }
    public void keyPressed(KeyEvent e){
        int keyCode=e.getKeyCode();
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
            GameOver=false;
        }
    }
    public void keyReleased(KeyEvent e){

    }
    public void keyTyped(KeyEvent e){

    }

    
}
