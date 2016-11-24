package port;

import connecteur.ConnectionPoint;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Port extends ConnectionPoint {
    //private Composant parent;

    public Port(String nom){
        //this.parent = parent;
        this.nom = nom;
    }

//    public Composant getParent() {
//        return parent;
//    }
//
//    public void setParent(Composant parent) {
//        this.parent = parent;
//    }

}
