import client.Client;
import composant.Configuration;

/**
 * Created by clement on 01/11/16.
 */
public class ClientServeur extends Configuration {

    public ClientServeur(String nom) {
        super(null);
        this.addComposant(new Client());

    }


}
