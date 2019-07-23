/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.views;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Andre Sarmiento
 */
public class Robot {
    private Image character;
    final int MOVESPEED = 10;

    private int posX, posY;

    public Robot() {
        
        //character = new ImageIcon(getClass().getResource("/resource/images/character.png")).getImage();

        posX = 0;
        posY = 0;
    }

    public void moveDown(int height) {
        if (posY + (200 + MOVESPEED) <= height) {
            posY += MOVESPEED;
        }
    }

    public void moveUp() {
        if (posY - MOVESPEED >= -10) {
            posY -= MOVESPEED;
            
        }

    }

    public void moveLeft() {
        if (posX - MOVESPEED >= -10) {
            posX -= MOVESPEED;
            
        }

    }
    
    public void moveRight(int width) {
        if (posX + (MOVESPEED+90) <= width) {
            posX += MOVESPEED;
            
        }

    }
    
    
    public int getPosX() {
           
        return posX;
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

}
