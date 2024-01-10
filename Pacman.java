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

    // Constructor
    public Pacman(){
        addKeyListener(this);
        setSize(1000,600);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        this.setFocusable(true);
        timer.start();
    }
    // Game Cycle
    public void GameCycle(){
        System.out.print("cycle\t");
    }
    // Paint methods

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
