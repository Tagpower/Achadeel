package connecteur;



import composant.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by clement on 17/10/16.
 */
public class Connecteur {

    private Configuration parent;

    private List<RoleFourni> roleFourni;
    private List<RoleRequis> roleRequis;
    private Map<RoleRequis, RoleFourni> glue;

    public Connecteur(Configuration parent) {
        this.parent = parent;
        roleFourni = new ArrayList<RoleFourni>();
        roleRequis = new ArrayList<RoleRequis>();
    }


    public void addGlue(RoleRequis rr, RoleFourni rf){
        this.glue.put(rr, rf);
    }

    public Map<RoleRequis, RoleFourni> getGlue() {
        return glue;
    }

    public void setGlue(Map<RoleRequis, RoleFourni> glue) {
        this.glue = glue;
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

    public void send(){

    }

}
