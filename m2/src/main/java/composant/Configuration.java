package composant;

import config.*;
import connecteur.Connecteur;
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

    private Map<String, Attachment> attachments;
    private Map<String, Binding> bindings;

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

    public void addAttachmentSend(Composant composant, Connecteur conneteur, String nomSend) {
        PortComposantFourni p_Fourni = new PortComposantFourni(composant, nomSend);
        RoleRequis r_Requis = new RoleRequis(conneteur,nomSend);
        composant.addPortsFourni(p_Fourni);
        conneteur.addRoleRequis(r_Requis);
        attachments.put(nomSend, new AttachmentPortFourni(this, p_Fourni, r_Requis));
    }

    public void addAttachmentReceive(Composant composant, Connecteur conneteur, String nomReceive){
        PortComposantRequis p_Requis = new PortComposantRequis(composant, nomReceive);
        RoleFourni r_Fourni = new RoleFourni(conneteur,nomReceive);
        composant.addPortRequis(p_Requis);
        conneteur.addRoleFourni(r_Fourni);
        attachments.put(nomReceive, new AttachmentPortRequis(this, p_Requis, r_Fourni));
    }

    public void addBindingFourni(Composant composant, String nom) {
        PortComposantFourni port_comp = new PortComposantFourni(composant, nom);
        PortConfigurationFourni port_conf = new PortConfigurationFourni(this, nom);
        composant.addPortsFourni(port_comp);
        this.addPortFourni(port_conf);
        bindings.put(nom, new BindingFourni(this, port_conf, port_comp));
    }

    public void addBindingRequis(Composant composant, String nom) {
        PortComposantRequis port_comp = new PortComposantRequis(composant, nom);
        PortConfigurationRequis port_conf = new PortConfigurationRequis(this, nom);
        composant.addPortRequis(port_comp);
        this.addPortRequis(port_conf);
        bindings.put(nom, new BindingRequis(this, port_conf, port_comp));
    }

}
