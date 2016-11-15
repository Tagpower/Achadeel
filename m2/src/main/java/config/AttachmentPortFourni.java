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

    public void transmettre() {
        this.roleRequis.setMessage(this.portFourni.getMessage());
        this.portFourni.setMessage("");
    }

    public void update(Observable o, Object arg) {
        System.out.println(this.getClass().getName()+".update");
        this.setChanged();
        this.notifyObservers(arg);
    }
}
