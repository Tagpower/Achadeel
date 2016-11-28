package rpc;

import composant.Configuration;
import connecteur.Connecteur;

/**
 * Created by clement on 03/11/16.
 */
public class RPC extends Connecteur {

    private FromClient from_client;
    private ToServer to_server;
    private FromServer from_server;
    private ToClient to_client;

    public RPC(Configuration parent) {
        super(parent);

        this.from_client = new FromClient(this, "from_client");
        this.to_server = new ToServer(this, "to_server");
        this.from_server = new FromServer(this, "from_server");
        this.to_client = new ToClient(this, "to_client");

        this.glue.put(from_client, to_server);
        this.glue.put(from_server, to_client);
    }

    public FromClient getFrom_client() {
        return from_client;
    }

    public FromServer getFrom_server() {
        return from_server;
    }

    public ToClient getTo_client() {
        return to_client;
    }

    public ToServer getTo_server() {
        return to_server;
    }




}
