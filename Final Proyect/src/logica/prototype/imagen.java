/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.prototype;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Usuario
 */
public class imagen extends icono{

    public imagen(int icon) {
        super(icon);
    }
    
  

    @Override
    public Image toIcon() {
        int i;
        i = this.icon;
        //System.out.println(i);
        Image ic= new ImageIcon(getClass().getResource("/resource/images/sprite"+i+".png")).getImage();
        return ic;
    }
    
}
