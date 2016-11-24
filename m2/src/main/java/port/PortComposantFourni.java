package port;

import composant.Composant;

/**
 * Created by clement on 17/10/16.
 */
public class PortComposantFourni extends PortComposant {

    public PortComposantFourni(Composant parent, String nom){
        super(parent, nom);
    }


//    @Override
//    public void emitMessage(String msg) {
//        System.out.println(this.getClass().getName() + msg);
//        this.getParent().sendMessage(this, msg);
//    }

}
