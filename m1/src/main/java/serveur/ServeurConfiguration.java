package serveur;

import composant.Composant;
import composant.Configuration;
import serveur.DBMgr.DatabaseManager;
import serveur.SecMgr.SecurityManager;
import serveur.clearance.ClearanceRequest;
import serveur.connectionMgr.ConnectionManager;
import serveur.secquery.SecurityQuery;
import serveur.sqlreq.SQLRequest;

/**
 * Created by clement on 03/11/16.
 */
public class ServeurConfiguration extends Configuration {
    public ServeurConfiguration(Composant parent){
        super(parent);
        this.addComposant(new ConnectionManager(this));
        this.addComposant(new DatabaseManager(this));
        this.addComposant(new SecurityManager(this));
        this.addConnecteur(new ClearanceRequest(this));
        this.addConnecteur(new SecurityQuery(this));
        this.addConnecteur(new SQLRequest(this));
        /*
        les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé
        this.addPortFourni(new Server_out(this, "ServeurOut"));
        this.addPortRequis(new Server_in(this, "ServeurIn"));
        */


        //les bindings et attachements à ajouter
    }
}
