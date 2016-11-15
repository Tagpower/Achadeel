package serveur;

import composant.Composant;
import composant.ComposantAtomique;
import composant.Configuration;

/**
 * Created by naixinwang on 07/11/2016.
 */
public class ServeurComposant extends ComposantAtomique {

    Configuration serveurConfiguration;

    public ServeurComposant(Composant parent) {
        super(parent);
        this.serveurConfiguration = new ServeurConfiguration(this);
    }
}
