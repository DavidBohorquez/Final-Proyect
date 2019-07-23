/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.model;

import logic.Robot;
import logic.command.Move;
import logic.command.MoveLeftCommand;
import logic.command.MoveRightCommand;
import presentacion.views.BoardView;

/**
 *
 * @author estudiantes
 */
public class Modelo {

    //private static Modelo myGame;
    private Robot robot;

    private MoveRightCommand moveRight;
    private MoveLeftCommand moveLeft;

    private Move movements;

    private BoardView gameBoard;

    /*private*/
    public Modelo() {
        robot = Robot.getRobot();

        moveRight = new MoveRightCommand(robot, this);
        moveLeft = new MoveLeftCommand(robot, this);

        movements = new Move(moveRight, moveLeft);

        gameBoard = getBoardGame();
    }

    public void initGame() {
        getBoardGame().setVisible(true);
    }

    public Robot getRobot() {
        return robot;
    }

    public BoardView getBoardGame() {
        if (gameBoard == null) {
            gameBoard = new BoardView(this);
        }
        return gameBoard;
    }

    /*public static Modelo getMyGame() {
     if (myGame == null) {
     myGame = new Modelo();
     }
     return myGame;
     }*/
    public Move getMovements() {
        return movements;
    }

}
