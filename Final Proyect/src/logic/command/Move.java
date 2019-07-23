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

    private Command rightCommand, leftCommand;

    public Move(Command right, Command left) {
        rightCommand = right;
        leftCommand = left;

    }

    public void moveRight() {

        rightCommand.execute();
    }

    public void moveLeft() {

        leftCommand.execute();
    }
}
