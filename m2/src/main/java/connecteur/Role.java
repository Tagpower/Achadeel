package connecteur;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Role extends ConnectionPoint {
    private Connecteur parent;
    private String nom;

    public Role(Connecteur parent, String nom){
        this.parent = parent;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Connecteur getParent() {
        return parent;
    }

    public void setParent(Connecteur parent) {
        this.parent = parent;
    }
}
