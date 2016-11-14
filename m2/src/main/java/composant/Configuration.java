package composant;

import config.*;
import connecteur.Connecteur;
import connecteur.ConnectionPoint;
import connecteur.RoleFourni;
import connecteur.RoleRequis;
import port.PortComposantFourni;
import port.PortComposantRequis;
import port.PortConfigurationFourni;
import port.PortConfigurationRequis;

import java.util.List;
import java.util.Map;

/**
 * Created by clement on 17/10/16.
 */
public class Configuration extends Composant {

    private List<Composant> composants;
    private List<Connecteur> connecteurs;

    private Map<ConnectionPoint, Attachment> attachments;
    private Map<ConnectionPoint, Binding> bindings;

    private List<PortConfigurationFourni> ports_fournis;
    private List<PortConfigurationRequis> ports_requis;

    public Configuration (Composant parent) {
        super(parent);
    }

    public void addComposant(Composant c) {
        this.composants.add(c);
    }

    public void addConnecteur(Connecteur c) {
        this.connecteurs.add(c);
    }

    public void addPortFourni(PortConfigurationFourni portFourni){
        this.ports_fournis.add(portFourni);
        portFourni.setParent(this);
    }

    public void addPortRequis(PortConfigurationRequis portRequis){
        this.ports_requis.add(portRequis);
        portRequis.setParent(this);
    }

    public void addAttachmentSend(Composant composant, Connecteur connecteur, String nomSend) {
        PortComposantFourni p_Fourni = new PortComposantFourni(composant, nomSend);
        RoleRequis r_Requis = new RoleRequis(connecteur,nomSend);
        composant.addPortsFourni(p_Fourni);
        connecteur.addRoleRequis(r_Requis);
        attachments.put(p_Fourni, new AttachmentPortFourni(this, p_Fourni, r_Requis));
    }

    public void addAttachmentReceive(Composant composant, Connecteur connecteur, String nomReceive){
        PortComposantRequis p_Requis = new PortComposantRequis(composant, nomReceive);
        RoleFourni r_Fourni = new RoleFourni(connecteur,nomReceive);
        composant.addPortRequis(p_Requis);
        connecteur.addRoleFourni(r_Fourni);
        attachments.put(r_Fourni, new AttachmentPortRequis(this, p_Requis, r_Fourni));
    }

    public void addBindingFourni(Composant composant, String nom) {
        PortComposantFourni port_comp = new PortComposantFourni(composant, nom);
        PortConfigurationFourni port_conf = new PortConfigurationFourni(this, nom);
        composant.addPortsFourni(port_comp);
        this.addPortFourni(port_conf);
        bindings.put(port_conf, new BindingFourni(this, port_conf, port_comp));
    }

    public void addBindingRequis(Composant composant, String nom) {
        PortComposantRequis port_comp = new PortComposantRequis(composant, nom);
        PortConfigurationRequis port_conf = new PortConfigurationRequis(this, nom);
        composant.addPortRequis(port_comp);
        this.addPortRequis(port_conf);
        bindings.put(port_comp, new BindingRequis(this, port_conf, port_comp));
    }

    public void sendMessage(PortComposantFourni port, String msg) {

    }


}
