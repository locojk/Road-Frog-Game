package GameLogic;

import java.awt.*;

/**
 * This class represents the car in the game.
 * Objects from the car's class will also keep track of their current position, color, move speed,size, move direction and the rectangle represent the car.
 * This class can also move car according to move speed.
 *
 */

public class Car{

    //Initialize instance variables for Car.
    private Point currentPosition;
    private Color bodyColour;
    private int movementSpeed;
    private int xSize;
    private int ySize;
    private  boolean moveLeft;

    /**
     * Creates a new Car object.
     * @param startPoint the start point of the car.
     * @param color the color of the car
     * @param movementSpeed how fast (in pixels) the cars move.
     * @param xSize the size of the car (in pixels) in the x direction.
     * @param ySize the size of the car in the y direction.
     * @param moveLeft determine whether cars move from right to left.
     */
    public Car(Point startPoint, Color color, int movementSpeed, int xSize, int ySize, boolean moveLeft) {
        currentPosition = startPoint;
        bodyColour = color;
        this.movementSpeed = movementSpeed;
        this.xSize = xSize;
        this.ySize = ySize;
        this.moveLeft = moveLeft;
    }

    /**
     * Return the current position of the Car object.
     * @return A Point object implies the current position of the Car object.
     */
    public Point getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Return the color of the Car object.
     * @return The Color object implies the color of the Car object.
     */
    public Color getBodyColour() {
        return bodyColour;
    }

    /**
     * Return the size of the car in the x direction of the Car object.
     * @return AN integer implies the size of the car in the x direction of the Car object.
     */
    public int getXSize() {
        return xSize;
    }

    /**
     * Return the size of the car in the y direction of the Car object.
     * @return AN integer implies the size of the car in the y direction of the Car object.
     */
    public int getYSize() {
        return ySize;
    }

    /**
     * Return the speed of the Car object.
     * @return An integer implies the speed of the Car object.
     */
    public int getMovementSpeed() {
        return movementSpeed;
    }

    /**
     * Return the move direction of the Car object.
     * @return A boolean value implies the move direction of the Car object, ture then move from right to left, false then reverse.
     */
    public boolean isMoveLeft() {
        return moveLeft;
    }

    /**
     * Moves the car in the X direction using movementSpeed as the step/value.
     */
    public void move() {
        if (moveLeft) {
            currentPosition.setLocation((int)currentPosition.getX() - movementSpeed,(int)currentPosition.getY());
        }
        else {
            currentPosition.setLocation((int)currentPosition.getX() + movementSpeed,(int)currentPosition.getY());
        }

    }

    /**
     * Returns the bounds of the car object which can be used to detect collision.
     * @return A Rectangle object defining the bounds of the car.
     */
    public Rectangle getCollisionBounds(){
        return new Rectangle(currentPosition.x, currentPosition.y,xSize,ySize);
    }
}

