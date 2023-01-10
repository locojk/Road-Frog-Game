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

    /**
     * Can restart game and start game at first time
     * Creates a new graphics element of the Road Frag Game
     * It will add four cars, two in each direction and register the keyboard listener
     */
    public GameGraphics() {
        resetGame();
    }

    /**
     * Game loop method used to move the cars, check if the player is dead/alive and if the win condition
     * @param gameFrame the JFrame window
     * @throws InterruptedException if the update time is interrupted for some reason
     */
    public void startGameLoop(JFrame gameFrame) throws InterruptedException {

        boolean playerHit;
        boolean playerWon;

        while (true) {
            roadFrogGame.moveCars(600);
            gameFrame.repaint();
            playerHit = roadFrogGame.isPlayerHit();
            playerWon = roadFrogGame.hasPlayerWon();
            if (playerHit || playerWon) {
                break;
            }
            Thread.sleep(100);
        }

        String message;
        if (playerHit) {
            message = "Smells like fried frog. Play again?";
            int result = JOptionPane.showConfirmDialog(this, message, "you got hit!", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                resetGame();
                startGameLoop(gameFrame);
            } else {
                System.exit(0);
            }
        } else {
            message = "No fried frog today. Play again?";
            int result = JOptionPane.showConfirmDialog(this, message, "Safe!", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                resetGame();
                startGameLoop(gameFrame);
            } else {
                System.exit(0);
            }
        }
    }

    /**
     * Can restart game and start game at first time
     * Creates a new graphics element of the Road Frag Game
     * It will add four cars, two in each direction and register the keyboard listener
     */
    private void resetGame() {
        roadFrogGame = new Game("Hui", new Point(300, 500));
        KeyboardListener kbListener = new KeyboardListener(roadFrogGame);
        addKeyListener(kbListener);
        setFocusable(true);
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
