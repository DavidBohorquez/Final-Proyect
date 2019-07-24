/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.command;

/**
 *
 * @author Andre Sarmiento
 */
public class Move {

    private Command rightCommand, leftCommand, upCommand;

    public Move(Command right, Command left, Command up) {
        rightCommand = right;
        leftCommand = left;
        upCommand = up;
    }

    public void moveRight() {
        rightCommand.execute();
    }

    public void moveLeft() {
        leftCommand.execute();
    }

    public void moveUp() {
        upCommand.execute();
    }
}
