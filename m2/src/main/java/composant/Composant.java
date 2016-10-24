package composant;

import port.PortComposantFourni;
import port.PortComposantRequis;

import java.util.List;

/**
 * Created by clement on 17/10/16.
 */
public /*abstract ?*/ class Composant {

    private List<PortComposantFourni> portFourni;
    private List<PortComposantRequis> portRequis;
    private String nom;


    public List<PortComposantFourni> getPortFourni() {
        return portFourni;
    }

    public void setPortFourni(List<PortComposantFourni> portFourni) {
        this.portFourni = portFourni;
    }

    public List<PortComposantRequis> getPortRequis() {
        return portRequis;
    }

    public void setPortRequis(List<PortComposantRequis> portRequis) {
        this.portRequis = portRequis;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void addPortsFourni(PortComposantFourni portFourni){
        this.portFourni.add(portFourni);
        portFourni.setParent(this);
    }

    public void addPortRequis(PortComposantRequis portRequis){
        this.portRequis.add(portRequis);
        portRequis.setParent(this);
    }
}
