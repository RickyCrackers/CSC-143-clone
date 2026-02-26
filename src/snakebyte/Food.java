package snakebyte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/******************************************************************
 * This class is a part of your GitHub Snake Game Project
 * FIXME: Update this class to set the location of food and
 *        check collisions with the snake object. The snake object
 *        grows longer with each food collision, i.e., eating the
 *        food.
 * CLASS DESCRIPTION
 * This class is used to draw the food graphics on the Game Panel.
 * The food location on the playing area is determined
 * through randomization. The food is represented by a square that
 * is 10 pixels x 10 pixels in size. Their color is lime green on
 * the black background.
 ******************************************************************/
public class Food {

    public static final int SIZE  = 10;
    private double          x, y;               //create random (x, y) location of food
    private final Color     foodColor;

    //TODO : set snake location on screen
    @SuppressWarnings("unused")
    public Food(Snake snake) {
        this.foodColor  = Color.GREEN;
        setLocation();
    }

    public void draw(Graphics foodGraphics) {
        Graphics2D 	pen 	= (Graphics2D) foodGraphics;
        Rectangle2D food    = new Rectangle2D.Double(x, y, SIZE, SIZE);

        pen.setColor(foodColor);     //set food color
        pen.fill(food);              //fill in food color in outlined food shape.
    }

    //TODO: create accessor for food x location
    public double getX() {
        return x;
    }

    //TODO: create accessor for food y location
    public double getY() {
        return y;
    }

    public void setLocation() {

        int slotsX = GamePanel.WIDTH / Food.SIZE;
        int slotsY = GamePanel.HEIGHT / Food.SIZE;

        int randomSlotX = (int) (Math.random() * slotsX);
        int randomSlotY = (int) (Math.random() * slotsY);

        x = randomSlotX * Food.SIZE;
        y = randomSlotY * Food.SIZE;
    }

}
