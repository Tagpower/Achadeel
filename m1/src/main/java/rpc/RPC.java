package rpc;

import composant.Configuration;
import connecteur.Connecteur;

/**
 * Created by clement on 03/11/16.
 */
public class RPC extends Connecteur {

    public RPC(Configuration parent) {
        super(parent);
        /*
        les port sont ajouter au composant et configuration et connecteur quand le binding ou le attachement sont créé

        this.addRoleRequis(new FromClient("c_caller"));
        this.addRoleFourni(new ToClient("c_called"));
        this.addRoleRequis(new FromServer("s_caller"));
        this.addRoleFourni(new ToServer("s_called"));
        */
    }

}
