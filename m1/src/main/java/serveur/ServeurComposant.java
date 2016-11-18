package serveur;

import composant.Composant;
import composant.ComposantAtomique;
import composant.Configuration;

/**
 * Created by naixinwang on 07/11/2016.
 */
public class ServeurComposant extends ComposantAtomique {

    Configuration serveurConfiguration;
    //Receive_request receive_request;
    //Send_result send_result;

    public ServeurComposant(Composant parent) {
        super(parent);
        this.serveurConfiguration = new ServeurConfiguration(this);
        this.addPortFourni(new Send_result(this, "send_result"));
        this.addPortRequis(new Receive_request(this, "receive_request"));
        //receive_request = new Receive_request(this, "receive_request");
        //send_result = new Send_result(this, "send_result");
    }
}
