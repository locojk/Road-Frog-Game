package Graphics;

import javax.swing.*;

/**
 * Runner class for the Road Frog game.
 *
 */
public class GameRunner extends JPanel {

    public static void main(String[] args) throws InterruptedException {

        JFrame gameFrame = new JFrame("The Road Frog Game");
        GameGraphics runner = new GameGraphics();
        gameFrame.add(runner);
        gameFrame.setSize(600,650);
        gameFrame.setResizable(false);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runner.startGameLoop(gameFrame);
    }

}
