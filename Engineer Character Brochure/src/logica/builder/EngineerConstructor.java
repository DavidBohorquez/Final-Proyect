package logica.builder;

import logica.abstractfactory.factories.AbstractFactory;

/**
 *
 * @author David Bohorquez
 */
public abstract class EngineerConstructor {

    protected Engineer engineer;
    protected AbstractFactory factory;

    public Engineer getEngineer() {
        return engineer;
    }

    public abstract void buildEnginner();

    public abstract void buildAccessory();

    public abstract void buildTool();

    public abstract void buildVehicle();
}
