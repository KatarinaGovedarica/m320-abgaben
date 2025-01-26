package Projekt;

public class Vinyl {
    protected String title;
    protected String artist;
    protected String variant;

    public Vinyl(String title, String artist, String variant) {
        this.title = title;
        this.artist = artist;
        this.variant = variant;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Variant: " + variant;
    }
}

