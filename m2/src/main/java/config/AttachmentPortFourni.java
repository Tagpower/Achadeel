package config;

import connecteur.Role;
import connecteur.RoleRequis;
import port.PortComposant;
import port.PortComposantFourni;

/**
 * Created by clement on 17/10/16.
 */
public class AttachmentPortFourni extends Attachment {

    PortComposantFourni portFourni;
    RoleRequis roleRequis;

    public AttachmentPortFourni(PortComposantFourni port, RoleRequis role) {
        this.portFourni = port;
        this.roleRequis = role;
    }
}
