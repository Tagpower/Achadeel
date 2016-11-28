/**
 * Created by clement on 07/11/16.
 */
public class AppM1 {

    public static void main(String args[]) {
        System.out.println("test M1");
        ClientServeur cs = new ClientServeur("cs");

        cs.start("hello requete1");  //marche
        //cs.start("bonjour requete1"); //ne marche pas : "bonjour" n'est pas un utilisateur autorisé
        //cs.start("hello blabla");   //ne marche pas : "blabla" n'est pas une requête valide

        //Scanner sc = new Scanner(System.in);
        //cs.start(sc.nextLine());
    }

}
