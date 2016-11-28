package composant;

import config.*;
import connecteur.*;
import port.*;

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

    public void attachPortFourni(PortComposantFourni port, RoleRequis role) {
        attachments.put(port, new AttachmentPortFourni(this, port, role));
    }

    public void attachRoleFourni(PortComposantRequis port, RoleFourni role) {
        attachments.put(role, new AttachmentPortRequis(this, port, role));
    }

    public void bindFourni(PortConfigurationFourni pconf, PortComposantFourni pcomp) {
        bindings.put(pcomp, new BindingFourni(this, pconf, pcomp));
    }

    public void bindRequis(PortConfigurationRequis pconf, PortComposantRequis pcomp) {
        bindings.put(pconf, new BindingRequis(this, pconf, pcomp));
    }

    public void sendMessage(PortComposantFourni port, String msg) {
        if (attachments.get(port) != null) {
            attachments.get(port).transmettre();
            ((AttachmentPortFourni)attachments.get(port)).getRole().getParent().processGlue((RoleRequis) attachments.get(port).getRole());
        }
        if (bindings.get(port) != null) {
            bindings.get(port).transmettre();
            PortConfigurationFourni portbind = ((BindingFourni) bindings.get(port)).getP_conf();
            portbind.getParent().sendMessage(portbind, msg);
                    //((BindingFourni) bindings.get(port)).getP_conf().getParent().sendMessage(((BindingFourni) bindings.get(port)).getP_conf(), );
        }
    }

    public void sendMessage(RoleFourni role, String msg) {
        attachments.get(role).transmettre();
        ComposantAtomique comp = (ComposantAtomique)((AttachmentPortRequis)attachments.get(role)).getPort().getParent();
        //System.out.println("comp = " + comp.toString());
        comp.treatMessage((PortComposantRequis)attachments.get(role).getPort());
        //           ((ComposantAtomique)((AttachmentPortRequis)attachments.get(c)).getPort().getParent()).treatMessage(((AttachmentPortRequis) attachments.get(c)).getPort());

    }

    public void sendMessage(PortConfigurationRequis port, String msg) {
        //System.out.println("port = " + port.toString());
        port.setMessage(msg);
        //System.out.println("binding = " + bindings.get(port).toString());
        bindings.get(port).transmettre();
        //System.out.println("pconf = " + ((BindingRequis) bindings.get(port)).getP_conf());
        //System.out.println("pcomp = " + ((BindingRequis) bindings.get(port)).getP_comp());
        ComposantAtomique comp = (ComposantAtomique)((BindingRequis)bindings.get(port)).getP_comp().getParent();
        //System.out.println("comp = " + comp);
        comp.treatMessage(((BindingRequis) bindings.get(port)).getP_comp());
        //((BindingFourni)bindings.get(c)).getP_comp().getParent().
    }

    public void sendMessage(PortConfigurationFourni port, String msg) {
        Composant cc = port.getParent().getParent();
        if (cc != null) {
            System.out.println("cc = " + cc);
        }
    }

    //DEBUG
    public void printAttachments() {
        for (ConnectionPoint c : attachments.keySet()) {
            System.out.println(attachments.get(c).toString());
        }
    }

    //DEBUG
    public void printBindings() {
        for (ConnectionPoint c : bindings.keySet()) {
            System.out.println(bindings.get(c).toString());
        }
    }

    public void treatMessage(PortConfigurationFourni port) {
        
    }

}
