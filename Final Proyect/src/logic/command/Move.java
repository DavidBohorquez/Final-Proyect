/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.command;

import presentacion.model.Modelo;
import presentacion.views.TestCanvas;

/**
 *
 * @author Andre Sarmiento
 */
public class Move {

    private Modelo myGame;

    private Command upCommand, downCommand, rightCommand, leftCommand;

    public Move(Command up, Command down, Command right, Command left) {
        upCommand = up;
        downCommand = down;
        rightCommand = right;
        leftCommand = left;

        //myGame = Modelo.getMyGame();
    }

    public void walkRight() {
        System.out.println("WALK RIGHT");
        TestCanvas lienzo = myGame.getBoardGame().getLienzo();

        lienzo.setCharacter(lienzo.getChWalkRight());

        rightCommand.execute();
    }

    public void walkLeft() {
        TestCanvas lienzo = myGame.getBoardGame().getLienzo();

        lienzo.setCharacter(lienzo.getChWalkLeft());

        leftCommand.execute();
    }

    public void flyRight() {
        TestCanvas lienzo = myGame.getBoardGame().getLienzo();

        lienzo.setCharacter(lienzo.getChFlyRiht());

        rightCommand.execute();
    }

    public void flyLeft() {
        TestCanvas lienzo = myGame.getBoardGame().getLienzo();

        lienzo.setCharacter(lienzo.getChFlyLeft());

        leftCommand.execute();
    }

    public Modelo getMyGame() {
        return myGame;
    }

    public void setMyGame(Modelo myGame) {
        this.myGame = myGame;
    }
}
