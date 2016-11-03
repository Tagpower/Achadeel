package config;

import composant.Composant;
import port.PortComposant;
import port.PortConfiguration;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Binding extends Observable implements Observer {

    private Composant parent;
    private PortConfiguration p_conf;
    private PortComposant p_comp;

    public Binding() {
        super();
    }

    public void setParent(Composant c) {
        this.parent = c;
    }

    public Composant getParent() {
        return this.parent;
    }



}
