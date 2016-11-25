package composant;

import port.PortComposantFourni;
import port.PortComposantRequis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 17/10/16.
 */
public class ComposantAtomique extends Composant {

    //    private List<Propriete> props;
    //    private List<Contrainte> contr;

    private List<PortComposantFourni> portsFournis;
    private List<PortComposantRequis> portsRequis;

    public ComposantAtomique(Composant parent) {
        super(parent);
        this.portsFournis = new ArrayList<PortComposantFourni>();
        this.portsRequis = new ArrayList<PortComposantRequis>();

    }

    public List<PortComposantFourni> getPortsFournis() {
        return portsFournis;
    }

    public void setPortsFournis(List<PortComposantFourni> portsFournis) {
        this.portsFournis = portsFournis;
    }

    public List<PortComposantRequis> getPortsRequis() {
        return portsRequis;
    }

    public void setPortsRequis(List<PortComposantRequis> portsRequis) {
        this.portsRequis = portsRequis;
    }

    public void addPortFourni(PortComposantFourni portFourni){
        this.portsFournis.add(portFourni);
        portFourni.setParent(this);
    }

    public void addPortRequis(PortComposantRequis portRequis){
        this.portsRequis.add(portRequis);
        portRequis.setParent(this);
    }

    public PortComposantFourni getNamedPortFourni(String portName) {
        PortComposantFourni res = null;
        for (PortComposantFourni p : this.portsFournis) {
            if (p.getNom() == portName) {
                res = p;
            }
        }
        return res;
    }

    public PortComposantRequis getNamedPortRequis(String portName) {
        PortComposantRequis res = null;
        for (PortComposantRequis p : this.portsRequis) {
            if (p.getNom() == portName) {
                res = p;
            }
        }
        return res;
    }

    public void sendMessage(PortComposantFourni cp, String msg) {
        cp.setMessage(msg);
        System.out.println(this.getClass().getName() + " envoie le message " + msg + " depuis " + cp.getClass().getName());
        //System.out.println("this.parent = " + this.parent);
        ((Configuration)this.parent).sendMessage(cp, msg);
    }

    public void treatMessage(PortComposantRequis port) {

    }

}
