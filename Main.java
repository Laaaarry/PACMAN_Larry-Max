import javax.swing.*;

// class that contains the frame and main method that runs the program
public class Main extends JFrame{
    private int frameHeight=600;
    private int frameWidth=1000;
    public static void main(String[]args){
        new Main();
    }
    public Main(){
        Pacman pac=new Pacman();
        //System.out.println(pac.getHeight()+" "+pac.getWidth());
        this.setTitle("PACMAN");
        this.setSize(frameWidth,frameHeight);
        this.setResizable(false);

        this.add(pac);
        this.setVisible(true);
    }
}