package client;

import composant.ComposantAtomique;
import composant.Configuration;

/**
 * Created by clement on 03/11/16.
 */
public class Client extends ComposantAtomique {

    public Client(Configuration parent){
        super(parent);

        /*
        les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé
        this.addPortRequis(new Exchange_client_in(this,"Exchange_client_in"));
        this.addPortsFourni(new Exchange_client_out(this,"Exchange_client_out"));
        this.addPortRequis(new ReceiveResult(this,"ReceiveResult"));
        this.addPortsFourni(new SendRequest(this,"SendRequest"));
        */
    }
}
