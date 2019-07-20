/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author Andre Sarmiento
 */
public class Background {

    private BufferedImage image;

    private int x;
    private int y;

    public Background(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            image = ImageIO.read(getClass().getResource("/resource/images/background.png"));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void move() {

        this.x -= 5;

        if (this.x <= -1 * image.getWidth()) {

            this.x = this.x + image.getWidth() * 2;
        }

    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getImageWidth() {
        return image.getWidth();
    }

    public BufferedImage getImage() {
        return image;
    }

    public String toString() {
        return "Background: x=&amp;amp;amp;quot;" + getX() + ", y=" + getY() + ", height=" + image.getHeight() + ", width=" + image.getWidth();
    }
}
