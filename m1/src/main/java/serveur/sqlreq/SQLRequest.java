package serveur.sqlreq;

import composant.Configuration;
import connecteur.Connecteur;

/**
 * Created by clement on 06/11/16.
 */
public class SQLRequest extends Connecteur {

    private Connect_in connect_in;
    private Connect_out connect_out;
    private DB_in db_in;
    private DB_out db_out;

    public SQLRequest(Configuration parent) {
        super(parent);

        this.connect_in = new Connect_in(this, "connection_in");
        this.connect_out = new Connect_out(this, "connection_out");
        this.db_in = new DB_in(this, "database_in");
        this.db_out = new DB_out(this, "database_out");

        this.glue.put(this.connect_in, this.db_out);
        this.glue.put(this.db_in, this.connect_out);

        /*
        this.addRoleRequis(new Connect_in(this,"ConnectionCaller"));
        this.addRoleFourni(new Connect_out(this,"ConnectionCalled"));
        this.addRoleRequis(new DB_in(this, "DateCaller"));
        this.addRoleFourni(new DB_out(this, "Datacalled"));
        */
    }

    public Connect_in getConnect_in() {
        return connect_in;
    }

    public Connect_out getConnect_out() {
        return connect_out;
    }

    public DB_in getDb_in() {
        return db_in;
    }

    public DB_out getDb_out() {
        return db_out;
    }
}
