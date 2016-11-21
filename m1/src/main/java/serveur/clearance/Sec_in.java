package serveur.clearance;

import connecteur.Connecteur;
import connecteur.RoleRequis;

/**
 * Created by clement on 06/11/16.
 */
public class Sec_in extends RoleRequis {
    public Sec_in(Connecteur parent, String nom) {
        super(parent, nom);
    }
}
