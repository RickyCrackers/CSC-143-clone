package construction;

import java.util.Comparator;
import java.util.Objects;

/******************************************************************
 * These comments represent an example of JavaDoc Comments
 * in the way your instructor likes to write them.
 * DESCRIPTION
 * This class describes a rectangle representing a location (x, y) in
 * coordinate circles.ball.space, specified to double floating rectangle precision.
 ******************************************************************/

public class Rectangle implements Comparable<Rectangle> {
    double height;
    double width;

    public Rectangle(int width, int height) {
        this.height = height;
        this.width  = width;
    }

    /**
     * 	returns area of rectangle.
     * 	@return area value.
     **/
    public double area() {
        return width * height;
    }

    /**************************************************************
     * 	used to Compare Areas
     *  @param rec1 rectangle object.
     *  @param rec2 rectangle object.
     * 	@return result of comparison criteria.
     **************************************************************/
    public static int compareAreas(Rectangle rec1, Rectangle rec2) {
        return Comparator.comparing(Rectangle::area)
                         .thenComparing(Rectangle::width)
                         .thenComparing(Rectangle::height)
                         .thenComparing(Rectangle::perimeter)
                         .compare(rec1, rec2);
    }

    /**************************************************************
     * 	used to Compare Perimeters
     *  @param rec1 rectangle object.
     *  @param rec2 rectangle object.
     * 	@return result of comparison criteria.
     **************************************************************/
    public static int comparePerimeters(Rectangle rec1, Rectangle rec2) {
        return Comparator.comparing(Rectangle::perimeter)
                         .thenComparing(Rectangle::width)
                         .thenComparing(Rectangle::height)
                         .thenComparing(Rectangle::area)
                         .compare(rec1, rec2);
    }

    /**************************************************************
     * 	used to compare with another Rectangle
     *  @param other rectangle object.
     * 	@return result of comparison criteria.
     **************************************************************/
    public int compareTo(Rectangle other) {
        return Comparator.comparing(Rectangle::width)
                         .thenComparing(Rectangle::height)
                         .thenComparing(Rectangle::area)
                         .thenComparing(Rectangle::perimeter)
                         .compare(this, other);
    }


    /**
     * 	compares if a rectangle object is equals to current rectangle object.
     *  @param obj to be compared.
     * 	@return result of boolean evaluation.
     **/
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Rectangle other){
            return Objects.equals(this.width , other.width)   &&
                   Objects.equals(this.height, other.height);
        }
        return false;
    }

    /**
     * 	returns height of rectangle.
     * 	@return height value.
     **/
    public double height() {
        return height;
    }

    /**
     * 	returns perimeter of rectangle.
     * 	@return perimeter value.
     **/
    public double perimeter() {
        return 2 * width + 2 * height;
    }

    /**
     * 	returns width of rectangle.
     * 	@return width value.
     **/
    public double width() {
        return width;
    }

    /**
     * 	returns string representation of rectangle object.
     * 	@return [x, y] rectangle attributes as string.
     **/
    @Override
    public String toString() {
        return String.format("[%.0f, %.0f]", width, height);
    }

}
