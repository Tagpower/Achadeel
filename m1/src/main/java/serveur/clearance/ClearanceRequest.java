package serveur.clearance;

import composant.Configuration;
import connecteur.Connecteur;
/**
 * Created by clement on 06/11/16.
 */
public class ClearanceRequest extends Connecteur {

    private Connect_in connect_in;
    private Connect_out connect_out;
    private Sec_out sec_out;
    private Sec_in sec_in;

    public ClearanceRequest(Configuration parent) {
        super(parent);

        this.connect_in = new Connect_in(this,"connect_caller");
        this.connect_out = new Connect_out(this,"connect_called");
        this.sec_out = new Sec_out(this, "sec_called");
        this.sec_in = new Sec_in(this, "sec_caller");

    }

    public Connect_out getConnect_out() {
        return connect_out;
    }

    public void setConnect_out(Connect_out connect_out) {
        this.connect_out = connect_out;
    }

    public Connect_in getConnect_in() {
        return connect_in;
    }

    public void setConnect_in(Connect_in connect_in) {
        this.connect_in = connect_in;
    }

    public Sec_in getSec_in() {
        return sec_in;
    }

    public void setSec_in(Sec_in sec_in) {
        this.sec_in = sec_in;
    }

    public Sec_out getSec_out() {
        return sec_out;
    }

    public void setSec_out(Sec_out sec_out) {
        this.sec_out = sec_out;
    }
}
