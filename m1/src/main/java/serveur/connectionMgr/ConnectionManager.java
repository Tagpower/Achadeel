package serveur.connectionMgr;

import composant.Composant;
import composant.ComposantAtomique;

/**
 * Created by clement on 06/11/16.
 */
public class ConnectionManager extends ComposantAtomique {

    private DBQuery_in dbquery_in;
    private DBQuery_out dbquery_out;
    private SecurityCheck_in sec_in;
    private SecurityCheck_out sec_out;
    private ExternalSocket_in external_in;
    private ExternalSocket_out external_out;

    public ConnectionManager(Composant parent) {
        super(parent);

        this.dbquery_in = new DBQuery_in(this, "dbquery_in");
        this.dbquery_out = new DBQuery_out(this, "dbquery_out");
        this.sec_in = new SecurityCheck_in(this, "security_in");
        this.sec_out = new SecurityCheck_out(this, "security_out");
        this.external_in = new ExternalSocket_in(this, "external_in");
        this.external_out = new ExternalSocket_out(this, "external_out");

        /*
        this.addPortRequis(new DBQuery_in(this, "InQuery"));
        this.addPortFourni(new DBQuery_out(this, "OutQuery"));
        this.addPortRequis(new ExternalSocket_in(this, "SocketIn"));
        this.addPortFourni(new Exchange_client_out(this, "SocketOut"));
        this.addPortRequis(new SecurityCheck_in(this, "SecurityCheckIn"));
        this.addPortFourni(new SecurityCheck_out(this, "SecurityCheckOut"));
        */
    }

    public DBQuery_in getDbquery_in() {
        return dbquery_in;
    }

    public void setDbquery_in(DBQuery_in dbquery_in) {
        this.dbquery_in = dbquery_in;
    }

    public DBQuery_out getDbquery_out() {
        return dbquery_out;
    }

    public void setDbquery_out(DBQuery_out dbquery_out) {
        this.dbquery_out = dbquery_out;
    }

    public ExternalSocket_in getExternal_in() {
        return external_in;
    }

    public void setExternal_in(ExternalSocket_in external_in) {
        this.external_in = external_in;
    }

    public ExternalSocket_out getExternal_out() {
        return external_out;
    }

    public void setExternal_out(ExternalSocket_out external_out) {
        this.external_out = external_out;
    }

    public SecurityCheck_in getSec_in() {
        return sec_in;
    }

    public void setSec_in(SecurityCheck_in sec_in) {
        this.sec_in = sec_in;
    }

    public SecurityCheck_out getSec_out() {
        return sec_out;
    }

    public void setSec_out(SecurityCheck_out sec_out) {
        this.sec_out = sec_out;
    }
}
