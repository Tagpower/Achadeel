package serveur.clearance;

import connecteur.Connecteur;
import connecteur.RoleFourni;
import connecteur.RoleRequis;

/**
 * Created by clement on 06/11/16.
 */
public class Sec_caller extends RoleFourni {
    public Sec_caller(Connecteur parent, String nom) {
        super(nom);
        this.setParent(parent);
    }
}
