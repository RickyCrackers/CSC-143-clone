package snakebyte;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/************************************************************************
 * Update this class to complete the snake game.
 * FIXME: update methods to allow use of food, and snake to be animated.
 *        This class uses functional methods for the timer and
 *        creating a new game.
 * TODO: check for snake collision with the food.
 *       If there is a collision, then move to a new random location,
 *       increase the score by one and grow the snake by one square.
 * CLASS DESCRIPTION
 * This class is the key event controller for the snake game.
 * Holds the keyboard control operations for game.
 ************************************************************************/
public class KeyController implements KeyListener, ChangeListener {

    public static final int DELAY = 100;

    protected Color     bottomColor;
    protected JPanel    bottomPanel;
    protected int       delay;
    protected Food      food;
    protected boolean   gameOver;
    private   boolean   gamePaused;
    protected int       initSpeed;
    private   int       score;
    protected Snake     snake;
    protected Timer     timer;
    protected JSlider   speedSlider;
    protected GamePanel gamePanel;


    public KeyController() {
        bottomColor = Color.LIGHT_GRAY;
        delay       = DELAY;
        gameOver    = false;
        gamePaused  = false;
        timer 	    = new Timer(delay, this::animate);      // sets timer to animate game
        snake       = new Snake();
        food        = new Food();
        score       = 0;

        timer.start();
        timer.setCoalesce(true);

        //create slider that enables users to increase/decrease speed
        int minSpeed = 1;
        int maxSpeed = 5;
        initSpeed = 3;

        speedSlider = new JSlider(JSlider.HORIZONTAL, minSpeed, maxSpeed, initSpeed);
        speedSlider.setMinorTickSpacing(1);
        speedSlider.setMajorTickSpacing(1);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.addChangeListener(this);

        bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.setBackground(bottomColor);
        bottomPanel.add(speedSlider, BorderLayout.CENTER);

    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    //TODO: (1) use "repaint" method from GamePanel

    //TODO: (2)check for collisions,
    //      a. with playing area boundaries,
    //      b. with snake and food
    //      c. with snake self collisions
    //TODO: (3) check if game is over and display "game over" graphics
    //      in playing area, keep snake moving.
    private void animate(ActionEvent event) {
        snake.move();
        checkBoundaryCollision();
        checkSnakeFoodCollision();
        checkSnakeSelfCollision();
        if (gamePanel != null) {
            gamePanel.repaint();
        }
    }

    //TODO: This method checks for snake collisions on game panel borders
    private void checkBoundaryCollision() {
        if (snake.getX() < 0 || snake.getX() > GamePanel.WIDTH - Snake.SQUARE || snake.getY() < 0 || snake.getY() > GamePanel.HEIGHT - Snake.SQUARE) {
            endGame();
        }
    }

    //TODO: check for snake collision with the food.
    //      If there is a collision with food, score is increased by one,
    //      and food updated to a new random location, snake body also
    //      increases by one square.
    private void checkSnakeFoodCollision() {
        if (snake.getX() == food.getX() && snake.getY() == food.getY()) {
            score++;
            food.setLocation();
            snake.grow();
        }

    }

    //TODO: check if the snake body overlaps with another portion
    //      of its' body, i.e., two body locations are in the same spot
    //      ends game if it does.
    //      This method checks if the snake collided with itself.
    private void checkSnakeSelfCollision() {
        for (int i = 1; i < snake.getBody().size(); i++) {
            Point point = snake.getBody().get(i);
            if (snake.getX() == point.getX() && snake.getY() == point.getY()) {
                endGame();
            }

        }

    }

    // TODO: This method create a new game, use SHIFT key to generate
    //       a new game in detectKeyPress
    private void createNewGame() {
        SwingUtilities.invokeLater(Viewer::new);
    }

    //TODO: Use "switch expression" to create the actions for
    //      snake movements UP, DOWN, LEFT, RIGHT, PAUSE
    //      Snake cannot "run over" its body, this will end game.
    //TODO: (1) Use SPACE key to pause snake game!
    //TODO: (2) Use SHIFT key to generate a new game
    //TODO: (3) stop timer if game paused, restart timer after pause.
    //TODO: (4) repaint game
    private void detectKeyPress(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP -> {
                if (snake.direction != Direction.DOWN) {
                    turnUp();
                }
            }
            case KeyEvent.VK_DOWN -> {
                if (snake.direction != Direction.UP) {
                    turnDown();
                }
            }
            case KeyEvent.VK_LEFT -> {
                if (snake.direction != Direction.RIGHT) {
                    turnLeft();
                }
            }
            case KeyEvent.VK_RIGHT -> {
                if (snake.direction != Direction.LEFT) {
                    turnRight();
                }
            }
        }
    }

    //TODO: (1) snake head starts/points to the RIGHT, don't want to reverse back
    //          unto itself, should only move UP, DOWN, RIGHT.
    //TODO: (2) repaint game
    private void detectStartKey(int keyCode){
        switch (keyCode) {
            case KeyEvent.VK_UP -> {
                turnUp();
                snake.setMoving(true);
            }
            case KeyEvent.VK_DOWN -> {
                turnDown();
                snake.setMoving(true);
            }
            case KeyEvent.VK_RIGHT -> {
                turnRight();
                snake.setMoving(true);
            }
        }
    }

    //TODO: End Game Operations
    private void endGame(){
        gameOver = true;
        timer.stop();
    }

    //TODO: Get Score
    public int getScore() {
        return score;
    }

    //TODO: (1) update key presses for starting game
    //      (2) continuously check for keyboard press signals
    public void keyPressed(KeyEvent signal) {
        int keyCode = signal.getKeyCode();

        if (keyCode == KeyEvent.VK_SHIFT) {
            createNewGame();
            return;
        }

        if (keyCode == KeyEvent.VK_SPACE) {
            if (!gameOver) {
                toggleGamePause();
            }
            return;
        }

        if (gamePaused || gameOver) {
            return;
        }

        if (!snake.isMoving) {
            detectStartKey(keyCode);
        } else {
            detectKeyPress(keyCode);
        }
    }

    //These key detection responses, currently NOT USED.
    public void keyReleased(KeyEvent signal) {}
    public void keyTyped(KeyEvent signal) {}

    //TODO: This method is called as slider value changes.
    //      Updates the speed of the snake.
    //      Look at how you can change increase or decrease the speed using timer.
    //      A possible option is to use setDelay in timer.
    @Override
    public void stateChanged(ChangeEvent event) {
        JSlider slider      = (JSlider) event.getSource();
        int     value       = slider.getValue();        // slider value (int)

        //FIXME: Here is a possible option to FIX to change speed
        if(!gameOver){
            delay = DELAY / value;
            timer.setDelay(delay);
            System.out.println("delay: " + delay);
        }

    }

    //TODO: Helper methods for key presses

    //TODO: used for key press operations change snake direction down
    private void turnDown() {
        snake.direction = Direction.DOWN;

    }

    //TODO: used for key press operations change snake direction left
    private void turnLeft() {
        snake.direction = Direction.LEFT;

    }

    //TODO: used for key press operations change snake direction right
    private void turnRight() {
        snake.direction = Direction.RIGHT;

    }

    //TODO: used for key press operations change snake direction up
    private void turnUp() {
        snake.direction = Direction.UP;

    }

    //TODO: used for key press operations
    //      pause and restart game
    private void toggleGamePause() {
        if (gameOver) {
            return;
        }

        gamePaused = !gamePaused;
        if(gamePaused){
            timer.stop();
        } else {
            timer.start();
        }

    }

}
