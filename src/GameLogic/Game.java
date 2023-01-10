package GameLogic;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * This class models the overall logic of the game.
 * Objects from the game's class will also keep track of the player as Frog object, and 4 Car object.
 * This class can also move player, cars and determine if player be hit by car and if the player win.
 *
 */

public class Game{

    //Initialize instance variables for Game.
    private Frog player;
    private ArrayList<Car> cars;

    //Define the win coordinate which is 20 and if frog arrive it then player win.
    public static final int winCoordinate = 20;

    /**
     * Creates a new Road Frog game.
     * @param name player's name
     * @param startPoint player's start point.
     */
    public Game(String name, Point startPoint) {

        //Initialize player as Frog object and cars arraylist.
        player = new Frog(name, startPoint);
        cars = new ArrayList<>();

        //Add first car to array list cars.
        Point p1 = new Point(100,400);
        Car car1 = new Car(p1,Color.black,10,120,75,false);
        cars.add(car1);

        //Add second car to array list cars.
        Point p2 = new Point(0,300);
        Car car2 = new Car(p2,Color.blue,30,200,75,false);
        cars.add(car2);

        //Add third car to array list cars.
        Point p3 = new Point(100,150);
        Car car3 = new Car(p3,Color.black,10,120,75,true);
        cars.add(car3);

        //Add last car to array list cars.
        Point p4 = new Point(0,80);
        Car car4 = new Car(p4,Color.black,20,120,75,true);
        cars.add(car4);
    }

    /**
     * Return a Frog object controlled by player in game.
     * @return A Frog object implies the player in game.
     */
    public Frog getPlayer() {
        return player;
    }

    /**
     * Return an array list of car objects.
     * @return An array list implies a group of car objects.
     */
    public ArrayList<Car> getCars() {
        return cars;
    }

    /**
     * Responds to keyboard events by moving the player in the x or y direction.
     * @param code Represents keys from the keyboard.
     * @param step Represents the step (in pixels) of how much the player is going to move at each keypress.
     */
    public void movePlayer(int code, int step) {

        //If press up key, move up along Y coordinate.
        if (code == KeyEvent.VK_UP) {
            player.move(0, -1*step);
        }

        //If press down key, move down along Y coordinate.
        if (code == KeyEvent.VK_DOWN) {
            player.move(0, step);
        }

        //If press left key, move left along Y coordinate.
        if (code == KeyEvent.VK_LEFT) {
            player.move(-1*step, 0);
        }

        //If press right key, move right along Y coordinate.
        if (code == KeyEvent.VK_RIGHT) {
            player.move(step, 0);
        }
    }

    /**
     *  Moves every car in the game by calling their move method and reset position when a car hit edge or 0 coordinate.
     * @param edge Representing the edge of the game area.
     */
    public void moveCars(int edge) {

        for (Car element : cars) {
            //Move car element by calling move method in Car.
            element.move();

            //If car move from left to right, set car to zero if arrive the edge.
            if (!element.isMoveLeft() && element.getCurrentPosition().getX() >= edge) {
                element.getCurrentPosition().setLocation(0, element.getCurrentPosition().getY());
            }

            //If car move from right to left, set car to edge if arrive the zero coordinate.
            if (element.isMoveLeft() && element.getCurrentPosition().getX() <= 0) {
                element.getCurrentPosition().setLocation(edge, element.getCurrentPosition().getY());
            }
        }
    }

    /**
     * Determine if the player hit by a car.
     * @return A boolean value, true if the player was hit by a car.
     */
    public boolean isPlayerHit() {
        for (Car element : cars) {
            if (element.getCollisionBounds().contains(player.getCollisionBounds())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determine if the player win the game.
     * @return A boolean value, true if the player won the game.
     */
    public boolean hasPlayerWon() {
        return player.getCurrentPosition().getY() < winCoordinate;
    }

}