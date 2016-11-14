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

    @Override
    public void send() {
        p_comp.setMessage(p_conf.getMessage());
    }
}
