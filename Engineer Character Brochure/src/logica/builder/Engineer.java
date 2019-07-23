package logica.builder;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import logica.abstractfactory.products.Accessory;
import logica.abstractfactory.products.Tool;
import logica.abstractfactory.products.Vehicle;

/**
 *
 * @author David Bohorquez
 */
public class Engineer implements Runnable {

    private int posX;
    private int posY;

    private Accessory accessory;
    private Tool tool;
    private Vehicle vehicle;

    private ImageIcon[] imgsEngr;

    private int numImage;

    private Thread drawThread;
    private boolean isAnimado;
    private BufferedImage dobleBuffre;

    private Component lienzo;

    private ImageIcon bkgdLienzo;

    public Engineer() {
        imgsEngr = new ImageIcon[4];
        numImage = 0;

        isAnimado = false;
        bkgdLienzo = new ImageIcon(getClass().getResource("/recursos/images/bkgd1.jpg"));
    }

    public void ingeniar(Component lienzo) {
        dobleBuffre = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.lienzo = lienzo;

        drawThread = new Thread(this);
        isAnimado = true;
        drawThread.start();
    }

    public void dibujar(Component lienzo) {
        if (numImage == 4) {
            numImage = 0;
        }

        Graphics lapiz = dobleBuffre.getGraphics();
        lapiz.drawImage(bkgdLienzo.getImage(), 0, 0, lienzo);

        System.out.println("numImage!!!!!" + numImage);
        lapiz.drawImage(imgsEngr[numImage].getImage(), getPosX(), getPosY(), lienzo);

        Graphics pincel = lienzo.getGraphics();
        pincel.drawImage(dobleBuffre, 0, 0, lienzo);
        numImage++;
    }

    @Override
    public void run() {
        while (isAnimado) {
            dibujar(lienzo);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {

            }
        }
    }

    public void setIsAnimado(boolean isAnimado) {
        this.isAnimado = isAnimado;
    }

    public ImageIcon getBkgdLienzo() {
        return bkgdLienzo;
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

    public ImageIcon getAccessory() {
        return accessory.operation();
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }

    public ImageIcon getTool() {
        return tool.operation();
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public ImageIcon getVehicle() {
        return vehicle.operation();
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ImageIcon[] getImgsEngr() {
        return imgsEngr;
    }

    public void setImgsEngr(ImageIcon[] imgsEngr) {
        this.imgsEngr = imgsEngr;
    }

}
