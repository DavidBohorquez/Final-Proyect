/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.model;

import presentacion.views.BoardView;

/**
 *
 * @author estudiantes
 */
public class Modelo {

    private BoardView gameBoard;

    public Modelo() {
        getBoardGame();
    }

    public void initGame() {
        getBoardGame().setVisible(true);
    }

    public BoardView getBoardGame() {
        if (gameBoard == null) {
            gameBoard = new BoardView(this);
        }
        return gameBoard;
    }

}
