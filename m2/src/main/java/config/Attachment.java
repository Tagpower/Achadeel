package config;

import composant.Configuration;
import connecteur.Role;
import port.PortComposant;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Attachment extends Observable implements Observer {

    private Configuration parent;
    private PortComposant port;
    private Role role;

    public Attachment(Configuration parent) {
        this.parent = parent;
    }

    public PortComposant getPort() {
        return port;
    };

    public Role getRole() {
        return role;
    };

}
