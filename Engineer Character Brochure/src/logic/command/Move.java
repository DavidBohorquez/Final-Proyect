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

    private Command rightCommand, leftCommand, upCommand, DownCommand,HitCommand;

    public Move(Command right, Command left, Command up, Command Down, Command Hit) {
        rightCommand = right;
        leftCommand = left;
        upCommand = up;
        DownCommand = Down;
        HitCommand = Hit;
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
    
    public void moveDown() {
        DownCommand.execute();
    }
    
     public void moveHit() {
        HitCommand.execute();
    }
}
