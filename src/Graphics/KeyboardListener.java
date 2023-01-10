package Graphics;

import GameLogic.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    Game game;

    public KeyboardListener(Game game){
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        game.movePlayer(e.getKeyCode(),30);
    }
}
