package config;

import composant.Configuration;
import port.PortComposant;
import port.PortConfiguration;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Binding {

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


    public abstract void transmettre();


}
