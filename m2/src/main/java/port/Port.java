package port;

import connecteur.ConnectionPoint;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Port extends ConnectionPoint {

    public Port(String nom){
        this.nom = nom;
    }

}
