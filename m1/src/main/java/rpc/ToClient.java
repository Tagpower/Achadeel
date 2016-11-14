package rpc;

import connecteur.Connecteur;
import connecteur.RoleFourni;

/**
 * Created by clement on 03/11/16.
 */
public class ToClient extends RoleFourni {

    public ToClient(Connecteur parent, String nom) {
        super(parent, nom);
    }
}
