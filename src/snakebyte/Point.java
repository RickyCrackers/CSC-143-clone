package snakebyte;

/******************************************************************
 * Update it to complete the snake game.
 * TODO: Create getters and setters for
 *       double floating point precision Point.
 * CLASS DESCRIPTION
 * This Point class with floating point precision for
 * the snake graphics.
 ******************************************************************/
public class Point {

    //TODO: Create data field and constructor
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //TODO: Create getters and setters for Point
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }




}
