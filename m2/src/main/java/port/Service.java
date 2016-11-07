package port;

/**
 * Created by clement on 03/11/16.
 */
public abstract class Service {

    private String nom;

    public Service(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}