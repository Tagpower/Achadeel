package config;

import port.PortComposant;
import port.PortConfiguration;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Binding {

    private PortConfiguration p_conf;
    private PortComposant p_comp;

    public Binding(PortConfiguration pcf, PortComposant pcp) {
        p_conf = pcf;
        p_comp = pcp;
    }


}
