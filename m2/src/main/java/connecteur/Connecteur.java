package connecteur;



import composant.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 17/10/16.
 */
public class Connecteur {

    private Configuration parent;

    private List<RoleFourni> rolesFournis;
    private List<RoleRequis> rolesRequis;

    public Connecteur(Configuration parent) {
        this.parent = parent;
        rolesFournis = new ArrayList<RoleFourni>();
        rolesRequis = new ArrayList<RoleRequis>();
    }

    public Configuration getParent() {
        return parent;
    }

    public void setParent(Configuration parent) {
        this.parent = parent;
    }

    public void addRoleFourni(RoleFourni r) {
        rolesFournis.add(r);
    }

    public void addRoleRequis(RoleRequis r) {
        rolesRequis.add(r);
    }

    public RoleFourni getNamedRoleFourni(String roleName) {
        RoleFourni res = null;
        for (RoleFourni r : this.rolesFournis) {
            if (r.getNom() == roleName) {
                res = r;
            }
        }
        return res;
    }

    public RoleRequis getNamedRoleRequis(String roleName) {
        RoleRequis res = null;
        for (RoleRequis r : this.rolesRequis) {
            if (r.getNom() == roleName) {
                res = r;
            }
        }
        return res;
    }

}
