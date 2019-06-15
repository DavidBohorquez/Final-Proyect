/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controllers;

import presentacion.views.BoardView;

/**
 *
 * @author estudiantes
 */
public class BoardController {

    private BoardView gameBoard;

    public BoardController(BoardView aThis) {
        gameBoard = aThis;
    }

    public BoardView getGameBoard() {
        return gameBoard;
    }

}
