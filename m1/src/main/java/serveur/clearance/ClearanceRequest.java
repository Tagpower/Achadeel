package serveur.clearance;

import composant.Configuration;
import connecteur.Connecteur;
/**
 * Created by clement on 06/11/16.
 */
public class ClearanceRequest extends Connecteur {

    public ClearanceRequest(Configuration parent) {
        super(parent);

        //les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé
        this.addRoleRequis(new Connect_caller(this,"connect_caller"));
        this.addRoleFourni(new Connect_called(this,"connect_called"));
        this.addRoleRequis(new Sec_called(this, "sec_called"));
        this.addRoleFourni(new Sec_caller(this, "sec_caller"));

    }
}
