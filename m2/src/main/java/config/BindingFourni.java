package config;

import composant.Configuration;
import port.PortComposantFourni;
import port.PortConfigurationFourni;

import java.util.Observable;

/**
 * Created by clement on 17/10/16.
 */
public class BindingFourni extends Binding {

    private PortConfigurationFourni p_conf;
    private PortComposantFourni p_comp;

    public BindingFourni(Configuration parent, PortConfigurationFourni pcf, PortComposantFourni pcp) {
        super(parent);
        p_conf = pcf;
        p_comp = pcp;
    }

    @Override
    public void send() {
        p_conf.setMessage(p_comp.getMessage());
    }
}
