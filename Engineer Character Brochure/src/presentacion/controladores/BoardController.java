/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import logic.command.Move;
import presentacion.vistas.game.BoardView;

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
        Move movements = gameBoard.getMyGame().getMovements();
        
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                gameBoard.getMyGame().getRobot().moveUp();
                gameBoard.getLienzo().repaint();
                break;

            case KeyEvent.VK_DOWN:
                gameBoard.getMyGame().getRobot().moveDown();
                gameBoard.getLienzo().repaint();
                break;

            case KeyEvent.VK_LEFT:
                movements.moveLeft();
                gameBoard.getLienzo().repaint();
                break;

            case KeyEvent.VK_RIGHT:
                movements.moveRight();
                gameBoard.getLienzo().repaint();
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
