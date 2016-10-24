package connecteur;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Role {
    private Connecteur parent;

    public Role(){

    }

    public Connecteur getParent() {
        return parent;
    }

    public void setParent(Connecteur parent) {
        this.parent = parent;
    }
}
