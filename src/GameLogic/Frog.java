package GameLogic;

import java.awt.*;

/**
 * This class represents a frog that the player controls in the game.
 * Objects from the frog's class will also keep track of their name and current position.
 * This class can also calculate distance between frog and given point, move frog, represent frog in Rectangle and print frog's information.
 *
 */

public class Frog {

    //Initialize instance variables for Frog.
    private String name;
    private Point currentPosition;

    /**
     * Creates a new frog object given a name and starting position.
     * @param name the name of the Frog.
     * @param startPoint the start point for frog.
     */
    public Frog(String name, Point startPoint) {
        this.name = name;
        currentPosition = startPoint;
    }

    /**
     * Creates a new frog object given a name and at position (0,0)
     * @param name the name of the Frog.
     */
    public Frog(String name) {
        this(name, new Point(0,0));
    }

    /**
     * Return current position of Frog.
     * @return A Point object implies the current position of the Frog.
     */
    public Point getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Return name of Frog.
     * @return A string implies the name of the Frog.
     */
    public String getName() {
        return name;
    }

    /**
     * Translates the frog given an x and y translations.
     * @param x Distance moved in x coordinate
     * @param y Distance moved in y coordinate
     * @return A Point object implies the new position of the Frog.
     */
    public Point move(int x, int y) {
        currentPosition.setLocation(currentPosition.getX() + x, currentPosition.getY() + y);
        return currentPosition;
    }

    /**
     * Computes the distance between the frog object and the point received as an argument.
     * @param point the point received as an argument.
     * @return A double number implies the distance between the frog object and given point.
     */
    public double distanceFromPoint(Point point) {
        return point.distance(currentPosition);
    }

    /**
     * Returns the bounds of the car object which can be used to detect collision
     * @return A Rectangle object defining the bounds of the frog
     */
    public Rectangle getCollisionBounds(){
        return new Rectangle(currentPosition.x,currentPosition.y,30,30);
    }

    /**
     * Print a string representation of the frog‘s information.
     * @return A string show frog's information in particular format.
     */
    public String toString() {
        return String.format("The frog named %s is at (%d,%d)", name, (int)currentPosition.getX(), (int)currentPosition.getY());
    }
}