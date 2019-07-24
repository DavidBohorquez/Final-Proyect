/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre Sarmiento
 */
public class Operation extends Thread {

    private int posX;
    private int posY;

    private boolean active;

    public Operation() {
        active = false;
    }

    @Override
    public void run() {
        posX = 700;
        posY = 20;

        active = true;

        while (true) {
            if (posX - 5 >= -20) {
                posX -= 5;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
