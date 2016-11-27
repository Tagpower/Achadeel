/**
 * Created by clement on 07/11/16.
 */
public class AppM1 {

    public static void main(String args[]) {
        System.out.println("test M1");
        ClientServeur cs = new ClientServeur("cs");

        cs.start("hello");
        //cs.start("bonjour");
        //Scanner sc = new Scanner(System.in);
        //cs.start(sc.nextLine());
    }

}
