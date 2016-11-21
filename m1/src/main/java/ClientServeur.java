import client.Client;
import composant.Configuration;
import rpc.RPC;
import serveur.ServeurComposant;

/**
 * Created by clement on 01/11/16.
 */
public class ClientServeur extends Configuration {
   
    private Client client;
    private ServeurComposant serveurComposant;
    private RPC rpc;
    
    public ClientServeur(String nom) {
        super(null);
        client = new Client(this);
        serveurComposant = new ServeurComposant(this);
        rpc = new RPC(this);

        this.addComposant(client);
        this.addComposant(serveurComposant);
        this.addConnecteur(rpc);

        //les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé
        this.addPortFourni(new Client_out(this, "ClientOut"));
        this.addPortRequis(new Client_in(this, "ClientIn"));

        /*
        this.addAttachmentReceive(serveurComposant,rpc, "ReceiveRequest");
        this.addAttachmentSend(serveurComposant, rpc, "SendResult");
        this.addAttachmentReceive(client,rpc, "ReceiveResult");
        this.addAttachmentSend(client, rpc, "SendRequest");
        this.addBindingRequis(client, "ExchangeClientIn");
        this.addBindingFourni(client, "ExchangeClientOut");
        */

        /*
        this.attachPortFourni(client.getNamedPortFourni("send_request"), rpc.getNamedRoleRequis("from_client"));
        this.attachRoleFourni(client.getNamedPortRequis("receive_result"), rpc.getNamedRoleFourni("to_client"));
        this.attachPortFourni(serveurComposant.getNamedPortFourni("send_result"), rpc.getNamedRoleRequis("from_server"));
        this.attachRoleFourni(serveurComposant.getNamedPortRequis("receive_request"), rpc.getNamedRoleFourni("to_server"));
        */

        this.attachPortFourni(client.getNamedPortFourni("send_request"), rpc.getFrom_client() );
        this.attachRoleFourni(client.getNamedPortRequis("receive_result"), rpc.getTo_client());
        this.attachPortFourni(serveurComposant.getNamedPortFourni("send_result"), rpc.getFrom_server());
        this.attachRoleFourni(serveurComposant.getNamedPortRequis("receive_request"), rpc.getTo_server());


        //this.bindRequis(this.);
        printAttachments();

        System.out.println("Bindings = " + getBindings().toString());

        client.sendMessage(client.getNamedPortFourni("send_request"), "AAAAA");


    }


}
