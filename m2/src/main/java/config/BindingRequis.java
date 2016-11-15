package config;

import composant.Configuration;
import port.PortComposantRequis;
import port.PortConfigurationRequis;

import java.util.Observable;

/**
 * Created by clement on 17/10/16.
 */
public class BindingRequis extends Binding {

    private PortConfigurationRequis p_conf;
    private PortComposantRequis p_comp;

    public BindingRequis(Configuration parent, PortConfigurationRequis pcf, PortComposantRequis pcp) {
        super(parent);
        p_conf = pcf;
        p_comp = pcp;
    }

    public void transmettre() {
        this.p_conf.setMessage(this.p_comp.getMessage());
    }

    public void update(Observable o, Object arg) {
        this.setChanged();
        this.notifyObservers(arg);
    }

}
