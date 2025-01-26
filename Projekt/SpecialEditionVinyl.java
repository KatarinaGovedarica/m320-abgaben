package Projekt;

public class SpecialEditionVinyl extends Vinyl {
    private String specialFeature;

    public SpecialEditionVinyl(String title, String artist, String variant, String specialFeature) {
        super(title, artist, variant);
        this.specialFeature = specialFeature;
    }

    @Override
    public String toString() {
        return super.toString() + ", Special Feature: " + specialFeature;
    }
}

