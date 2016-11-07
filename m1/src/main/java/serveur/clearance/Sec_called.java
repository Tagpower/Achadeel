package serveur.clearance;

import connecteur.Connecteur;
import connecteur.RoleFourni;
import connecteur.RoleRequis;

/**
 * Created by clement on 06/11/16.
 */
public class Sec_called extends RoleRequis {
    public Sec_called(Connecteur parent, String nom) {
        super(nom);
        this.setParent(parent);
    }
}
