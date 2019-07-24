/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.command;

import java.awt.Image;
import javax.swing.ImageIcon;
import logic.Robot;
import presentacion.modelo.Game;
import presentacion.vistas.game.TestCanvas;

/**
 *
 * @author Andre Sarmiento
 */
public class MoveRightCommand extends Command {

    private Robot robot;

    public MoveRightCommand(Robot robot, Game myGame) {
        this.myGame = myGame;

        this.robot = robot;

        walk = new ImageIcon(getClass().getResource("/recursos/images/game/walkRight.png")).getImage();
        fly = new ImageIcon(getClass().getResource("/recursos/images/game/flyright.png")).getImage();

    }

    @Override
    public void execute() {
        TestCanvas lienzo = myGame.getBoardGame().getLienzo();
        if ((robot.getPosY() + 126) <= 390) {
            System.out.println("VOLANDO!!!");
            robot.setMOVESPEED(10);

            lienzo.setCharacter(fly);
        } else {
            System.out.println("CAMINANDO!!!!" + robot.getPosX());

            if (robot.getPosX() <= 200) {
                robot.setMOVESPEED(2);
                lienzo.setCharacter(walk);
            } else {
                System.out.println("LLAMAS!!!!");
                robot.setMOVESPEED(10);
                myGame.addFlame();
                myGame.getFlame().ingeniar(myGame);
            }

        }
        robot.moveRight();
    }

}
