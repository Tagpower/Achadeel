package serveur.SecMgr;

import composant.Composant;
import composant.ComposantAtomique;
import port.PortComposantRequis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 06/11/16.
 */
public class SecurityManager extends ComposantAtomique {

    private CheckQuery_in check_query_in;
    private CheckQuery_out check_query_out;
    private SecurityAuth_in sec_auth_in;
    private SecurityAuth_out sec_auth_out;

    private List<String> authorized_users;

    public SecurityManager(Composant parent) {
        super(parent);

        this.check_query_in = new CheckQuery_in(this, "check_query_in");
        this.check_query_out = new CheckQuery_out(this, "check_query_out");
        this.sec_auth_in = new SecurityAuth_in(this, "security_auth_in");
        this.sec_auth_out = new SecurityAuth_out(this, "security_auth_out");

        this.authorized_users = new ArrayList<String>();
        this.authorized_users.add("hello");
        this.authorized_users.add("admin");

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
            if (this.authorized_users.contains(messageRecu)) {
                sendMessage(this.sec_auth_out, "OK");
            } else {
                sendMessage(this.sec_auth_out, "KO");
            }
        } else if (port == this.check_query_in) {
            System.out.println("Le Security Manager a recu une requête à vérifier : " + messageRecu);
            if (messageRecu.contains("requete")) {
                sendMessage(this.check_query_out, "OK");
            } else {
                sendMessage(this.check_query_out, "KO");
            }
        }
    }

}
