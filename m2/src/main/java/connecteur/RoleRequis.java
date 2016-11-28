package connecteur;

/**
 * Created by clement on 17/10/16.
 */
public class RoleRequis extends Role {
    public RoleRequis(Connecteur parent, String nom) {
        super(parent, nom);
        parent.addRoleRequis(this);
    }

}
