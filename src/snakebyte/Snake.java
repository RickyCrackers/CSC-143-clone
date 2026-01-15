package snakebyte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import utils.List;
import utils.ArrayList;

/******************************************************************
 * This class is used in your GitHub Snake Game Project.
 * FIXME: Update this class to create a snake object.
 * CLASS DESCRIPTION
 * This class uses an ArrayList to draw the snake body graphics
 * on the game panel.
 ******************************************************************/
public class Snake {

    public static final int  SQUARE           = 10;
    public static final int  STARTING_LENGTH  = 10;
    public static final int  START_X_LOCATION = GamePanel.WIDTH  / 2;
    public static final int  START_Y_LOCATION = GamePanel.HEIGHT / 2;

    protected Color       bodyColor;
    protected Direction   direction;
    protected boolean     isMoving;
    protected List<Point> snakeBody;

    public Snake() {
        bodyColor   = Color.WHITE;
        //direction   = Direction.RIGHT;
        isMoving    = false;
        snakeBody   = make();
    }

    public void draw(Graphics snakeGraphics) {
        Graphics2D pen = (Graphics2D) snakeGraphics;
        pen.setColor(bodyColor);
        double xLocation, yLocation;
        double arcSize = SQUARE / 4.0;

        // draw the snake body at given location
        //TODO: "Un-Comment" when Snake and Point classes are completed
//        for (int i = 0; i < snakeBody.size(); i++) {
//            Point point = snakeBody.get(i);
//            xLocation = point.getX();
//            yLocation = point.getY();
//
//            RoundRectangle2D body = new RoundRectangle2D.Double();
//            body.setRoundRect(xLocation, yLocation, SQUARE, SQUARE, arcSize, arcSize);
//
//            // Each additional growth is MAGENTA
//            if(i == 0){
//                pen.setColor(Color.CYAN);
//            } else{
//                if (i >= STARTING_LENGTH) {
//                    pen.setColor(Color.MAGENTA);
//                } else {
//                    pen.setColor(bodyColor);
//                }
//            }
//            pen.draw(body);
//
//        }

    }

    //TODO: return all points in the snake point
    public List<Point> getBody() {
        return null;
    }

    //TODO: return the snake head (x, y) location
    public Point getHeadLocation() {
        return null;
    }

    //TODO: return the snake tail (x, y) location
    public Point getTailLocation() {
        return null;
    }

    //FIXME: return the current snake head x location.
    public double getX() {
        return 0.0;
    }

    //FIXME: return the current snake head y location.
    public double getY() {
        return 0.0;
    }

    //FIXME: add a new SQUARE to the tail end of the snake body.
    public void grow() {

    }

    //FIXME: create an ArrayList of points to make the snake body
    //FIXME: add starting point (front of snake) to the array list
    //FIXME: add each additional point to create the horizontal snake body (use loop)
    //FIXME: return the starting snake body
    // NOTES: Snake points TO RIGHT -> START_X_LOCATION - (i * SQUARE), START_Y_LOCATION)
    //        Snake points TO LEFT  -> START_X_LOCATION + (i * SQUARE), START_Y_LOCATION)
    private List<Point> make() {

        List<Point> body = new ArrayList<>();

        return body;
    }


    //FIXME: update the condition for the snake to move.
    //FIXME: update the head location of snake body
    //FIXME: make new snake head (x, y) location of snakeBody
    //FIXME: update the snake body locations
    //       add SQUARE as new head at front location and "shift right"
    //       body SQUARES, then remove SQUARE at end to update location
    // ----------------------------------------------------------------
    // newX = head.getX() + direction.getX() * SQUARE;
    // newY = head.getY() + direction.getY() * SQUARE;
    public void move() {

    }

    //TODO: Use this method to test and set snake moving
    public void setMoving(boolean isMoving) {

    }

}
