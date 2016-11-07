package connecteur;

import java.util.Observable;

/**
 * Created by clement on 17/10/16.
 */
public class RoleFourni extends Role {
    public RoleFourni(Connecteur parent,String nom) {
        super(parent, nom);
    }

    public void update(Observable o, Object obj) {
        System.out.println(this.getClass().getName()+".update");
        this.setChanged();
        this.notifyObservers(obj);
    }
}
