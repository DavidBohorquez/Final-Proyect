/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.decorator;

import java.awt.Image;
import javax.swing.ImageIcon;
import logic.EngrGame;
import logic.Robot;
import presentacion.modelo.Game;
import presentacion.vistas.game.TestCanvas;

/**
 *
 * @author Andre Sarmiento
 */
public class Flame extends Decorator {
    
    public Flame(EngrGame engr) {
        super(engr);
    }

    @Override
    public void ingeniar(Game game) {
        TestCanvas lienzo = game.getBoardGame().getLienzo();
        
        Image character = new ImageIcon(getClass().getResource("/recursos/images/game/flameRight.png")).getImage();
        
        lienzo.setCharacter(character);
    }
    
}
