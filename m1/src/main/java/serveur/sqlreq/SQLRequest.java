package serveur.sqlreq;

import composant.Configuration;
import connecteur.Connecteur;

/**
 * Created by clement on 06/11/16.
 */
public class SQLRequest extends Connecteur {
    public SQLRequest(Configuration parent) {
        super(parent);
        /*
        les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé
        this.addRoleRequis(new Connect_caller(this,"ConnectionCaller"));
        this.addRoleFourni(new Connect_called(this,"ConnectionCalled"));
        this.addRoleRequis(new DB_caller(this, "DateCaller"));
        this.addRoleFourni(new DB_called(this, "Datacalled"));
        */
    }
}
