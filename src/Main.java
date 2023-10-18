import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Film {
    private String nazevFilmu;
    private String pristupnost;
    private String reziser;
    private boolean podpora3D;

    public Film(String nazevFilmu, String pristupnost, String reziser, boolean podpora3D) {
        this.nazevFilmu = nazevFilmu;
        this.pristupnost = pristupnost;
        this.reziser = reziser;
        this.podpora3D = podpora3D;
    }

    public String getNazevFilmu() {
        return nazevFilmu;
    }

    public String getPristupnost() {
        return pristupnost;
    }

    public String getReziser() {
        return reziser;
    }

    public boolean isPodpora3D() {
        return podpora3D;
    }
}

class KinoSal {
    private int cisloSalu;
    private int pocetRad;
    private int pocetKreselVRade;
    private List<Film> filmy;
    private boolean podpora3D;

    public KinoSal(int cisloSalu, int pocetRad, int pocetKreselVRade, boolean podpora3D) {
        this.cisloSalu = cisloSalu;
        this.pocetRad = pocetRad;
        this.pocetKreselVRade = pocetKreselVRade;
        this.filmy = new ArrayList<>();
        this.podpora3D = podpora3D;
    }

    public int getCisloSalu() {
        return cisloSalu;
    }

    public int getPocetRad() {
        return pocetRad;
    }

    public int getPocetKreselVRade() {
        return pocetKreselVRade;
    }

    public List<Film> getFilmy() {
        return filmy;
    }

    public boolean isPodpora3D() {
        return podpora3D;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Film film1 = new Film("Matrix", "PG-13", "Wachowski Brothers", true);
        Film film2 = new Film("Jurassic Park", "PG-13", "Steven Spielberg", false);
        Film film3 = new Film("Inception", "PG-13", "Christopher Nolan", true);

        KinoSal sala1 = new KinoSal(1, 10, 10, true);
        KinoSal sala2 = new KinoSal(2, 8, 12, false);

        sala1.getFilmy().add(film1);
        sala1.getFilmy().add(film2);
        sala1.getFilmy().add(film3);

        sala2.getFilmy().add(film2);
        sala2.getFilmy().add(film3);

        System.out.println("Dostupné filmy:");
        for (Film film : sala1.getFilmy()) {
            System.out.println(film.getNazevFilmu());
        }

        System.out.print("Vyberte si film: ");
        String vybranyFilm = scanner.nextLine();


        System.out.print("Vyberte si sál: ");
        int vybranySal = scanner.nextInt();


        System.out.println("Rozložení křesel:");
        for (int rada = 1; rada <= sala1.getPocetRad(); rada++) {
            for (int kreslo = 1; kreslo <= sala1.getPocetKreselVRade(); kreslo++) {
                System.out.print((char) ('A' + rada - 1) + "" + kreslo + " ");
            }
            System.out.println();
        }

        System.out.print("Vyberte si křeslo (např. A1): ");
        String vybraneKreslo = scanner.next();


        System.out.println("Rezervace potvrzena pro film " + vybranyFilm + ", sál " + vybranySal + ", křeslo " + vybraneKreslo);

    }
}
