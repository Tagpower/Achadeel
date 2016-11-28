package serveur.DBMgr;

import composant.Composant;
import composant.ComposantAtomique;
import port.PortComposantRequis;

/**
 * Created by clement on 06/11/16.
 */
public class DatabaseManager extends ComposantAtomique {

    private QueryD_in query_in;
    private QueryD_out query_out;
    private SecurityManagement_in sec_management_in;
    private SecurityManagement_out sec_management_out;

    private String requete;
    private String resultat;

    public DatabaseManager(Composant parent) {
        super(parent);

        this.query_in = new QueryD_in(this, "query_in");
        this.query_out = new QueryD_out(this, "query_out");
        this.sec_management_in = new SecurityManagement_in(this, "security_management_in");
        this.sec_management_out = new SecurityManagement_out(this, "security_management_out");



    }

    public QueryD_in getQuery_in() {
        return query_in;
    }

    public QueryD_out getQuery_out() {
        return query_out;
    }

    public SecurityManagement_in getSec_management_in() {
        return sec_management_in;
    }

    public SecurityManagement_out getSec_management_out() {
        return sec_management_out;
    }

    public void treatMessage(PortComposantRequis port) {
        String messageRecu = port.getMessage();
        if (port == this.query_in) {
            System.out.println("La BDD a reçu une requête : " + messageRecu);
            this.requete = messageRecu;
            sendMessage(this.sec_management_out, messageRecu);
        } else if (port == this.sec_management_in) {
            System.out.println("La BDD a reçu une réponse de sécurité : " + messageRecu);
            if (messageRecu == "OK") {
                if (requete.equals("requete1")) {
                    resultat = "resultat1";
                } else if (requete.equals("requete2")) {
                    resultat = "resultat2";
                } else {
                    resultat = "resultat_vide";
                }
                sendMessage(this.query_out, resultat);
            } else {
                sendMessage(this.query_out, "Requête invalide");
            }
        }
    }

}