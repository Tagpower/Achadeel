package serveur.SecMgr;

import composant.ComposantAtomique;
import serveur.connectionMgr.SecurityCheck_in;
import serveur.connectionMgr.SecurityCheck_out;

/**
 * Created by clement on 06/11/16.
 */
public class SecurityManager extends ComposantAtomique {
    public SecurityManager(String nom) {
        super(nom);
        this.addPortRequis(new SecurityCheck_in(this, "SecurityCheckIn"));
        this.addPortsFourni(new SecurityCheck_out(this, "SecurityCheckOut"));
        this.addPortRequis(new SecurityCheck_in(this, "CheckQueryIn"));
        this.addPortsFourni(new SecurityCheck_out(this, "CheckQueryOut"));
    }
}
