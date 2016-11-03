package connecteur;

import java.util.Observable;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Role extends Observable {
    private Connecteur parent;
    private String nom;

    public Role(String nom){
        this.nom = nom;
    }

    public Connecteur getParent() {
        return parent;
    }

    public void setParent(Connecteur parent) {
        this.parent = parent;
    }
}
