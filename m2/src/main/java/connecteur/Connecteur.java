package connecteur;



import composant.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 17/10/16.
 */
public class Connecteur {

    private Configuration parent;

    private Glue glue;

    public Connecteur(Configuration parent, Glue glue) {
        this.parent = parent;
        this.glue = glue;
    }

    public Configuration getParent() {
        return parent;
    }

    public void setParent(Configuration parent) {
        this.parent = parent;
    }

    public Glue getGlue() {
        return glue;
    }

    public void setGlue(Glue glue) {
        this.glue = glue;
    }
}
