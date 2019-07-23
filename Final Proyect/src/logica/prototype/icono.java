/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.prototype;

import java.awt.Image;
import javax.swing.Icon;

/**
 *
 * @author Usuario
 */
public abstract class icono implements Cloneable{
    int icon;
    
    
    public icono(int icon){
        this.icon=icon;
    }
    
    
    public icono clonar() throws CloneNotSupportedException{
     return (icono) super.clone();
    }


public abstract Image toIcon();

    
public void setIcono(int icono){
    this.icon=icon;
}



//public int getIcono(){
//        return 0;
//}

}



