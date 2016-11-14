package config;

import composant.Configuration;
import connecteur.Role;
import connecteur.RoleRequis;
import port.PortComposant;
import port.PortComposantFourni;

import java.util.Observable;

/**
 * Created by clement on 17/10/16.
 */
public class AttachmentPortFourni extends Attachment {

    private PortComposantFourni portFourni;
    private RoleRequis roleRequis;

    public AttachmentPortFourni(Configuration parent, PortComposantFourni port, RoleRequis role) {
        super(parent);
        this.portFourni = port;
        this.roleRequis = role;
    }

    public PortComposantFourni getPortFourni() {
        return portFourni;
    }

    public void setPortFourni(PortComposantFourni portFourni) {
        this.portFourni = portFourni;
    }

    public RoleRequis getRoleRequis() {
        return roleRequis;
    }

    public void setRoleRequis(RoleRequis roleRequis) {
        this.roleRequis = roleRequis;
    }

    public void send() {
        roleRequis.setMessage(portFourni.getMessage());
        roleRequis.getParent().send();
    }
}
