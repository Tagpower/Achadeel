package rpc;

import composant.Configuration;
import connecteur.Connecteur;

/**
 * Created by clement on 03/11/16.
 */
public class RPC extends Connecteur {

    private FromClient c_caller;
    private ToClient c_called;
    private FromServer s_caller;
    private ToServer s_called;

    public RPC(Configuration parent) {
        super(parent);
        this.c_caller = new FromClient("c_caller");
        this.c_called = new ToClient("c_called");
        this.s_caller = new FromServer("s_caller");
        this.s_called = new ToServer("s_called");
    }

}
