/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.command;

import java.awt.Image;
import presentacion.modelo.Game;

/**
 *
 * @author Andre Sarmiento
 */
public /*interface*/abstract class Command {

    protected Game myGame;
    
    protected Image walk, fly;
    
    public abstract void execute();
}
