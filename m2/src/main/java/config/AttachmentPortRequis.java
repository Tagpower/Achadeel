package config;

import connecteur.RoleFourni;
import connecteur.RoleRequis;
import port.PortComposantFourni;
import port.PortComposantRequis;

/**
 * Created by clement on 17/10/16.
 */
public class AttachmentPortRequis extends Attachment {


    PortComposantRequis portRequis;
    RoleFourni roleFourni;

    public AttachmentPortRequis(PortComposantRequis port, RoleFourni role) {
        this.portRequis = port;
        this.roleFourni = role;
    }

}
