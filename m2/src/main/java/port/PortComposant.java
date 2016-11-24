package port;

import composant.Composant;

/**
 * Created by clement on 17/10/16.
 */
public class PortComposant extends Port {

    private Composant parent;

    public PortComposant(Composant parent, String nom){
        super(nom);
        this.parent = parent;
    }

    public Composant getParent() {
        return parent;
    }

    public void setParent(Composant parent) {
        this.parent = parent;
    }
}
