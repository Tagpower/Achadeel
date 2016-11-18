package rpc;

import composant.Configuration;
import connecteur.Connecteur;

/**
 * Created by clement on 03/11/16.
 */
public class RPC extends Connecteur {

    public RPC(Configuration parent) {
        super(parent);

        //les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé

        this.addRoleRequis(new FromClient(this, "from_client"));
        this.addRoleFourni(new ToClient(this, "to_client"));
        this.addRoleRequis(new FromServer(this, "from_server"));
        this.addRoleFourni(new ToServer(this, "to_server"));
    }

}
