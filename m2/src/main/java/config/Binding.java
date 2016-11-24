package config;

import composant.Configuration;
import port.PortComposant;
import port.PortConfiguration;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Binding extends Observable implements Observer {

    private Configuration parent;
    private PortConfiguration p_conf;
    private PortComposant p_comp;

    public Binding(Configuration parent) {
        super();
        this.parent = parent;
    }

    public void setParent(Configuration c) {
        this.parent = c;
    }

    public Configuration getParent() {
        return this.parent;
    }

    public PortComposant getP_comp() {
        return p_comp;
    }

    public void setP_comp(PortComposant p_comp) {
        this.p_comp = p_comp;
    }

    public PortConfiguration getP_conf() {
        return p_conf;
    }

    public void setP_conf(PortConfiguration p_conf) {
        this.p_conf = p_conf;
    }

    //



    public abstract void transmettre();





}
