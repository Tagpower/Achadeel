/**
 * Created by clement on 17/10/16.
 */
public class ComposantAtomique extends Composant {

    //    private List<Propriete> props;
    //    private List<Contrainte> contr;
    private InterfaceComposantRequis i_requis;
    private InterfaceComposantFourni i_fourni;
    private String nom;

    public ComposantAtomique(String nom, InterfaceComposantRequis requis, InterfaceComposantFourni fourni) {
        this.nom = nom;
        i_requis = requis;
        i_fourni = fourni;
    }



    public InterfaceComposantFourni getI_fourni() {
        return i_fourni;
    }

    public void setI_fourni(InterfaceComposantFourni i_fourni) {
        this.i_fourni = i_fourni;
    }

    public InterfaceComposantRequis getI_requis() {
        return i_requis;
    }

    public void setI_requis(InterfaceComposantRequis i_requis) {
        this.i_requis = i_requis;
    }




}
