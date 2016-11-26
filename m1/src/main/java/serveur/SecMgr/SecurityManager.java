package serveur.SecMgr;

import composant.Composant;
import composant.ComposantAtomique;
import port.PortComposantRequis;

/**
 * Created by clement on 06/11/16.
 */
public class SecurityManager extends ComposantAtomique {

    private CheckQuery_in check_query_in;
    private CheckQuery_out check_query_out;
    private SecurityAuth_in sec_auth_in;
    private SecurityAuth_out sec_auth_out;

    public SecurityManager(Composant parent) {
        super(parent);

        this.check_query_in = new CheckQuery_in(this, "check_query_in");
        this.check_query_out = new CheckQuery_out(this, "check_query_out");
        this.sec_auth_in = new SecurityAuth_in(this, "security_auth_in");
        this.sec_auth_out = new SecurityAuth_out(this, "security_auth_out");

        /*
        this.addPortRequis(new SecurityCheck_in(this, "SecurityCheckIn"));
        this.addPortFourni(new SecurityCheck_out(this, "SecurityCheckOut"));
        this.addPortRequis(new SecurityCheck_in(this, "CheckQueryIn"));
        this.addPortFourni(new SecurityCheck_out(this, "CheckQueryOut"));
        */

    }

    public CheckQuery_in getCheck_query_in() {
        return check_query_in;
    }

    public CheckQuery_out getCheck_query_out() {
        return check_query_out;
    }

    public SecurityAuth_in getSec_auth_in() {
        return sec_auth_in;
    }

    public SecurityAuth_out getSec_auth_out() {
        return sec_auth_out;
    }

    public void treatMessage(PortComposantRequis port) {
        String messageRecu = port.getMessage();
        if (port == this.sec_auth_in) {
            System.out.println("Le Security Manager a recu une demande de connexion : " + messageRecu);
            sendMessage(this.sec_auth_out, messageRecu);
        } else if (port == this.check_query_in) {
            System.out.println("Le Security Manager a recu une requête à vérifier : " + messageRecu);
            sendMessage(this.check_query_out, messageRecu);
        }
    }

}
