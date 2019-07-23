/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.views;

import logica.pool_object.Operacion;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import presentacion.controllers.BoardController;
import logica.prototype.imagen;

/**
 *
 * @author Andre Sarmiento
 */
public class TestCanvas extends Canvas implements Runnable {

    private BoardView gameBoard;
    private Background backOne;
    private Background backTwo;

    private BoardController board;
    private BufferedImage image/*, imgBack*/;

    private Graphics lapiz;
    public static int ia=1;
    public static Image character;
    public static Image characterRight;
    public static Image characterLeft;
    public static Image characterUp;
    public static Image characterDown;
    public static Image characterActual;
    public static Image characterHit;
    
     public static Image suma;
     public static Image suma2;
     public static Image suma3;
    
    private Operacion oper;
    

    public TestCanvas(BoardView gameBoard) {
        this.gameBoard = gameBoard;
        Operacion.mover();
        
        /*try {
         imgBack = ImageIO.read(getClass().getResource("/resource/images/background.png"));
         } catch (Exception e) {
         System.out.println(e);
         }*/

        characterActual = new ImageIcon(getClass().getResource("/resource/images/sprite1.png")).getImage();      
        suma = new ImageIcon(getClass().getResource("/resource/images/suma.png")).getImage();      
        suma2=suma;
        suma3=suma;
        backOne = new Background(0, 0);
        backTwo = new Background(backOne.getImageWidth(), 0);

        new Thread(this).start();
        setVisible(true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(5);
                repaint();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Graphics window) {

        paint(window);
    }
    
    public int setIcon(int i){
        i=1;
        return i;
    }

    public void paint(Graphics g) {
        Graphics2D pincel = (Graphics2D) g;

        Robot robot = gameBoard.getRobot();

        if (image == null) {
            image = (BufferedImage) (createImage(getWidth(), getHeight()));
            lapiz = image.createGraphics();
        }
        
        lapiz.setColor(getBackground());
        lapiz.fillRect(0, 0, getWidth(), getHeight());
        //lapiz.setColor(getForeground());

        lapiz.drawImage(backOne.getImage(), backOne.getX(), backOne.getY(), null);
        lapiz.drawImage(backTwo.getImage(), backTwo.getX(), backTwo.getY(), null);
        //lapiz.drawImage(character, gameBoard.getRobot().getPosX(), gameBoard.getRobot().getPosY(), this);
       // character=characterUp;
     // board.keyPressed(e);
          

//------------------------------------------ PATRON PROTOTYPE --------------------------------------------------------
        imagen img= new imagen(ia);
           try {
               
               imagen clon=(imagen) img.clonar();

               clon.setIcono(ia);
               characterActual= new ImageIcon(clon.toIcon()).getImage();
               
           } catch (CloneNotSupportedException ex) {
               System.out.println("error");
           }
//--------------------------------------------------------------------------------------------------------------------      

       
        lapiz.drawImage(suma,oper.posX,0, this);
        //lapiz.drawImage(suma2,oper.posX+3000,150, this);
        //lapiz.drawImage(suma3,oper.posX+1500,300, this);
        lapiz.drawImage(characterActual, robot.getPosX(), robot.getPosY(), this);

        pincel.drawImage(image, null, 0, 0);

        backOne.move();
        backTwo.move();

    }
    
    

    public BufferedImage getImageB() {
        return image;
    }

}
