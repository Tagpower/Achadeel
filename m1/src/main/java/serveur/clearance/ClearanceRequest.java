package serveur.clearance;

import composant.Configuration;
import connecteur.Connecteur;
import connecteur.Glue;

/**
 * Created by clement on 06/11/16.
 */
public class ClearanceRequest extends Connecteur {

    public ClearanceRequest(Configuration parent) {
        super(parent, new Glue());
        this.getGlue().addRoleRequis(new Connect_caller("connect_caller"));
        this.getGlue().addRoleFourni(new Connect_called("connect_called"));
        this.getGlue().addRoleRequis(new Sec_caller("sec_caller"));
        this.getGlue().addRoleFourni(new Sec_called("sec_called"));

    }



}
