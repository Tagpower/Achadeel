package client;

import composant.ComposantAtomique;
import composant.Configuration;
import port.PortComposantRequis;

/**
 * Created by clement on 03/11/16.
 */
public class Client extends ComposantAtomique {

    private Exchange_client_in exchange_client_in;
    private Exchange_client_out exchange_client_out;
    private ReceiveResult receive_result;
    private SendRequest send_request;

    public Client(Configuration parent){
        super(parent);

        //les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé
        this.exchange_client_in = new Exchange_client_in(this,"exchange_client_in");
        this.exchange_client_out = new Exchange_client_out(this, "exchange_client_out");
        this.receive_result = new ReceiveResult(this,"receive_result");
        this.send_request = new SendRequest(this, "send_request");
    }

    public Exchange_client_in getExchange_client_in() {
        return exchange_client_in;
    }

    public Exchange_client_out getExchange_client_out() {
        return exchange_client_out;
    }

    public ReceiveResult getReceive_result() {
        return receive_result;
    }

    public SendRequest getSend_request() {
        return send_request;
    }

    public void treatMessage(PortComposantRequis port) {
        if (port == this.getReceive_result()) {
            String messageRecu = port.getMessage();
            System.out.println("LE CLIENT A RECU LA REPONSE " + messageRecu);
            this.sendMessage(this.exchange_client_out, messageRecu);
        }
    }
}
