package serveur.connectionMgr;

import client.Exchange_client_out;
import composant.Composant;

/**
 * Created by clement on 06/11/16.
 */
public class ConnectionManager extends Composant {
    public ConnectionManager(String nom) {
        super(nom);
        this.addPortRequis(new DBQuery_in(this, "InQuery"));
        this.addPortsFourni(new DBQuery_out(this, "OutQuery"));
        this.addPortRequis(new ExternalSocket_in(this, "SocketIn"));
        this.addPortsFourni(new Exchange_client_out(this, "SocketOut"));
        this.addPortRequis(new SecurityCheck_in(this, "SecurityCheckIn"));
        this.addPortsFourni(new SecurityCheck_out(this, "SecurityCheckOut"));
    }
}
