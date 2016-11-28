package connecteur;

/**
 * Created by clement on 17/10/16.
 */
public class RoleFourni extends Role {
    public RoleFourni(Connecteur parent,String nom) {
        super(parent, nom);
        parent.addRoleFourni(this);
    }

}
