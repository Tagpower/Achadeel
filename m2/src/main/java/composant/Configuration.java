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

    private Composant parent;
    private List<ComposantAtomique> composants;
    private List<Connecteur> connecteurs;

    private Map<String, Attachment> attachments;
    private Map<String, Binding> bindings;

    private List<PortConfigurationFourni> ports_fournis;
    private List<PortConfigurationRequis> ports_requis;

    public Configuration (String name,Composant parent) {
        super(name);
        this.parent = parent;
    }

    public Composant getParent() {
        return parent;
    }

    public void setParent(Composant parent) {
        this.parent = parent;
    }

    public List<ComposantAtomique> getComposants() {
        return composants;
    }

    public List<Connecteur> getConnecteurs() {
        return connecteurs;
    }

    public Map<String, Attachment> getAttachments() {
        return attachments;
    }

    public Map<String, Binding> getBindings() {
        return bindings;
    }

    public List<PortConfigurationFourni> getPorts_fournis() {
        return ports_fournis;
    }

    public List<PortConfigurationRequis> getPorts_requis() {
        return ports_requis;
    }

    public void addComposant(ComposantAtomique c) {
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
        attachments.put(nomSend, new AttachmentPortFourni(this, p_Fourni, r_Requis));
    }

    public void addAttachmentReceive(Composant composant, Connecteur connecteur, String nomReceive){
        PortComposantRequis p_Requis = new PortComposantRequis(composant, nomReceive);
        RoleFourni r_Fourni = new RoleFourni(connecteur,nomReceive);
        composant.addPortRequis(p_Requis);
        connecteur.addRoleFourni(r_Fourni);
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


    public ComposantAtomique getNamedComposants(String nom){
        ComposantAtomique composant = null;
        for(ComposantAtomique ca : this.getComposants()){
            composant = ca;
        }
        return composant;
    }

    public void send(){

    };
    /*
    public void sendMessage(PortComposantFourni port, String msg) {
        //trouver le role relié avec ce port
        //appeler la méthode send() de attachement, envois le msg au connecteur
        this.getAttachments().get(port.getNom()).send(msg);

    }
    */

}
