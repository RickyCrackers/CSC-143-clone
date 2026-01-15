package snakebyte;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serial;
import javax.swing.JButton;
import javax.swing.JPanel;

/******************************************************************
 * This class is used in GitHub Snake Game Project.
 * FIXME: Update this class to display snake, food and game over
 *        Graphics.
 * CLASS DESCRIPTION
 * This class is used to display the food and snake graphics.
 * Most of the graphics operations such as draw, gameOver,
 * paintComponent and update have been already been implemented.
 ******************************************************************/
public class GamePanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 5L;
    public static final int HEIGHT = 600;
    public static final int WIDTH  = 600;

    protected Color bgColor ;
    protected Color fontColor;
    protected Color scoreColor;

    protected JButton gameButton;

    KeyController controller;
    Food    food;
    Snake   snake;


    public GamePanel(KeyController keyController) {
        bgColor     = Color.BLACK;
        fontColor   = Color.RED;

        scoreColor  = new Color(0, 150, 250);
        gameButton  = new JButton("New Game");

        controller  = keyController;
        snake       = controller.snake;
        food        = controller.food;

    }


    public void draw(Graphics gameGraphics){
        repaint();
        gameGraphics.setColor(bgColor);
        gameGraphics.fillRect(0, 0, WIDTH, HEIGHT);
        gameGraphics.setColor(scoreColor);
        gameGraphics.setFont( new Font("Helvetica", Font.BOLD, 20) );
        gameGraphics.drawString("Score : " + controller.getScore() , WIDTH / 20, HEIGHT / 20);
        snake.draw(gameGraphics);
        food.draw(gameGraphics);
    }

    private void printGameOver(Graphics gameGraphics){
        repaint();
        gameGraphics.setColor(fontColor);
        gameGraphics.setFont( new Font("Verdana", Font.BOLD, 60) );
        gameGraphics.drawString("Game Over", WIDTH / 4, HEIGHT / 2);
        gameGraphics.drawString("Score : " + controller.getScore() ,  WIDTH / 4, 2 * HEIGHT / 3);
    }

    // checks if game has ended and writes game over graphics.
    public void paintComponent(Graphics gameGraphics) {
        super.paintComponent(gameGraphics);
        draw(gameGraphics);
        if(controller.gameOver){
            printGameOver(gameGraphics);
        }
    }

    public void update(Graphics gameGraphics) {
        super.update(gameGraphics);
        paintComponent(gameGraphics);
    }

}
