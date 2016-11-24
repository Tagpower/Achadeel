package connecteur;

/**
 * Created by clement on 14/11/16.
 */
public abstract class ConnectionPoint {

    protected String nom;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
