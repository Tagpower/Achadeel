package port;

/**
 * Created by clement on 17/10/16.
 */
public class PortComposantFourni extends PortComposant {

    public PortComposantFourni(String nom){
        super(nom);
    }

    public void diffuse(Object obj) {
        System.out.println(this.getClass().getName()+".diffuse");
        this.setChanged();
        this.notifyObservers(obj);
    }

    public void addService(ServiceFourni service) {
        super.addService(service);
    }

}
