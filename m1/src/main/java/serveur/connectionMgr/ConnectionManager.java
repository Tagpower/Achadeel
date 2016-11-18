package serveur.connectionMgr;

import client.Exchange_client_out;
import composant.Composant;
import composant.ComposantAtomique;

/**
 * Created by clement on 06/11/16.
 */
public class ConnectionManager extends ComposantAtomique {
    public ConnectionManager(Composant parent) {
        super(parent);

        //les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé
        this.addPortRequis(new DBQuery_in(this, "InQuery"));
        this.addPortFourni(new DBQuery_out(this, "OutQuery"));
        this.addPortRequis(new ExternalSocket_in(this, "SocketIn"));
        this.addPortFourni(new Exchange_client_out(this, "SocketOut"));
        this.addPortRequis(new SecurityCheck_in(this, "SecurityCheckIn"));
        this.addPortFourni(new SecurityCheck_out(this, "SecurityCheckOut"));

    }
}
