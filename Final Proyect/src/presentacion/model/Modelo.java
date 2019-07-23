/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.model;

import logic.Robot;
import logic.command.Move;
import logic.command.MoveDownCommand;
import logic.command.MoveLeftCommand;
import logic.command.MoveRightCommand;
import logic.command.MoveUpCommand;
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
    private MoveUpCommand moveUp;
    private MoveDownCommand moveDown;

    private Move movements;

    private BoardView gameBoard;

    /*private*/
    public Modelo() {
        robot = Robot.getRobot();

        moveRight = new MoveRightCommand(robot);
        moveLeft = new MoveLeftCommand(robot);
        moveUp = new MoveUpCommand(robot);
        moveDown = new MoveDownCommand(robot);

        movements = new Move(moveUp, moveDown, moveRight, moveLeft);
        movements.setMyGame(this);

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
