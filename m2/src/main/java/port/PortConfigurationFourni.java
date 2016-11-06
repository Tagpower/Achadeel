package port;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by clement on 17/10/16.
 */
public class PortConfigurationFourni extends PortConfiguration implements Observer {

    public PortConfigurationFourni(String nom) {
        super(nom);
    }

    public void update(Observable observable, Object o) {

    }

    public void addService(ServiceFourni service) {
        super.addService(service);
    }

}
