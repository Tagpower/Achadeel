package config;

import composant.Composant;
import port.PortComposantFourni;
import port.PortConfigurationFourni;

import java.util.Observable;

/**
 * Created by clement on 17/10/16.
 */
public class BindingFourni extends Binding {

    private PortConfigurationFourni p_conf;
    private PortComposantFourni p_comp;

    public BindingFourni(Composant parent, PortConfigurationFourni pcf, PortComposantFourni pcp) {
        super(parent);
        p_conf = pcf;
        p_comp = pcp;
    }

    public void update(Observable o, Object arg) {
        this.setChanged();
        this.notifyObservers(arg);
    }


}
