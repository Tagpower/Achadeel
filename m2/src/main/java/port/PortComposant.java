package port;

import composant.Composant;

/**
 * Created by clement on 17/10/16.
 */
public class PortComposant extends Port {
    public Composant parent;

    public PortComposant(String nom){
        super(nom);
    }
    public Composant getParent() {
        return parent;
    }

    public void setParent(Composant parent) {
        this.parent = parent;
    }
}
