import client.Client;
import composant.Configuration;
import connecteur.Connecteur;
import rpc.RPC;
import serveur.ServeurComposant;

/**
 * Created by clement on 01/11/16.
 */
public class ClientServeur extends Configuration {
   
    private Client client;
    private ServeurComposant serveurComposant;
    private Connecteur rpc;
    
    public ClientServeur(String nom) {
        super(null);
        client = new Client(this);
        serveurComposant = new ServeurComposant(this);
        rpc = new RPC(this);
        //serveurConfiguration = new ServeurConfiguration(this);
        this.addComposant(client);
        this.addComposant(serveurComposant);
        this.addConnecteur(rpc);
        /*
        les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé
        this.addPortFourni(new Client_out(this, "ClientOut"));
        this.addPortRequis(new Client_in(this, "ClientIn"));
        */
        this.addBindingRequis(client, "ExchangeClientIn");
        this.addBindingFourni(client, "ExcnangeClientOut");
        this.addAttachmentReceive(serveurComposant,rpc, "ReceiveRequest");
        this.addAttachmentSend(serveurComposant, rpc, "SendResult");
        this.addAttachmentReceive(client,rpc, "ReceiveResult");
        this.addAttachmentSend(client, rpc, "SendRequest");
    }


}
