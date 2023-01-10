package Graphics;

import GameLogic.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    Game chickenGame;

    public KeyboardListener(Game chickenGame){
        this.chickenGame = chickenGame;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        chickenGame.movePlayer(e.getKeyCode(),30);
    }
}
