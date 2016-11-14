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

    private String name;
    private List<Port> portFourni;
    private List<Port> portRequis;


    public Composant(String name) {
        this.name = name;
        this.portFourni = new ArrayList<Port>();
        this.portRequis = new ArrayList<Port>();
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

    public Port getNamedPortRequis(String nameOfPort) {
        Port port = null;
        for (Port p : this.getPortRequis()) {
            if(p.getNom() == nameOfPort) {
                return port = p;
            }
        }
        return port;
    }

    public Port getNamedPortFourni(String nameOfPort) {
        Port port = null;
        for (Port p : this.getPortFourni()) {
            if(p.getNom() == nameOfPort) {
                return port = p;
            }
        }
        return port;
    }

    //méthode suivant quant le composant a recu un msg
    public void send(){
        //analyse ce qu'on va fait après
    };
}
