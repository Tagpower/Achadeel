package composant;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Composant {

    protected Composant parent;


    public Composant(Composant parent) {
        this.parent = parent;
    }

    public Composant getParent() {
        return parent;
    }

    public void setParent(Composant parent) {
        this.parent = parent;
    }



}
