package serveur.secquery;

import connecteur.Connecteur;
import connecteur.RoleRequis;

/**
 * Created by clement on 06/11/16.
 */
public class DB_in extends RoleRequis {
    public DB_in(Connecteur parent, String nom) {
        super(parent, nom);
    }
}