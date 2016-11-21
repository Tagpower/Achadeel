package composant;

import config.*;
import connecteur.*;
import port.PortComposantFourni;
import port.PortComposantRequis;
import port.PortConfigurationFourni;
import port.PortConfigurationRequis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by clement on 17/10/16.
 */
public class Configuration extends Composant {

    private List<Composant> composants;
    private List<Connecteur> connecteurs;

    protected Map<ConnectionPoint, Attachment> attachments;
    protected Map<ConnectionPoint, Binding> bindings;

    private List<PortConfigurationFourni> portFournis;
    private List<PortConfigurationRequis> portRequis;

    public Configuration (Composant parent) {
        super(parent);

        composants = new ArrayList<Composant>();
        connecteurs = new ArrayList<Connecteur>();
        attachments = new HashMap<ConnectionPoint, Attachment>();
        bindings = new HashMap<ConnectionPoint, Binding>();
        portFournis = new ArrayList<PortConfigurationFourni>();
        portRequis = new ArrayList<PortConfigurationRequis>();

    }

    public Map<ConnectionPoint, Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<ConnectionPoint, Attachment> attachments) {
        this.attachments = attachments;
    }

    public Map<ConnectionPoint, Binding> getBindings() {
        return bindings;
    }

    public void setBindings(Map<ConnectionPoint, Binding> bindings) {
        this.bindings = bindings;
    }

    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }

    public List<Connecteur> getConnecteurs() {
        return connecteurs;
    }

    public void setConnecteurs(List<Connecteur> connecteurs) {
        this.connecteurs = connecteurs;
    }

    public List<PortConfigurationFourni> getPortsFournis() {
        return portFournis;
    }

    public void setPortsFournis(List<PortConfigurationFourni> ports_fournis) {
        this.portFournis = ports_fournis;
    }

    public List<PortConfigurationRequis> getPortsRequis() {
        return portRequis;
    }

    public void setPortsRequis(List<PortConfigurationRequis> ports_requis) {
        this.portRequis = ports_requis;
    }

    public void addComposant(Composant c) {
        this.composants.add(c);
    }

    public void addConnecteur(Connecteur c) {
        this.connecteurs.add(c);
    }

    public void addPortFourni(PortConfigurationFourni portFourni){
        this.portFournis.add(portFourni);
        portFourni.setParent(this);
    }

    public void addPortRequis(PortConfigurationRequis portRequis){
        this.portRequis.add(portRequis);
        portRequis.setParent(this);
    }

    /*
    public void addAttachmentSend(ComposantAtomique composant, Connecteur connecteur, String nomSend) {
        PortComposantFourni p_Fourni = new PortComposantFourni(composant, nomSend);
        RoleRequis r_Requis = new RoleRequis(connecteur,nomSend);
        composant.addPortFourni(p_Fourni);
        connecteur.addRoleRequis(r_Requis);
        attachments.put(p_Fourni, new AttachmentPortFourni(this, p_Fourni, r_Requis));
    }

    public void addAttachmentReceive(ComposantAtomique composant, Connecteur connecteur, String nomReceive){
        PortComposantRequis p_Requis = new PortComposantRequis(composant, nomReceive);
        RoleFourni r_Fourni = new RoleFourni(connecteur,nomReceive);
        composant.addPortRequis(p_Requis);
        connecteur.addRoleFourni(r_Fourni);
        attachments.put(r_Fourni, new AttachmentPortRequis(this, p_Requis, r_Fourni));
    }

    public void addBindingFourni(ComposantAtomique composant, String nom) {
        PortComposantFourni port_comp = new PortComposantFourni(composant, nom);
        PortConfigurationFourni port_conf = new PortConfigurationFourni(this, nom);
        composant.addPortFourni(port_comp);
        this.addPortFourni(port_conf);
        bindings.put(port_conf, new BindingFourni(this, port_conf, port_comp));
    }

    public void addBindingRequis(ComposantAtomique composant, String nom) {
        PortComposantRequis port_comp = new PortComposantRequis(composant, nom);
        PortConfigurationRequis port_conf = new PortConfigurationRequis(this, nom);
        composant.addPortRequis(port_comp);
        this.addPortRequis(port_conf);
        bindings.put(port_comp, new BindingRequis(this, port_conf, port_comp));
    }
    */

    public void attachPortFourni(PortComposantFourni port, RoleRequis role) {
        attachments.put(port, new AttachmentPortFourni(this, port, role));
    }

    public void attachRoleFourni(PortComposantRequis port, RoleFourni role) {
        attachments.put(role, new AttachmentPortRequis(this, port, role));
    }

    public void bindFourni(PortConfigurationFourni pconf, PortComposantFourni pcomp) {
        bindings.put(pconf, new BindingFourni(this, pconf, pcomp));
    }

    public void bindRequis(PortConfigurationRequis pconf, PortComposantRequis pcomp) {
        bindings.put(pconf, new BindingRequis(this, pconf, pcomp));
    }

    public void sendMessage(ConnectionPoint c, String msg) {
        System.out.println("att = " + attachments.get(c));
        attachments.get(c).transmettre();
        System.out.println("test " + msg);
        if (c.getParent() instanceof ComposantAtomique) { //Si c'est un port d'un composant qui envoie
            ((AttachmentPortFourni)attachments.get(c)).getRole().getParent().processGlue((RoleRequis)attachments.get(c).getRole());
        } else if (c.getParent() instanceof Connecteur) { //Si c'est un rôle d'un connecteur
            Composant comp = ((AttachmentPortRequis)attachments.get(c)).getPort().getParent();
            System.out.println("comp = " + comp.toString());
        }

    }

    //DEBUG
    public void printAttachments() {
        for (ConnectionPoint c : attachments.keySet()) {
            System.out.println(attachments.get(c).toString());
        }
    }

}
