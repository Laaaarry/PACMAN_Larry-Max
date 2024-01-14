import javax.swing.*;

// class that contains the frame and main method that runs the program
public class Main extends JFrame{

    public static void main(String[]args){
        new Main();
    }
    public Main(){
        Pacman pac=new Pacman();
        // Basic frame attributes
        this.setTitle("PACMAN");
        this.setSize(1012,637);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Adding pacman
        this.add(pac);
        
        this.setVisible(true);
    }
}