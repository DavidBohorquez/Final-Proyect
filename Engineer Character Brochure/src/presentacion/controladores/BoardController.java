/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import logic.Operation;
import logic.command.Move;
import presentacion.vistas.game.BoardView;
import presentacion.vistas.game.TestCanvas;

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
        TestCanvas lienzo = gameBoard.getLienzo();
        Operation operation = gameBoard.getMyGame().getOperation();

        if (operation.isActive() != true) {
            operation.start();
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                movements.moveUp();
                lienzo.repaint();
                break;

            case KeyEvent.VK_DOWN:
                System.out.println("POSY: " + gameBoard.getMyGame().getRobot().getPosY());
                gameBoard.getMyGame().getRobot().moveDown();
                lienzo.repaint();
                break;

            case KeyEvent.VK_LEFT:
                movements.moveLeft();
                lienzo.repaint();
                break;

            case KeyEvent.VK_RIGHT:
                movements.moveRight();
                lienzo.repaint();
                break;

            case KeyEvent.VK_SPACE:

                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        TestCanvas lienzo = gameBoard.getLienzo();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:

                break;

            case KeyEvent.VK_DOWN:

                break;

            case KeyEvent.VK_LEFT:
                lienzo.setCharacter(lienzo.getChLeftQuiet());
                lienzo.repaint();
                break;

            case KeyEvent.VK_RIGHT:
                lienzo.setCharacter(lienzo.getChRightQuiet());
                lienzo.repaint();
                break;

            case KeyEvent.VK_SPACE:
                break;

        }
    }
}
