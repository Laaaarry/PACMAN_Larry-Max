import javax.swing.*;

// class that contains the frame and main method that runs the program
public class Main extends JFrame{
    // main method
    public static void main(String[]args){
        // creates instance of the game
        new Main();
    }

    // constructor for the frame that holds the pacman panel
    public Main(){
        // creates instance of pacman
        Pacman pac=new Pacman();
        // Basic frame attributes
        this.setTitle("PACMAN");
        this.setSize(1012,637);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Adding pacman
        this.add(pac);
        // making visible
        this.setVisible(true);
    }
}