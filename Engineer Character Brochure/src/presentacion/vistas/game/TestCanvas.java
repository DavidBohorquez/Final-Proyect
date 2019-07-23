/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vistas.game;

import logic.Robot;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Andre Sarmiento
 */
public class TestCanvas extends Canvas implements Runnable {

    private BoardView gameBoard;

    private Background backOne;
    private Background backTwo;

    private BufferedImage image/*, imgBack*/;

    private Graphics lapiz;

    private Image character, chWalkRight, chWalkLeft, chFlyRiht, chFlyLeft;

    public TestCanvas(BoardView gameBoard) {
        this.gameBoard = gameBoard;

        /*try {
         imgBack = ImageIO.read(getClass().getResource("/resource/images/background.png"));
         } catch (Exception e) {
         System.out.println(e);
         }*/
        character = new ImageIcon(getClass().getResource("/recursos/images/character.png")).getImage();
        chWalkRight = new ImageIcon(getClass().getResource("/recursos/images/character.png")).getImage();
        chWalkLeft = new ImageIcon(getClass().getResource("/recursos/images/character.png")).getImage();
        chFlyRiht = new ImageIcon(getClass().getResource("/recursos/images/character.png")).getImage();
        chFlyLeft = new ImageIcon(getClass().getResource("/recursos/images/character.png")).getImage();

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

    public void paint(Graphics g) {
        Graphics2D pincel = (Graphics2D) g;

        Robot robot = gameBoard.getMyGame().getRobot();

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
        lapiz.drawImage(character, robot.getPosX(), robot.getPosY(), this);

        pincel.drawImage(image, null, 0, 0);

        backOne.move();
        backTwo.move();

    }

    public BufferedImage getImageB() {
        return image;
    }

    public Image getCharacter() {
        return character;
    }

    public void setCharacter(Image character) {
        this.character = character;
    }

    public Image getChWalkRight() {
        return chWalkRight;
    }

    public void setChWalkRight(Image chWalkRight) {
        this.chWalkRight = chWalkRight;
    }

    public Image getChWalkLeft() {
        return chWalkLeft;
    }

    public void setChWalkLeft(Image chWalkLeft) {
        this.chWalkLeft = chWalkLeft;
    }

    public Image getChFlyRiht() {
        return chFlyRiht;
    }

    public void setChFlyRiht(Image chFlyRiht) {
        this.chFlyRiht = chFlyRiht;
    }

    public Image getChFlyLeft() {
        return chFlyLeft;
    }

    public void setChFlyLeft(Image chFlyLeft) {
        this.chFlyLeft = chFlyLeft;
    }

}
