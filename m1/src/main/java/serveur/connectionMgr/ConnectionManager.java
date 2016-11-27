package serveur.connectionMgr;

import composant.Composant;
import composant.ComposantAtomique;
import port.PortComposantRequis;

/**
 * Created by clement on 06/11/16.
 */
public class ConnectionManager extends ComposantAtomique {

    private DBQuery_in dbquery_in;
    private DBQuery_out dbquery_out;
    private SecurityCheck_in sec_in;
    private SecurityCheck_out sec_out;
    private ExternalSocket_in external_in;
    private ExternalSocket_out external_out;

    public ConnectionManager(Composant parent) {
        super(parent);

        this.dbquery_in = new DBQuery_in(this, "dbquery_in");
        this.dbquery_out = new DBQuery_out(this, "dbquery_out");
        this.sec_in = new SecurityCheck_in(this, "security_in");
        this.sec_out = new SecurityCheck_out(this, "security_out");
        this.external_in = new ExternalSocket_in(this, "external_in");
        this.external_out = new ExternalSocket_out(this, "external_out");


    }

    public DBQuery_in getDbquery_in() {
        return dbquery_in;
    }

    public DBQuery_out getDbquery_out() {
        return dbquery_out;
    }

    public ExternalSocket_in getExternal_in() {
        return external_in;
    }

    public ExternalSocket_out getExternal_out() {
        return external_out;
    }

    public SecurityCheck_in getSec_in() {
        return sec_in;
    }


    public SecurityCheck_out getSec_out() {
        return sec_out;
    }

    public void treatMessage(PortComposantRequis port) {
        String messageRecu = port.getMessage();
        if (port == this.external_in) {
            System.out.println("Connection Manager a reçu une demande de connexion : " + messageRecu);
            sendMessage(this.sec_out, messageRecu);
        } else if (port == this.sec_in) {
            System.out.println("Connection Manager a reçu une autorisation de connexion : " + messageRecu);
            if (messageRecu == "OK") {
                sendMessage(this.dbquery_out, messageRecu);
            } else {
                sendMessage(this.external_out, "Connection refusée");
            }
        } else if (port == this.dbquery_in) {
            System.out.println("Connection Manager a reçu un résultat de requête : " + messageRecu);
            sendMessage(this.external_out, messageRecu);
        }
    }

}
