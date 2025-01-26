package Projekt;

import java.util.List;

public interface VinylCollectionManager {
    void addVinyl(Vinyl vinyl);
    void removeVinyl(String title) throws VinylNotFoundException;
    List<Vinyl> getCollection();
    List<Vinyl> getWishlist();
}

