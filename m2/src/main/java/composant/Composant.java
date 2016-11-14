package composant;

import port.Port;
import port.PortComposantFourni;
import port.PortComposantRequis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Composant {

    private List<Port> portFourni;
    private List<Port> portRequis;
    private Composant parent;


    public Composant(Composant parent) {
        this.parent = parent;
        this.portFourni = new ArrayList<Port>();
        this.portRequis = new ArrayList<Port>();
    }

    public Composant getParent() {
        return parent;
    }

    public void setParent(Composant parent) {
        this.parent = parent;
    }

    public List<Port> getPortFourni() {
        return portFourni;
    }

    public void setPortFourni(List<Port> portFourni) {
        this.portFourni = portFourni;
    }

    public List<Port> getPortRequis() {
        return portRequis;
    }

    public void setPortRequis(List<Port> portRequis) {
        this.portRequis = portRequis;
    }

    public void addPortsFourni(PortComposantFourni portFourni){
        this.portFourni.add(portFourni);
        portFourni.setParent(this);
    }

    public void addPortRequis(PortComposantRequis portRequis){
        this.portRequis.add(portRequis);
        portRequis.setParent(this);
    }

    public void sendMessage(PortComposantFourni port, String msg) {
        if (this instanceof ComposantAtomique) {
            parent.sendMessage(port, msg);
        }
    }


}
