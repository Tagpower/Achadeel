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

    private List<PortComposantFourni> portFournis;
    private List<PortComposantRequis> portRequis;

    public ComposantAtomique(Composant parent) {
        super(parent);
        this.portFournis = new ArrayList<PortComposantFourni>();
        this.portRequis = new ArrayList<PortComposantRequis>();

    }

    public List<PortComposantFourni> getPortFournis() {
        return portFournis;
    }

    public void setPortFournis(List<PortComposantFourni> portFournis) {
        this.portFournis = portFournis;
    }

    public List<PortComposantRequis> getPortRequis() {
        return portRequis;
    }

    public void setPortRequis(List<PortComposantRequis> portRequis) {
        this.portRequis = portRequis;
    }

    public void addPortFourni(PortComposantFourni portFourni){
        this.portFournis.add(portFourni);
        portFourni.setParent(this);
    }

    public void addPortRequis(PortComposantRequis portRequis){
        this.portRequis.add(portRequis);
        portRequis.setParent(this);
    }
}
