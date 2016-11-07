package port;

import composant.Composant;

import java.util.Observable;

/**
 * Created by clement on 17/10/16.
 */
public class PortComposantRequis extends PortComposant {

    public PortComposantRequis(Composant parent, String nom) {
        super(parent, nom);
    }

    public void update(Observable o, Object arg) {
        System.out.println(this.getClass().getName() + ".update");

    }

}
