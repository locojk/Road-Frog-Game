package Graphics;

import GameLogic.Car;
import GameLogic.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Graphics representation of the Road Frog Game.
 * Will create a new Game object, add the cars to the game and run the Graphics "engine" (JFrame)
 * Will create a keyboard listener object to handle keyboard type
 *
 */
public class GameGraphics extends JPanel {
    private Game roadFrogGame;
    private static final Point START_POSITION = new
            Point(300,500);

    /**
     * Creates a new graphics element of the Road Frag Game
     * It will add four cars, two in each direction and register the keyboard listener
     */
    public GameGraphics(){
        roadFrogGame = new Game("Hui", START_POSITION);

        KeyboardListener kbListener = new KeyboardListener(roadFrogGame);
        addKeyListener(kbListener);
        setFocusable(true);
    }

    /**
     * Game loop method used to move the cars, check if the player is dead/alive and if the win condition
     * @param gameFrame the JFrame window
     * @throws InterruptedException if the update time is interrupted for some reason
     */
    public void graphicsGameLoop(JFrame gameFrame) throws InterruptedException{
        boolean playerIsHit = false;
        boolean playerWon = false;

        while (!playerIsHit && !playerWon){
            roadFrogGame.moveCars(600);
            gameFrame.repaint();
            playerIsHit = roadFrogGame.isPlayerHit();
            playerWon = roadFrogGame.hasPlayerWon();
            Thread.sleep(50);
        }

        if (playerIsHit) {
            JOptionPane.showMessageDialog(this,"Smells like fried frog",
                    "you got hit!", JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(this,"No fried frog today",
                    "Safe!", JOptionPane.ERROR_MESSAGE);
        }

        System.exit(0);
    }

    /**
     * Overridden method used to paint the game elements to the screen.
     * This method is implicitly called when we call the repaint method on the JFrame object
     * @param graphics show the game window
     */
    @Override
    public void paint(Graphics graphics) {

        Graphics2D g2d = (Graphics2D) graphics;

        //Draw the "road median"
        g2d.setColor(Color.lightGray);
        g2d.fillRect(0,225,600,50);

        //Draw the "safe area"
        g2d.setColor(new Color(117,214,62));
        g2d.fillRect(0,0,600,50);

        //Draw the frog as a red circle
        g2d.setColor(Color.getColor("#006611"));
        g2d.fillOval(roadFrogGame.getPlayer().getCurrentPosition().x,
                roadFrogGame.getPlayer().getCurrentPosition().y,
                30, 30);

        //Draw each car using rectangles
        for (Car car: roadFrogGame.getCars()) {
            Point carPosition = car.getCurrentPosition();
            Color carColor = car.getBodyColour();
            g2d.setColor(carColor);
            g2d.fillRect(carPosition.x, carPosition.y, car.getXSize(), car.getYSize());
        }

    }
}
