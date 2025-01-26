package V1;

public class Buch extends Medien {
    private String isbn;

    public Buch(String titel, int jahr, double preis, String isbn) {
        super(titel, jahr, preis);
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() + ", ISBN: " + isbn;
    }
}

