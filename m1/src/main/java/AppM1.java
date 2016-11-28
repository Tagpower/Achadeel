/**
 * Created by clement on 07/11/16.
 */
public class AppM1 {

    public static void main(String args[]) {
        System.out.println("test M1");
        ClientServeur cs = new ClientServeur("cs");

        cs.start("hello requete2");
        //cs.start("bonjour requete1");
        //Scanner sc = new Scanner(System.in);
        //cs.start(sc.nextLine());
    }

}
