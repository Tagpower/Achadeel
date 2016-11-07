package serveur.secquery;

import connecteur.Connecteur;
import connecteur.RoleRequis;

/**
 * Created by clement on 06/11/16.
 */
public class DB_caller extends RoleRequis {
    public DB_caller(Connecteur parent, String nom) {
        super(parent, nom);
    }
}