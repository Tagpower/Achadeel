package port;

import java.util.Observable;

/**
 * Created by clement on 17/10/16.
 */
public class PortComposantRequis extends PortComposant {

    public PortComposantRequis(String nom) {
        super(nom);
    }

    public void update(Observable o, Object arg) {
        System.out.println(this.getClass().getName()+".update");
        for(Service s : this.getServices()) {
            s.performAction(arg);
        }
    }

    public void addService(ServiceRequis s) {
        super.addService(s);
    }


}
