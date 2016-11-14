package config;

import composant.Configuration;
import connecteur.RoleFourni;
import port.PortComposantRequis;

import java.util.Observable;

/**
 * Created by clement on 17/10/16.
 */
public class AttachmentPortRequis extends Attachment {

    PortComposantRequis portRequis;
    RoleFourni roleFourni;

    public AttachmentPortRequis(Configuration parent, PortComposantRequis port, RoleFourni role) {
        super(parent);
        this.portRequis = port;
        this.roleFourni = role;
    }

    public PortComposantRequis getPortRequis() {
        return portRequis;
    }

    public void setPortRequis(PortComposantRequis portRequis) {
        this.portRequis = portRequis;
    }

    public RoleFourni getRoleFourni() {
        return roleFourni;
    }

    public void setRoleFourni(RoleFourni roleFourni) {
        this.roleFourni = roleFourni;
    }

    //envois le msg à portRequis d'un composant et le composant continuer à envoyer
    public void send() {
        portRequis.setMessage(roleFourni.getMessage());
        portRequis.getParent().send();
    }
}
