package serveur;

import composant.Composant;
import composant.ComposantAtomique;
import composant.Configuration;
import port.PortComposantRequis;

/**
 * Created by naixinwang on 07/11/2016.
 */
public class ServeurComposant extends ComposantAtomique {

    ServeurConfiguration serveurConfiguration;
    private Receive_request receive_request;
    private Send_result send_result;

    public ServeurComposant(Composant parent) {
        super(parent);
        this.serveurConfiguration = new ServeurConfiguration(this);
        this.send_result = new Send_result(this, "send_result");
        this.receive_request = new Receive_request(this, "receive_request");
    }

    public Receive_request getReceive_request() {
        return receive_request;
    }

    public Send_result getSend_result() {
        return send_result;
    }

    public Configuration getServeurConfiguration() {
        return serveurConfiguration;
    }

    public void treatMessage(PortComposantRequis port) {
        String messageRecu = port.getMessage();
        if (port == this.receive_request) {
            System.out.println("LE SERVEUR A RECU " + messageRecu);
            this.serveurConfiguration.sendMessage(serveurConfiguration.getServer_in(), messageRecu);
        }
    }
}
