package V1;

public class DVD extends Medien {
    private String filmLaenge;

    public DVD(String titel, int jahr, double preis, String filmLaenge) {
        super(titel, jahr, preis);
        this.filmLaenge = filmLaenge;
    }

    @Override
    public String toString() {
        return super.toString() + ", Filmlänge: " + filmLaenge;
    }
}

