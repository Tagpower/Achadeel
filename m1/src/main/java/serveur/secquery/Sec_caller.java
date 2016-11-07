package serveur.secquery;

import connecteur.Connecteur;
import connecteur.RoleRequis;

/**
 * Created by clement on 06/11/16.
 */
public class Sec_caller extends RoleRequis {
    public Sec_caller(Connecteur parent, String nom) {
        super(parent, nom);
    }
}
