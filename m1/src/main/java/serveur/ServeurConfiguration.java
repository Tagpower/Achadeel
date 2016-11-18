package serveur;

import composant.Composant;
import composant.ComposantAtomique;
import composant.Configuration;
import connecteur.Connecteur;
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
        ComposantAtomique connectionManager = new ConnectionManager(this);
        ComposantAtomique databaseManager = new DatabaseManager(this);
        ComposantAtomique securityManager = new SecurityManager(this);
        Connecteur clearanceRequest = new ClearanceRequest(this);
        Connecteur securityQuery = new SecurityQuery(this);
        Connecteur sqlRequest = new SQLRequest(this);

        this.addComposant(connectionManager);
        this.addComposant(databaseManager);
        this.addComposant(securityManager);
        this.addConnecteur(clearanceRequest);
        this.addConnecteur(securityQuery);
        this.addConnecteur(sqlRequest);

        /*
        //ajoute des bindings
        this.addBindingFourni(connectionManager, "requestIn");
        this.addBindingRequis(connectionManager, "requestOut");
        this.addBindingFourni((ComposantAtomique)parent, "requestOut");
        this.addBindingRequis((ComposantAtomique)parent, "requestIn");


        //ajoute des attachement dans la configuration Serveur
        this.addAttachmentSend(connectionManager, clearanceRequest, "SecurityCheckOut");
        this.addAttachmentReceive(connectionManager, clearanceRequest, "SecurityCheckIn");
        this.addAttachmentSend(connectionManager, sqlRequest, "DatabaseQueryOut");
        this.addAttachmentReceive(connectionManager, sqlRequest, "DatabaseQueryIn");

        this.addAttachmentSend(databaseManager, sqlRequest, "QueryDataOut");
        this.addAttachmentReceive(databaseManager, sqlRequest, "QueryDataIn");
        this.addAttachmentSend(databaseManager,securityQuery, "SecurityManagementOut");
        this.addAttachmentReceive(databaseManager, securityQuery, "SecurityManagementIn");

        this.addAttachmentSend(securityManager, clearanceRequest, "SecurityAuthOut");
        this.addAttachmentReceive(securityManager, clearanceRequest, "SecurityAuthIn");
        this.addAttachmentSend(securityManager, securityQuery, "CheckQueryOut");
        this.addAttachmentReceive(securityManager, securityQuery, "CheckQueryIn");
        */
        //les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé
        this.addPortFourni(new Server_out(this, "ServeurOut"));
        this.addPortRequis(new Server_in(this, "ServeurIn"));



        //les bindings et attachements à ajouter
    }
}
