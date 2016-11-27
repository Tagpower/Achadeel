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

    public PortComposantRequis getPort() {
        return portRequis;
    }

    public RoleFourni getRole() {
        return roleFourni;
    }

    public void transmettre() {
        this.portRequis.setMessage(this.roleFourni.getMessage());
    }

    public String toString() {
        return roleFourni.getParent().getClass().getSimpleName()+"."+roleFourni.getNom() + " -> " + portRequis.getParent().getClass().getSimpleName()+"." + portRequis.getNom();
    }

    public void update(Observable o, Object arg) {
        System.out.println(this.getClass().getName() + ".update");
        this.setChanged();
        this.notifyObservers(arg);
    }
}
