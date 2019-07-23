    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.command;

import logic.Robot;

/**
 *
 * @author Andre Sarmiento
 */
public class MoveLeftCommand implements Command {

    private Robot robot;

    public MoveLeftCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.moveLeft();
    }

}
