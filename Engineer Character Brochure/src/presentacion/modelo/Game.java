package presentacion.modelo;

import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logic.EngrGame;
import logic.Operation;
import logic.Robot;
import logic.command.Move;
import logic.command.MoveDownCommand;
import logic.command.MoveHitCommand;
import logic.command.MoveLeftCommand;
import logic.command.MoveRightCommand;
import logic.command.MoveUpCommand;
import logic.decorator.Flame;
import logic.memento.Memento;
import logica.abstractfactory.factories.AbstractFactory;
import logica.abstractfactory.factories.CivilEngineerFactory;
import logica.abstractfactory.factories.ElectricalEngineerFactory;
import logica.abstractfactory.factories.SoftwareEngineerFactory;
import logica.abstractfactory.products.Tool;
import logica.abstractfactory.products.Vehicle;
import presentacion.vistas.EngineerFactoryView;
import presentacion.vistas.EngineerView;
import presentacion.vistas.PrincipalView;
import logica.abstractfactory.products.Accessory;
import logica.builder.Director;
import logica.builder.Engineer;
import logica.builder.PreDegreeEngineer;
import presentacion.vistas.game.BoardView;

/**
 *
 * @author David Bohorquez
 */
public class Game {

    private AbstractFactory factory;
    private Tool tool;
    private Accessory accessory;
    private Vehicle vehicle;

    private PrincipalView ventanaPrincipal;
    private EngineerFactoryView ventanaEngFactory;
    private EngineerView ventanaEng;

    private Director director;
    private Engineer preDegreeEngr;

    //NEW CODE
    private Robot robot;

    private MoveRightCommand moveRight;
    private MoveLeftCommand moveLeft;
    private MoveUpCommand moveUp;
    private MoveDownCommand moveDown;
    private MoveHitCommand moveHit;

    private Move movements;

    private Operation operation;

    private EngrGame flame;
    
    private Memento backup;

    private BoardView gameBoard;

    public Game() {

        robot = Robot.getRobot();
        robot.ingeniar(this);

        moveRight = new MoveRightCommand(robot, this);
        moveLeft = new MoveLeftCommand(robot, this);
        moveUp = new MoveUpCommand(robot, this);
        moveDown = new MoveDownCommand(robot, this);
        moveHit = new MoveHitCommand(robot, this);

        movements = new Move(moveRight, moveLeft, moveUp, moveDown, moveHit);

        operation = getOperation();

        gameBoard = getBoardGame();

    }

    public Robot getRobot() {
        return robot;
    }

    public BoardView getBoardGame() {
        if (gameBoard == null) {
            gameBoard = new BoardView(this);
        }
        return gameBoard;
    }

    public void addFlame() {
        if (flame == null) {
            flame = new Flame(robot);
        }
    }

    public Move getMovements() {
        return movements;
    }

    public void iniciar() {
        //getVentanaPrincipal().setVisible(true);
        getBoardGame().setVisible(true);
    }

    public Operation getOperation() {
        if (operation == null) {
            operation = new Operation();
        }
        return operation;
    }

    public EngrGame getFlame() {
        return flame;
    }
    
    public void makeBuckup() {
        
    }

    //---------------------------------------------------------------------------------------
    public void chooseFactory(int i) {
        JLabel lblBgEngWindow = getVentanaEng().getLblBgEngWindow();

        switch (i) {
            case 0:
                factory = new SoftwareEngineerFactory();
                break;
            case 1:
                factory = new ElectricalEngineerFactory();
                break;
            case 2:
                factory = new CivilEngineerFactory();
                break;
            default:
                JOptionPane.showMessageDialog(ventanaEngFactory, "¡La fábrica no existe!");
                break;
        }
    }

    public void changeListenerLblCreate() {
        JLabel lblCreate = getVentanaEngFactory().getLblCreate();
        boolean[] states = getVentanaEngFactory().getImgStates();

        if (check(states) == -1) {
            lblCreate.removeMouseListener(ventanaEngFactory.getCtlEnginnerFactoryView());
        } else {
            lblCreate.addMouseListener(ventanaEngFactory.getCtlEnginnerFactoryView());

        }
    }

    public void showEngrParts() {
        tool = factory.createTool();
        accessory = factory.createAccessory();
        vehicle = factory.createVehicle();

    }

    public void buildEngineer() {
        getDirector();
        director.setConstructor(new PreDegreeEngineer(this));
        director.buildEngineer();

        preDegreeEngr = director.getEngineer();

        /*if(getFactory() instanceof SoftwareEngineerFactory) {
         preDegreeEngr.getImgsEngr()[0] = new ImageIcon();
            
         }else if(getFactory() instanceof PreDegreeEngineer) {
            
         }else if(getFactory() instanceof CivilEngineerFactory) {
            
         }*/
    }

    public void onListeners(JLabel[] labels, MouseListener controller) {
        for (int i = 0; i < labels.length; i++) {
            labels[i].addMouseListener(getVentanaEngFactory().getCtlEnginnerFactoryView());
            getVentanaEngFactory().numListenersIncrement();
        }
    }

    public void offListeners(JLabel[] labels, MouseListener controller) {
        for (int i = 0; i < labels.length; i++) {
            labels[i].removeMouseListener(controller);
        }
    }

    public void removAllListeners(JLabel[] labels, MouseListener controller) {
        int lengthListeners = getVentanaEngFactory().getNumListeners();
        for (int i = 0; i < lengthListeners; i++) {
            offListeners(labels, controller);
        }
        getVentanaEngFactory().setNumListeners(0);
    }

    public void onListeners(JLabel[] labels) {
        for (int i = 0; i < labels.length; i++) {
            labels[i].addMouseListener(getVentanaEng().getCtlEngineerController());
        }
    }

    public void offListeners(JLabel[] labels) {
        for (int i = 0; i < labels.length; i++) {
            labels[i].removeMouseListener(getVentanaEng().getCtlEngineerController());
        }
    }

    public int check(boolean[] states) {
        for (int i = 0; i < 3; i++) {
            if (states[i] == true) {
                return i;
            }
        }
        return -1;
    }

    public void selectEngineer(int i) {
        ventanaEngFactory.initStates();

        ventanaEngFactory.getImgStates()[i] = true;
    }

    public void showEngineer() {
        getVentanaEng().getLblEngr().setIcon(preDegreeEngr.getImgsEngr()[0]);
    }

    public PrincipalView getVentanaPrincipal() {
        if (ventanaPrincipal == null) {
            ventanaPrincipal = new PrincipalView(this);
        }

        return ventanaPrincipal;
    }

    public EngineerFactoryView getVentanaEngFactory() {
        if (ventanaEngFactory == null) {
            ventanaEngFactory = new EngineerFactoryView(this);
        }
        return ventanaEngFactory;
    }

    public EngineerView getVentanaEng() {
        if (ventanaEng == null) {
            ventanaEng = new EngineerView(this);
        }

        return ventanaEng;
    }

    public Tool getTool() {
        return tool;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public AbstractFactory getFactory() {
        return factory;
    }

    public Director getDirector() {
        if (director == null) {
            director = new Director();
        }
        return director;
    }

    public Engineer getPreDegreeEngr() {
        return preDegreeEngr;
    }

}
