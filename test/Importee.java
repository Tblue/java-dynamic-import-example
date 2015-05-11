package test;

public class Importee {
    public Importee() {
        System.out.println("Importee main() running...");
    }

    public void doIt() {
        System.out.println("Importee::doIt() called!");
    }
}
