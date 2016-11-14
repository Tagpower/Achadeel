package port;

import composant.Composant;
import connecteur.ConnectionPoint;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Port extends ConnectionPoint {
    private String nom;
    private Composant parent;

    public Port(Composant parent, String nom){
        this.parent = parent;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Composant getParent() {
        return parent;
    }

    public void setParent(Composant parent) {
        this.parent = parent;
    }

    public void emitMessage(String msg) {}

}
