/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.pool_object;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Usuario
 */
public class Operacion {
   public static int posX=900;
  
    
    public Operacion(){
    
        
    }
    
    static Thread hilo = new Thread()
    {
       @Override
        public void run()
        {
            try
            {
                while(true)
                {
                //if(posX==-400){
                //posX=850;
                //}
                  posX=posX-1;                
                  hilo.sleep(4);
                   
                }
            } catch (java.lang.InterruptedException ex) {
                System.out.println("error");
                       System.out.println(ex.getMessage()); 
                                                         }
            
        }
    };
    
    
    public static void mover()
  {
      Timer timer= new Timer();
      TimerTask task = new TimerTask() {
          @Override
          public void run() {
              System.out.println("aaaa");
              hilo.start();
              
          }
      };
      if(!hilo.isAlive()){  
        timer.schedule(task, 1000);  
    }
  }
    
}
