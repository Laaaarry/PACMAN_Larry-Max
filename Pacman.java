import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pacman extends JPanel implements ActionListener, KeyListener {
    // instance variables
    // Game states
    boolean GameNew = true;
    boolean GameRunning = false;
    boolean GameOver = false;
    boolean GamePaused = false;
    boolean InMenu = true;

    // Game components
    Timer timer = new Timer(100, this);
    private Player player;
    private Ghosts[] ghosts = new Ghosts[4];
    private Maze maze;
    private GridPiece[][] gridList;
    private PointsLayout points;
    private Points[] pointList;
    private int score = 0;
    private int lives = 3;

    // Colors
    private Color textColor = Color.WHITE;
    private Color pacmanBlue = new Color(25, 25, 166);

    // Constructor
    public Pacman() {
        addKeyListener(this);
        setSize(1000, 600);
        this.setBackground(Color.BLACK);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        this.setFocusable(true);
        Reset();
    }

    // Resets the game
    private void Reset() {
        score = 0;
        lives = 3;
        maze = new Maze(this, pacmanBlue);
        gridList = maze.getLayout();
        points = new PointsLayout(this);
        pointList = points.getList();
        player = new Player(Color.YELLOW, this);
        for (int i = 0; i < ghosts.length; i++) {
            ghosts[i] = new Ghosts(getRandomColor(), this, 480, 280);
        }
        timer.restart();
    }

    // Some sprites will be in a random color for fun
    public Color getRandomColor() {
        Color color = new Color
        // the color will always be lighter since we want a dark background
        ((int) (Math.random() * 120 + 135), (int) (Math.random() * 120 + 135), (int) (Math.random() * 120 + 135));
        return color;
    }

    // Game Cycle
    public void GameCycle() {
        player.movePlayer();
        // move ghosts
        checkCollisions();
        points.checkRespawn();
        repaint();
        System.out.print("cycle\t");
    }

    // Paint methods
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        maze.drawMaze(g);
        points.drawAllPoints(g);
        player.drawPacman(g);
        for (int i = 0; i < ghosts.length; i++) {
            ghosts[i].drawGhost(g);
        }

        if (!GameRunning) {
            drawMenu(g);
        }
    }

    // A method used for displaying text on screen
    public void GameText(String message, int x, int y, Color color, int size, Graphics g) {
        Font gFont = new Font("ComicSans", Font.BOLD, size);
        g.setFont(gFont);
        g.setColor(color);
        g.drawString(message, x, y);
    }

    // in game UI

    // menu screens
    public void drawMenu(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(250, 25, 500, 550);
        g.setColor(pacmanBlue);
        g.fillRect(275, 50, 450, 500);

        // menu varies depending on GameStates
        // new game menu - only visible when first starting the game
        if (GameNew) {
            GameText("PACMAN", 300, 170, Color.YELLOW, 90, g);
            GameText("High Score: " + Integer.toString(score), 290, 260, textColor, 40, g); // add high score
        }

        // paused game menu
        if (GamePaused) {
            GameText("Score: " + Integer.toString(score), 300, 120, textColor, 60, g);
            GameText("High Score: " + Integer.toString(score), 300, 180, textColor, 30, g); // add high score variable
            g.setColor(Color.YELLOW);
            g.fillRect(400, 210, 200, 90);
            GameText("Resume Game", 405, 250, pacmanBlue, 28, g);
            GameText("Press Space", 430, 280, pacmanBlue, 24, g);
        }
        // game over menu
        if (GameOver) {
            GameText("Game Over!", 300, 130, Color.YELLOW, 70, g);
            GameText("Your Score: " + Integer.toString(score), 290, 200, textColor, 40, g);
            GameText("High Score: " + Integer.toString(score), 290, 270, textColor, 40, g);
        }

        g.setColor(Color.YELLOW);
        g.fillRect(400, 320, 200, 90);
        g.fillRect(400, 430, 200, 90);
        GameText("New Game", 420, 365, pacmanBlue, 30, g);
        GameText("Press Enter", 430, 400, pacmanBlue, 24, g);
        GameText("Exit Game", 420, 470, pacmanBlue, 30, g);
        GameText("Press 0", 450, 500, pacmanBlue, 24, g);
    }

    // Game States (self-explanatory)
    public void newGame() {
        Reset();
        GameNew = false;
        GameOver = false;
        GameRunning = true;
        GamePaused = false;
        InMenu = false;
    }

    public void pauseGame() {
        GameRunning = false;
        GamePaused = true;
        InMenu = true;
    }

    public void resumeGame() {
        GameRunning = true;
        GamePaused = false;
        InMenu = false;
    }

    public void endGame() {
        GameOver = true;
        GameRunning = false;
    }

    public void exit() {
        System.exit(0);
    }

    // Game logic
    // Checking for collisions between game componenets
    public void checkCollisions() {
        // creates a rectangle around player, ghosts and points
        Rectangle playerBox = player.getBounds();

        Rectangle[] ghostsBox = new Rectangle[ghosts.length];
        for (int i = 0; i < ghostsBox.length; i++) {
            ghostsBox[i] = ghosts[i].getBounds();
        }

        Rectangle[] pointsBox = new Rectangle[pointList.length];
        for (int i = 0; i < pointsBox.length; i++) {
            pointsBox[i] = pointList[i].getBounds();
        }

        // checks if pacman collides with ghost
        for (int i = 0; i < ghostsBox.length; i++) {
            if (playerBox.intersects(ghostsBox[i])) {
                // if they collide, loses a life and may end the game
                loseLife();
                player.resetPosition();
                isGameOver();
            }
        }

        // checks if pacman eats a point
        for (int i = 0; i < pointsBox.length; i++) {
            // if point exists, pacman eats the point and score increases
            if (playerBox.intersects(pointsBox[i])) {
                if (!pointList[i].isEaten()) {
                    pointList[i].eaten();
                    score += pointList[i].scored();
                }
            }
        }
    }

    // decreases lives by 1
    public void loseLife() {
        if (lives > 0) {
            lives--;
        }
    }

    // Checks if lives is below 1
    public void isGameOver() {
        if (lives < 1) {
            endGame();
        }
    }

    // creates a projection of the player after moving horizontally
    // checks if the projection goes through a wall
    // returns boolean "inBounds" (true if inside maze, false if clipping through a
    // wall)
    public boolean inMazeX() {
        boolean inBoundsX = true;
        Rectangle projectionBox = player.getProjectionX();
        for (int i = 0; i < gridList.length; i++) {
            for (int j = 0; j < gridList[i].length; j++) {
                if (gridList[i][j].checkWall()) {
                    Rectangle gridBox = gridList[i][j].getBounds();
                    if (projectionBox.intersects(gridBox)) {
                        inBoundsX = false;
                    }
                }
            }
        }
        return inBoundsX;
    }

    // same function as inMazeX() except for the vertical direction
    public boolean inMazeY() {
        boolean inBoundsY = true;
        Rectangle projectionBox = player.getProjectionY();
        for (int i = 0; i < gridList.length; i++) {
            for (int j = 0; j < gridList[i].length; j++) {
                if (gridList[i][j].checkWall()) {
                    Rectangle gridBox = gridList[i][j].getBounds();
                    if (projectionBox.intersects(gridBox)) {
                        inBoundsY = false;
                    }
                }
            }
        }
        return inBoundsY;
    }

    // Event Listeners
    // Takes action event from timer to animate game
    public void actionPerformed(ActionEvent e) {
        if (GameRunning) {
            GameCycle();
        }

        // ensures menu is painted
        if (!GameRunning) {
            repaint();
        }
    }

    // key events, controlled by the player
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        // changing game states
        if (keyCode == KeyEvent.VK_ENTER && !GameRunning) {
            newGame();
        }
        if (keyCode == KeyEvent.VK_ESCAPE && GameRunning) {
            pauseGame();
        }
        if (keyCode == KeyEvent.VK_SPACE && (!GameRunning && (!GameOver && !GameNew))) {
            resumeGame();
        }
        if (keyCode == KeyEvent.VK_0) {
            exit();
        }

        // moving Pacman
        // 1 is up, 2 is right, 3 is down, 4 is left
        if (keyCode == KeyEvent.VK_UP && GameRunning) {
            player.setSpeed(1);
        }
        if (keyCode == KeyEvent.VK_RIGHT && GameRunning) {
            player.setSpeed(2);
        }
        if (keyCode == KeyEvent.VK_DOWN && GameRunning) {
            player.setSpeed(3);
        }
        if (keyCode == KeyEvent.VK_LEFT && GameRunning) {
            player.setSpeed(4);
        }
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // 0 resets speedX, 10 resets speedY
        if (keyCode == KeyEvent.VK_UP && GameRunning) {
            player.setSpeed(10);
        }
        if (keyCode == KeyEvent.VK_RIGHT && GameRunning) {
            player.setSpeed(0);
        }
        if (keyCode == KeyEvent.VK_DOWN && GameRunning) {
            player.setSpeed(10);
        }
        if (keyCode == KeyEvent.VK_LEFT && GameRunning) {
            player.setSpeed(0);
        }
    }

    public void keyTyped(KeyEvent e) {

    }

}
