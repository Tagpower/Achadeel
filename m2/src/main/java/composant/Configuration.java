package composant;

import config.Attachment;
import config.Binding;
import connecteur.Connecteur;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by clement on 17/10/16.
 */
public class Configuration extends Composant {

    private List<Composant> composants;
    private List<Connecteur> connecteurs;

    private Map<String, Attachment> attachments;
    private Map<String, Binding> bindings;

    public Configuration (String nom, ArrayList<Composant> comps) {
        super.setNom(nom);
        composants = comps;

    }

    public void addComposant(Composant c) {
        this.composants.add(c);
    }


}
