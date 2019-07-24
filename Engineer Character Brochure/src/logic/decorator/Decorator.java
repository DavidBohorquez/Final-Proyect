/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.decorator;

import logic.EngrGame;

/**
 *
 * @author Andre Sarmiento
 */
public abstract class Decorator implements EngrGame {

    protected EngrGame engineer;

    public Decorator(EngrGame engr) {
        this.engineer = engr;
    }
}
