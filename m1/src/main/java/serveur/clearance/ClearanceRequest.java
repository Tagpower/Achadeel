package serveur.clearance;

import composant.Configuration;
import connecteur.Connecteur;
import connecteur.Glue;

/**
 * Created by clement on 06/11/16.
 */
public class ClearanceRequest extends Connecteur {

    public ClearanceRequest(Configuration parent) {
        super(parent);
        this.addRoleRequis(new Connect_caller("connect_caller"));
        this.addRoleFourni(new Connect_called("connect_called"));
        this.addRoleRequis(new Sec_caller("sec_caller"));
        this.addRoleFourni(new Sec_called("sec_called"));

    }



}
