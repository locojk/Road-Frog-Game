package Graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Runner class for the Road Frog game.
 *
 */
public class GameRunner extends JPanel {

    private GameGraphics chickenGame;
    private static final Point START_POSITION = new Point(300,500);

    public static void main(String[] args) throws InterruptedException {

        JFrame gameFrame = new JFrame("The Road Frog Game");
        GameGraphics runner = new GameGraphics();
        gameFrame.add(runner);
        gameFrame.setSize(600,600);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runner.graphicsGameLoop(gameFrame);

    }

}
