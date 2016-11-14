package config;

import composant.Configuration;
import connecteur.Role;
import port.PortComposant;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Attachment {

    private Configuration parent;
    //private PortComposant port;
    //private Role role;

    public Attachment(Configuration parent) {
        this.parent = parent;
    }

    //passer le message de composant vers le connecteur ou l'inverse
    public void send(){}
}
