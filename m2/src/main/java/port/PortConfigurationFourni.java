package port;

import composant.Configuration;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by clement on 17/10/16.
 */
public class PortConfigurationFourni extends PortConfiguration implements Observer {

    public PortConfigurationFourni(Configuration parent, String nom) {
        super(parent, nom);
    }

    public void update(Observable observable, Object o) {

    }
}
