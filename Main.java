import javax.swing.*;

// class that contains the frame and main method that runs the program
public class Main extends JFrame{
    private int frameHeight;
    private int frameWidth;
    public static void main(String[]args){
        new Main();
    }
    public Main(){
        Pacman pac=new Pacman();
        //System.out.println(pac.getHeight()+" "+pac.getWidth());
        frameHeight=pac.getHeight();
        frameWidth=pac.getWidth();
        // Basic frame attributes
        this.setTitle("PACMAN");
        this.setSize(frameWidth,frameHeight);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Adding pacman
        this.add(pac);
        
        this.setVisible(true);
    }
}