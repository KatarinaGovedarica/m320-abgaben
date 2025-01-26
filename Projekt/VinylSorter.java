package Projekt;

import java.util.Comparator;
import java.util.List;

public class VinylSorter {
    public static List<Vinyl> sortByTitle(List<Vinyl> vinyls) {
        vinyls.sort(Comparator.comparing(v -> v.title));
        return vinyls;
    }

    public static List<Vinyl> sortByArtist(List<Vinyl> vinyls) {
        vinyls.sort(Comparator.comparing(v -> v.artist));
        return vinyls;
    }
}

