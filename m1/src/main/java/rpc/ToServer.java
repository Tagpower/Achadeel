package rpc;

import connecteur.Connecteur;
import connecteur.RoleFourni;

/**
 * Created by clement on 03/11/16.
 */
public class ToServer extends RoleFourni {

    public ToServer(Connecteur parent, String nom) {
        super(parent, nom);
    }
}
