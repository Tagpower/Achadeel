import client.Client;
import composant.Configuration;
import port.PortConfigurationFourni;
import rpc.RPC;
import serveur.ServeurComposant;

/**
 * Created by clement on 01/11/16.
 */
public class ClientServeur extends Configuration {
   
    private Client client;
    private ServeurComposant serveurComposant;
    private RPC rpc;

    private Client_in client_in;
    private Client_out client_out;
    
    public ClientServeur(String nom) {
        super(null);
        client = new Client(this);
        serveurComposant = new ServeurComposant(this);
        rpc = new RPC(this);

        this.addComposant(client);
        this.addComposant(serveurComposant);
        this.addConnecteur(rpc);

        //les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé
        this.client_out = new Client_out(this, "ClientOut");
        this.client_in = new Client_in(this, "ClientIn");

        this.bindRequis(this.client_in, client.getExchange_client_in());
        this.bindFourni(this.client_out, client.getExchange_client_out());

        this.attachPortFourni(client.getSend_request(), rpc.getFrom_client());
        this.attachRoleFourni(client.getReceive_result(), rpc.getTo_client());
        this.attachPortFourni(serveurComposant.getSend_result(), rpc.getFrom_server());
        this.attachRoleFourni(serveurComposant.getReceive_request(), rpc.getTo_server());

        //DEBUG
        //printAttachments();
        //printBindings();


    }
    
    public void sendMessage(PortConfigurationFourni port, String msg) {
        System.out.println("port.getMessage() = " + port.getMessage());
    }

    public void start() {
        this.sendMessage(this.client_in, "hello");
    }


}
