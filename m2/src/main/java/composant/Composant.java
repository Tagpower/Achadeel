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
    private String nom;

    public Composant(String nom) {
        this.nom = nom;
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
