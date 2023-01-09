import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Racunanje kota snimljenih geometrijskim nivelmanom!");
        Scanner s = new Scanner(System.in);
        ArrayList<String> naziviTacaka = new ArrayList<>();
        ArrayList<Double> citanja = new ArrayList<>();
        ArrayList<Double> kote = new ArrayList<>();

        System.out.println("Unesi podatke za reper ili veznu tacku");
        System.out.println("r/v?");

        String prviUnos = s.next();
        double kotaReper = 0;
        double citanjeReper = 0;
        double citanjeVezna = 0;
        while (!prviUnos.equalsIgnoreCase("q")) {


            switch (prviUnos) {

                case "r":
                    System.out.println("Unesi naziv repera: ");
                    String nazivRepera = prviUnos + s.next();
                    naziviTacaka.add(nazivRepera);
                    System.out.println("Unesi kotu repera: ");
                    kotaReper = s.nextDouble();
                    kote.add(kotaReper);

                    System.out.println("Unesi citanje na letvi na reperu: ");
                    citanjeReper = s.nextDouble();
                    citanja.add(citanjeReper);

                    System.out.println("Da li zelis jos unosa podataka za reper ili veznu tacku? r/v\n" +
                            "Ako ne zelis onda ukucaj 'q'");
                    prviUnos = s.next();
                    break;
                case "v":
                    System.out.println("Unesi naziv vezne tacke: ");
                    String nazivVezne = prviUnos + s.next();
                    naziviTacaka.add(nazivVezne);
                    System.out.println("Uneti citanje na letvi kod vezne tacke: ");
                    citanjeVezna = s.nextDouble();

                    citanja.add(citanjeVezna);

                    System.out.println("Da li zelis jos unosa podataka za reper ili veznu tacku? r/v\n" +
                            "Ako ne zelis onda ukucaj 'q'");
                    prviUnos = s.next();
                    break;


                default:
                    System.out.println("Pogresan unos! Unesi ponovo r/v/q");
                    prviUnos = s.next();
            }
        }
        double visinaVizure2 = 0;
        int j = 0;

        for (int i = 0; i < citanja.size(); i++) {

            if (naziviTacaka.get(i).startsWith("r") && citanja.get(i) > 0) {
                visinaVizure2 = kote.get(j) + citanja.get(i);
                System.out.println("Visina vizure za reper " + naziviTacaka.get(i) + " je " + visinaVizure2);
                j++;
            } else if (visinaVizure2 > 0 && citanja.get(i) > 0) {
                double kotaVezneTacke2 = visinaVizure2 - citanja.get(i);
                System.out.println("Kota vezne tacke br. " + naziviTacaka.get(i) + " je " + kotaVezneTacke2);
            } else {
                System.out.println("Pogresan unos. Prvo je potrebno uneti podatke za reper. Takodje vrednosti citanja na letvi ne smeju biti manja od 0!");
            }

        }
    }
}
