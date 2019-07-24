/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.memento;

import logic.Robot;

/**
 *
 * @author Andre Sarmiento
 */
public class Memento {

    private Robot robot;
    private int posX, posY, MOVESPEED;

    public Memento(Robot robot, int posX, int posY, int MOVESPEED) {
        this.robot = robot;
        this.posX = posX;
        this.posY = posY;
        this.MOVESPEED = MOVESPEED;
    }
    
    public void restore() {
        
    }
}
