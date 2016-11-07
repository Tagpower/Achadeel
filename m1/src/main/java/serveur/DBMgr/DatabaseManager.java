package serveur.DBMgr;

import composant.Composant;
import composant.ComposantAtomique;
import serveur.connectionMgr.SecurityCheck_in;
import serveur.connectionMgr.SecurityCheck_out;

/**
 * Created by clement on 06/11/16.
 */
public class DatabaseManager extends ComposantAtomique {
    public DatabaseManager(String nom) {
        super(nom);
        this.addPortRequis(new QueryD_in(this,"QueryDataIn"));
        this.addPortsFourni(new QueryD_out(this, "QueryDataOut"));
        this.addPortRequis(new SecurityCheck_in(this, "SecurityManagementIn"));
        this.addPortsFourni(new SecurityCheck_out(this, "SecurityManagementOut"));
    }
}