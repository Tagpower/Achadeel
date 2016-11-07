package serveur.sqlreq;

import connecteur.Connecteur;
import connecteur.RoleFourni;

/**
 * Created by clement on 06/11/16.
 */
public class DB_called extends RoleFourni {

    public DB_called(Connecteur parent, String nom) {
        super(parent, nom);
    }
}
