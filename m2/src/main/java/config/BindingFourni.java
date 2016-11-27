package config;

import composant.Configuration;
import port.PortComposantFourni;
import port.PortConfigurationFourni;

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

    //DEBUG
    public String toString() {
        return p_comp.getParent().getClass().getSimpleName()+"."+p_comp.getNom() + " -> " + p_conf.getParent().getClass().getSimpleName()+"." + p_conf.getNom();
    }

    public void transmettre() {
        this.p_conf.setMessage(this.p_comp.getMessage());
    }

    public PortComposantFourni getP_comp() {
        return p_comp;
    }


    public PortConfigurationFourni getP_conf() {
        return p_conf;
    }


}
