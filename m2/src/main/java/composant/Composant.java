package composant;

import connecteur.ConnectionPoint;

/**
 * Created by clement on 17/10/16.
 */
public abstract class Composant {

//    private List<Port> portFournis;
//    private List<Port> portRequis;
    private Composant parent;


    public Composant(Composant parent) {
        this.parent = parent;
//        this.portFournis = new ArrayList<Port>();
//        this.portRequis = new ArrayList<Port>();
    }

    public Composant getParent() {
        return parent;
    }

    public void setParent(Composant parent) {
        this.parent = parent;
    }

//    public List<Port> getPortFournis() {
//        return portFournis;
//    }
//
//    public void setPortFournis(List<Port> portFournis) {
//        this.portFournis = portFournis;
//    }
//
//    public List<Port> getPortRequis() {
//        return portRequis;
//    }
//
//    public void setPortRequis(List<Port> portRequis) {
//        this.portRequis = portRequis;
//    }
//
//    public void addPortsFourni(PortComposantFourni portFourni){
//        this.portFournis.add(portFourni);
//        portFourni.setParent(this);
//    }
//
//    public void addPortRequis(PortComposantRequis portRequis){
//        this.portRequis.add(portRequis);
//        portRequis.setParent(this);
//    }

    public void sendMessage(ConnectionPoint cp, String msg) {
        if (this instanceof ComposantAtomique) {
            cp.setMessage(msg);
            System.out.println(this.getClass().getName() + " envoie le message " + msg + " depuis " + cp.getClass().getName());
            parent.sendMessage(cp, msg);
        }
    }


}
