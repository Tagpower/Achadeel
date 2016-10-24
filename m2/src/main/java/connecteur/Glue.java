package connecteur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 17/10/16.
 */
public class Glue {

    private List<Role> roles;

    public Glue() {
        roles = new ArrayList<Role>();
    }

    public void addRole(Role r) {
        roles.add(r);
    };

}
