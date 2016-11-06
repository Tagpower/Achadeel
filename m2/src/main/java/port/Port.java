package port;

import composant.Composant;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Port extends Observable {
    private String nom;
    private Composant parent;
    private List<Service> services;

    public Port(String nom){
        this.nom = nom;
        this.services = new ArrayList<Service>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Composant getParent() {
        return parent;
    }

    public void setParent(Composant parent) {
        this.parent = parent;
    }

    public void addService(Service s) {
        this.services.add(s);
    }

    public List<Service> getServices() {
        return services;
    }

}
