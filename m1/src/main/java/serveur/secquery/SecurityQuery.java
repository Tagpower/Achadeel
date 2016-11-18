package serveur.secquery;

import composant.Configuration;
import connecteur.Connecteur;

/**
 * Created by clement on 06/11/16.
 */
public class SecurityQuery extends Connecteur {
    public SecurityQuery(Configuration parent) {
        super(parent);

        //les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé
        this.addRoleRequis(new DB_caller(this,"DataCaller"));
        this.addRoleFourni(new DB_called(this, "DataCalled"));
        this.addRoleRequis(new Sec_caller(this, "SecurityCaller"));
        this.addRoleFourni(new Sec_called(this, "SecurityCalled"));

    }
}
