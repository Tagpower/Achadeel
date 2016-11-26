package serveur.secquery;

import composant.Configuration;
import connecteur.Connecteur;

/**
 * Created by clement on 06/11/16.
 */
public class SecurityQuery extends Connecteur {

    private DB_in db_in;
    private DB_out db_out;
    private Sec_in sec_in;
    private Sec_out sec_out;

    public SecurityQuery(Configuration parent) {
        super(parent);

        this.db_in = new DB_in(this, "DB_in");
        this.db_out = new DB_out(this, "DB_out");
        this.sec_in = new Sec_in(this, "security_in");
        this.sec_out = new Sec_out(this, "security_out");

        this.glue.put(this.db_in, this.sec_out);
        this.glue.put(this.sec_in, this.db_out);

        /*
        this.addRoleRequis(new DB_caller(this,"DataCaller"));
        this.addRoleFourni(new DB_called(this, "DataCalled"));
        this.addRoleRequis(new Sec_caller(this, "SecurityCaller"));
        this.addRoleFourni(new Sec_called(this, "SecurityCalled"));
        */
    }

    public DB_out getDb_out() {
        return db_out;
    }

    public DB_in getDb_in() {
        return db_in;
    }

    public Sec_out getSec_out() {
        return sec_out;
    }

    public Sec_in getSec_in() {
        return sec_in;
    }
}
