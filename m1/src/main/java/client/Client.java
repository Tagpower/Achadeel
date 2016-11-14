package client;

import composant.Composant;
import composant.ComposantAtomique;
import composant.Configuration;
import config.AttachmentPortFourni;
import port.PortComposantFourni;
import port.PortComposantRequis;

/**
 * Created by clement on 03/11/16.
 */
public class Client extends ComposantAtomique {

    public Client(String nom, Configuration parent){
        super(nom, parent);
        /*
        les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé
        this.addPortRequis(new Exchange_client_in(this,"Exchange_client_in"));
        this.addPortsFourni(new Exchange_client_out(this,"Exchange_client_out"));
        this.addPortRequis(new ReceiveResult(this,"ReceiveResult"));
        this.addPortsFourni(new SendRequest(this,"SendRequest"));
        */
    }

    //etant donné un port, on donné envoye le msg de port au role correspont à l'aide de attachement
    public void sendMessage(PortComposantFourni port) {
        AttachmentPortFourni attache = (AttachmentPortFourni)this.getParent().getAttachments().get(port.getNom());
        attache.send();
    }

    //donner le msg à un portcomposant fourni nommé "SendRequest" et puis envoiyer le message
    public void sendRequest(String commande){
        PortComposantFourni portComposantFourni = (PortComposantFourni) this.getNamedPortFourni("SendRequest");
        portComposantFourni.setMessage(commande);
        sendMessage(portComposantFourni);
    }
}
