package config;

import composant.Configuration;
import port.PortComposantRequis;
import port.PortConfigurationRequis;

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

    //DEBUG
    public String toString() {
        return this.p_conf.getParent().getClass().getSimpleName()+"."+this.p_conf.getNom() + " -> " + this.p_comp.getParent().getClass().getSimpleName()+"." + this.p_comp.getNom();
    }

    public void transmettre() {
        this.p_comp.setMessage(this.p_conf.getMessage());
    }

    public PortComposantRequis getP_comp() {
        return p_comp;
    }


    public PortConfigurationRequis getP_conf() {
        return p_conf;
    }

}
