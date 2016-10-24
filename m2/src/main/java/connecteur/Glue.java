package connecteur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 17/10/16.
 */
public class Glue {

    //private List<Role> roles;
    private List<RoleFourni> roleFourni;
    private List<RoleRequis> roleRequis;

    public Glue() {
        roleFourni = new ArrayList<RoleFourni>();
        roleRequis = new ArrayList<RoleRequis>();
    }

    public void addRoleFourni(RoleFourni r) {
        roleFourni.add(r);
    }

    public void addRoleRequis(RoleRequis r) {
        roleRequis.add(r);
    }

}
