package config;

import composant.Configuration;
import connecteur.Role;
import port.PortComposant;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Attachment {

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

    public abstract void transmettre();

}
