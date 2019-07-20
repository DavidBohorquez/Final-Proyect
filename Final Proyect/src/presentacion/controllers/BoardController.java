/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import presentacion.views.BoardView;

/**
 *
 * @author Andre Sarmiento
 */
public class BoardController implements KeyListener {

    private BoardView gameBoard;

    public BoardController(BoardView aThis) {
        gameBoard = aThis;
    }

    public BoardView getGameBoard() {
        return gameBoard;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                gameBoard.getRobot().moveUp();
                gameBoard.getLienzo().repaint();
                break;

            case KeyEvent.VK_DOWN:
                gameBoard.getRobot().moveDown(gameBoard.getLienzo().getHeight());
                gameBoard.getLienzo().repaint();
                break;

            case KeyEvent.VK_LEFT:

                break;

            case KeyEvent.VK_RIGHT:

                break;

            case KeyEvent.VK_SPACE:

                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:

                break;

            case KeyEvent.VK_DOWN:

                break;

            case KeyEvent.VK_LEFT:

                break;

            case KeyEvent.VK_RIGHT:

                break;

            case KeyEvent.VK_SPACE:
                break;

        }
    }
}
