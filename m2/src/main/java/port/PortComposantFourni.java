package port;

import composant.Composant;

/**
 * Created by clement on 17/10/16.
 */
public class PortComposantFourni extends PortComposant {

    public PortComposantFourni(Composant parent, String nom){
        super(parent, nom);
    }

//    public void diffuse(Object obj) {
//        System.out.println(this.getClass().getName()+".diffuse");
//        this.setChanged();
//        this.notifyObservers(obj);
//    }

    @Override
    public void emitMessage(String msg) {
        System.out.println(this.getClass().getName() + msg);
        this.getParent().sendMessage(this, msg);
    }

}
