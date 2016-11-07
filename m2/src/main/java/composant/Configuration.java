package composant;

import config.Attachment;
import config.AttachmentPortFourni;
import config.AttachmentPortRequis;
import config.Binding;
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

    public Configuration (String nom) {
        super(nom);
    }

    public void addComposant(Composant c) {
        this.composants.add(c);
    }

    public void addConnecteur(Connecteur c) { this.connecteurs.add(c);}

    public void addAttachmentSend(Composant composant, Connecteur conneteur, String nomSend) {
        PortComposantFourni p_Fourni = new PortComposantFourni(composant, nomSend);
        RoleRequis r_Requis = new RoleRequis(nomSend);
        composant.addPortsFourni(p_Fourni);
        conneteur.getGlue().addRoleRequis(r_Requis);
        attachments.put(nomSend, new AttachmentPortFourni(p_Fourni, r_Requis));
    }

    public void addAttachmentReceive(Composant composant, Connecteur conneteur, String nomReceive){
        PortComposantRequis p_Requis = new PortComposantRequis(composant, nomReceive);
        RoleFourni r_Fourni = new RoleFourni(nomReceive);
        composant.addPortRequis(p_Requis);
        conneteur.getGlue().addRoleFourni(r_Fourni);
        attachments.put(nomReceive, new AttachmentPortRequis(p_Requis, r_Fourni));
    }

}
