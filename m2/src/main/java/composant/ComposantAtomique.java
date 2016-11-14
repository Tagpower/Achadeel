package composant;

import config.AttachmentPortFourni;
import port.PortComposantFourni;

/**
 * Created by clement on 17/10/16.
 */
public class ComposantAtomique extends Composant {

    //    private List<Propriete> props;
    //    private List<Contrainte> contr;

    private Configuration parent;

    public ComposantAtomique(String name, Configuration parent) {
        super(name);
        this.parent = parent;
    }

    public void sendMessage(PortComposantFourni port, String msg) {
    }

    public Configuration getParent() {
        return parent;
    }

    public void setParent(Configuration parent) {
        this.parent = parent;
    }

    public void send(){

    };

}
