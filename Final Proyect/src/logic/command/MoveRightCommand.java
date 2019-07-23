/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.command;

import java.awt.Image;
import javax.swing.ImageIcon;
import logic.Robot;
import presentacion.model.Modelo;
import presentacion.views.TestCanvas;

/**
 *
 * @author Andre Sarmiento
 */
public class MoveRightCommand extends Command {

    private Robot robot;

    public MoveRightCommand(Robot robot, Modelo myGame) {
        this.myGame = myGame;

        this.robot = robot;

        walk = new ImageIcon(getClass().getResource("/resource/images/walkRight.png")).getImage();
        fly = new ImageIcon(getClass().getResource("/resource/images/flyright.png")).getImage();

    }

    @Override
    public void execute() {
        TestCanvas lienzo = myGame.getBoardGame().getLienzo();
        if ((robot.getPosY() + 126) <= 380) {
            System.out.println("VOLANDO!!!");
            robot.setMOVESPEED(10);
            lienzo.setCharacter(fly);
        } else {
            System.out.println("CAMINANDO!!!!");
            robot.setMOVESPEED(2);
            lienzo.setCharacter(walk);
        }
        robot.moveRight();
    }

}
