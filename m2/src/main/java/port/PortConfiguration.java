package port;


import config.Configuration;

/**
 * Created by clement on 17/10/16.
 */
public class PortConfiguration extends Port {
    public Configuration parent;

    public PortConfiguration(String nom) {
        super(nom);
    }

    public Configuration getParent() {
        return parent;
    }

    public void setParent(Configuration parent) {
        this.parent = parent;
    }
}
