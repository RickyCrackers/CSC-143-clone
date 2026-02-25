package snakebyte;

/********************************************************************
 * Update it to complete the snake game.
 * TODO: create UP, DOWN, LEFT, RIGHT directions for snake movement.
 * CLASS DESCRIPTION
 * This is an enumerated class that stores the direction of travel
 * for the snake graphics. The UP, DOWN, LEFT, RIGHT directions are
 * in coordinate unit direction.
 ********************************************************************/
public enum Direction {
    //TODO: Add enumerations UP, DOWN, LEFT, RIGHT
    UP(0,-1), DOWN(0,1), LEFT(-1,0), RIGHT(1,0);

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }






}
