package V1;

public abstract class Medien {
    private String titel;
    private int jahr;
    private double preis;

    public Medien(String titel, int jahr, double preis) {
        this.titel = titel;
        this.jahr = jahr;
        this.preis = preis;
    }

    public String getTitel() {
        return titel;
    }

    public int getJahr() {
        return jahr;
    }

    public double getPreis() {
        return preis;
    }

    @Override
    public String toString() {
        return "Titel: " + titel + ", Jahr: " + jahr + ", Preis: " + preis + " CHF";
    }
}

