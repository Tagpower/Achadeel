package serveur.SecMgr;

import composant.Composant;
import composant.ComposantAtomique;
import serveur.connectionMgr.SecurityCheck_in;
import serveur.connectionMgr.SecurityCheck_out;

/**
 * Created by clement on 06/11/16.
 */
public class SecurityManager extends ComposantAtomique {
    public SecurityManager(Composant parent) {
        super(parent);
        /*
        les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé

        this.addPortRequis(new SecurityCheck_in(this, "SecurityCheckIn"));
        this.addPortsFourni(new SecurityCheck_out(this, "SecurityCheckOut"));
        this.addPortRequis(new SecurityCheck_in(this, "CheckQueryIn"));
        this.addPortsFourni(new SecurityCheck_out(this, "CheckQueryOut"));
        */
    }
}
