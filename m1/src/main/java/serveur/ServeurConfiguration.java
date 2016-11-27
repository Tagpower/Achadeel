package serveur;

import composant.Composant;
import composant.Configuration;
import port.PortConfigurationFourni;
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

    private Server_in server_in;
    private Server_out server_out;

    public ServeurConfiguration(Composant parent){
        super(parent);

        this.server_in = new Server_in(this, "server_in");
        this.server_out = new Server_out(this, "server_out");

        ConnectionManager connectionManager = new ConnectionManager(this);
        DatabaseManager databaseManager = new DatabaseManager(this);
        SecurityManager securityManager = new SecurityManager(this);
        ClearanceRequest clearanceRequest = new ClearanceRequest(this);
        SecurityQuery securityQuery = new SecurityQuery(this);
        SQLRequest sqlRequest = new SQLRequest(this);

        this.addComposant(connectionManager);
        this.addComposant(databaseManager);
        this.addComposant(securityManager);
        this.addConnecteur(clearanceRequest);
        this.addConnecteur(securityQuery);
        this.addConnecteur(sqlRequest);

        //TODO bindings
        this.bindRequis(server_in, connectionManager.getExternal_in());
        this.bindFourni(server_out, connectionManager.getExternal_out());


        //Attachments
        //SQLrequest
        this.attachPortFourni(connectionManager.getDbquery_out(), sqlRequest.getConnect_in());
        this.attachRoleFourni(connectionManager.getDbquery_in(), sqlRequest.getConnect_out());
        this.attachPortFourni(databaseManager.getQuery_out(), sqlRequest.getDb_in());
        this.attachRoleFourni(databaseManager.getQuery_in(), sqlRequest.getDb_out());
        //SecurityQuery
        this.attachPortFourni(databaseManager.getSec_management_out(), securityQuery.getDb_in());
        this.attachRoleFourni(databaseManager.getSec_management_in(), securityQuery.getDb_out());
        this.attachPortFourni(securityManager.getCheck_query_out(), securityQuery.getSec_in());
        this.attachRoleFourni(securityManager.getCheck_query_in(), securityQuery.getSec_out());
        //Clearance
        this.attachPortFourni(securityManager.getSec_auth_out(), clearanceRequest.getSec_in());
        this.attachRoleFourni(securityManager.getSec_auth_in(), clearanceRequest.getSec_out());
        this.attachPortFourni(connectionManager.getSec_out(), clearanceRequest.getConnect_in());
        this.attachRoleFourni(connectionManager.getSec_in(), clearanceRequest.getConnect_out());

//        printAttachments();
//        printBindings();
    }

    public Server_in getServer_in() {
        return server_in;
    }

    public Server_out getServer_out() {
        return server_out;
    }

    @Override
    public void sendMessage(PortConfigurationFourni port, String msg) {
        ((ServeurComposant)this.parent).sendMessage(((ServeurComposant) this.parent).getSend_result(), msg);
    }

}
