/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Image;
import javax.swing.ImageIcon;
import logic.memento.Memento;
import presentacion.modelo.Game;
import presentacion.vistas.game.TestCanvas;

/**
 *
 * @author Andre Sarmiento
 */
public class Robot implements EngrGame{

    private static Robot robot;

    private int MOVESPEED = 10;

    public static int posX, posY;

    private Robot() {
        posX = 0;
        posY = 0;
    }

    //SINGLETON
    public static Robot getRobot() {
        if (robot == null) {
            robot = new Robot();
        }
        return robot;
    }

    //---------
    public void moveDown() {
        if (posY + (126 + MOVESPEED) <= 409) {
            posY += MOVESPEED;
        }
    }

    public void moveUp() {
        if (posY - MOVESPEED >= 0) {
            posY -= MOVESPEED;
        }

    }

    public void moveRight() {
        if (posX + 122 <= 800) {
            posX += MOVESPEED;
        }
    }

    public void moveLeft() {
        if (posX - MOVESPEED >= 0) {
            posX -= MOVESPEED;
        }
    }

    public int getPosX() {
        return posX;
    }
    
    public Memento saveToMemento() {
        return new Memento(this, posX, posY, MOVESPEED);
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getMOVESPEED() {
        return MOVESPEED;
    }

    public void setMOVESPEED(int MOVESPEED) {
        this.MOVESPEED = MOVESPEED;
    }

    @Override
    public void ingeniar(Game myGame) {
        TestCanvas lienzo = myGame.getBoardGame().getLienzo();
        
        Image character = new ImageIcon(getClass().getResource("/recursos/images/game/sprite1.png")).getImage();
        
        lienzo.setCharacter(character);
    }

}
