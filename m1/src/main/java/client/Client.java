package client;

import composant.Composant;
import port.PortComposantFourni;
import port.PortComposantRequis;

/**
 * Created by clement on 03/11/16.
 */
public class Client extends Composant {

    public Client(String nom){
        super(nom);
        this.addPortRequis(new Exchange_client_in(this,"Exchange_client_in"));
        this.addPortsFourni(new Exchange_client_out(this,"Exchange_client_out"));
        this.addPortRequis(new ReceiveResult(this,"ReceiveResult"));
        this.addPortsFourni(new SendRequest(this,"SendRequest"));
    }
}
