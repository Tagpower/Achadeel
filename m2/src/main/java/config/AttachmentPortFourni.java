package config;

import composant.Configuration;
import connecteur.RoleRequis;
import port.PortComposantFourni;

import java.util.Observable;

/**
 * Created by clement on 17/10/16.
 */
public class AttachmentPortFourni extends Attachment {

    PortComposantFourni portFourni;
    RoleRequis roleRequis;

    public AttachmentPortFourni(Configuration parent, PortComposantFourni port, RoleRequis role) {
        super(parent);
        this.portFourni = port;
        this.roleRequis = role;
    }

    public PortComposantFourni getPort() {
        return  portFourni;
    }

    public RoleRequis getRole() {
        return roleRequis;
    }

    public void transmettre() {
        this.roleRequis.setMessage(this.portFourni.getMessage());
        //this.portFourni.setMessage("");
    }

    //DEBUG
    public String toString() {
        return portFourni.getParent().getClass().getSimpleName()+"."+portFourni.getNom() + " -> " + roleRequis.getParent().getClass().getSimpleName()+"." + roleRequis.getNom();
    }
}
