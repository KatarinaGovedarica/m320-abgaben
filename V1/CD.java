package V1;

public class CD extends Medien {
    private String bandName;

    public CD(String titel, int jahr, double preis, String bandName) {
        super(titel, jahr, preis);
        this.bandName = bandName;
    }

    @Override
    public String toString() {
        return super.toString() + ", Bandname: " + bandName;
    }
}

