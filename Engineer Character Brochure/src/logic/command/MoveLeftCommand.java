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
public class MoveLeftCommand extends Command {

    private Robot robot;

    private Image walk, fly;

    public MoveLeftCommand(Robot robot, Game game) {
        this.myGame = game;

        this.robot = robot;

        walk = new ImageIcon(getClass().getResource("/recursos/images/game/walkLeft.png")).getImage();
        fly = new ImageIcon(getClass().getResource("/recursos/images/game/flyLeft.png")).getImage();
    }

    @Override
    public void execute() {
        TestCanvas lienzo = myGame.getBoardGame().getLienzo();
        if ((robot.getPosY() + 126) <= 390) {
            System.out.println("VOLANDO L!!!");
            robot.setMOVESPEED(10);
            lienzo.setCharacter(fly);
        } else {
            System.out.println("CAMINANDO L!!!!");
            robot.setMOVESPEED(2);
            lienzo.setCharacter(walk);
        }
        robot.moveLeft();
    }

}
