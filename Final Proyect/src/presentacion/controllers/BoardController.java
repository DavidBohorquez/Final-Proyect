/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import presentacion.views.BoardView;
import presentacion.views.TestCanvas;



/**
 *
 * @author Andre Sarmiento
 */
public class BoardController implements KeyListener {

    private BoardView gameBoard;
    private TestCanvas test;


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
                test.ia=4;
                gameBoard.getRobot().moveUp();
                gameBoard.getLienzo().repaint();
                System.out.println("arriba");
                break;

            case KeyEvent.VK_DOWN:
                
                gameBoard.getRobot().moveDown(gameBoard.getLienzo().getHeight());
                test.ia=4;
                gameBoard.getLienzo().repaint();
                System.out.println("abajo");
                break;

            case KeyEvent.VK_LEFT:
               
                test.ia=6;
                gameBoard.getRobot().moveLeft();
                gameBoard.getLienzo().repaint();
                System.out.println("izquierda");
                break;

            case KeyEvent.VK_RIGHT:
                test.ia=2;
                gameBoard.getRobot().moveRight(gameBoard.getLienzo().getWidth());
                gameBoard.getLienzo().repaint();
                System.out.println("derecha");

                break;

            case KeyEvent.VK_SPACE:
                test.ia=8;
                gameBoard.getLienzo().repaint();
                System.out.println("golpe");
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                test.ia=1;
                gameBoard.getLienzo().repaint();
                break;

            case KeyEvent.VK_DOWN:
                test.ia=1;
                gameBoard.getLienzo().repaint();
                break;

            case KeyEvent.VK_LEFT:
                test.ia=1;
                gameBoard.getLienzo().repaint();
                break;

            case KeyEvent.VK_RIGHT:
                test.ia=1;
                gameBoard.getLienzo().repaint();
                break;

            case KeyEvent.VK_SPACE:
                test.ia=1;
                gameBoard.getLienzo().repaint();
                break;

        }
    }
}
