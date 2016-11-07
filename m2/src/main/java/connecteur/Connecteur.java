package connecteur;



import composant.Configuration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 17/10/16.
 */
public class Connecteur {

    private Configuration parent;

    private List<RoleFourni> roleFourni;
    private List<RoleRequis> roleRequis;

    public Connecteur(Configuration parent) {
        this.parent = parent;
        roleFourni = new ArrayList<RoleFourni>();
        roleRequis = new ArrayList<RoleRequis>();
    }

    public Configuration getParent() {
        return parent;
    }

    public void setParent(Configuration parent) {
        this.parent = parent;
    }

    public void addRoleFourni(RoleFourni r) {
        roleFourni.add(r);
    }

    public void addRoleRequis(RoleRequis r) {
        roleRequis.add(r);
    }

}
