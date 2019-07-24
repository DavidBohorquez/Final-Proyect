/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.command;

import javax.swing.ImageIcon;
import logic.Robot;
import presentacion.modelo.Game;
import presentacion.vistas.game.TestCanvas;

/**
 *
 * @author Andre Sarmiento
 */
public class MoveDownCommand extends Command {
    
    private Robot robot;
    
    public MoveDownCommand(Robot robot, Game myGame) {
        this.myGame = myGame;
        
        this.robot = robot;
        
        this.walk = new ImageIcon(getClass().getResource("/recursos/images/game/jumped.png")).getImage();
    }

    @Override
    public void execute() {
        TestCanvas lienzo = myGame.getBoardGame().getLienzo();
        
        robot.setMOVESPEED(10);
        
        lienzo.setCharacter(walk);
        
        robot.moveDown();
    }
    
}
