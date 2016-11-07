package serveur.clearance;

import connecteur.Connecteur;
import connecteur.RoleRequis;

/**
 * Created by clement on 06/11/16.
 */
public class Connect_caller extends RoleRequis {

    public Connect_caller(Connecteur parent, String nom) {
        super(nom);
        this.setParent(parent);
    }
}
