package port;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Port {
    private String nom;

    public Port(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
