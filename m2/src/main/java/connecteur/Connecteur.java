package connecteur;

import config.Configuration;

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
}
