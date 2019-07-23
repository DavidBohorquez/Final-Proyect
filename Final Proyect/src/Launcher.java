

import presentacion.model.Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estudiantes
 */
public class Launcher {
    
    private Modelo myGame;

    
    public Launcher() {
        myGame = new Modelo();

        
        myGame.initGame();
          }
    
    public static void main(String[] args) {
        new Launcher();
    }
    
}
