// NB: No need to import the class; using the fully
//     qualified name works as well.
import test.Importee;

public class ImportTest {
    private static Importee importee;

    public static void main(String[] args) {
        System.out.println("I can run! Wheee!");

        if(args.length >= 1 && args[0].toLowerCase().equals("true")) {
            importee = new Importee();
            importee.doIt();
        }
    }
}
