/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.views;

import java.awt.Dimension;

/**
 *
 * @author Andre Sarmiento
 */
public class Robot {

    final int MOVESPEED = 10;

    private int posX, posY;

    public Robot() {
        posX = 0;
        posY = 0;
    }

    public void moveDown(int height) {
        if (posY + (126 + MOVESPEED) <= height) {
            posY += MOVESPEED;
        }
    }

    public void moveUp() {
        if (posY - MOVESPEED >= 0) {
            posY -= MOVESPEED;
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
