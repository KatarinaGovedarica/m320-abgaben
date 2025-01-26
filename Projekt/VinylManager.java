package Projekt;

import java.util.ArrayList;
import java.util.List;

public class VinylManager implements VinylCollectionManager {
    private List<Vinyl> collection = new ArrayList<>();
    private List<Vinyl> wishlist = new ArrayList<>();

    @Override
    public void addVinyl(Vinyl vinyl) {
        collection.add(vinyl);
    }

    public void addToWishlist(Vinyl vinyl) {
        wishlist.add(vinyl);
    }

    @Override
    public void removeVinyl(String title) throws VinylNotFoundException {
        boolean removed = collection.removeIf(vinyl -> vinyl.title.equalsIgnoreCase(title));
        if (!removed) {
            throw new VinylNotFoundException("Vinyl with title '" + title + "' not found in the collection.");
        }
    }

    @Override
    public List<Vinyl> getCollection() {
        return new ArrayList<>(collection);
    }

    @Override
    public List<Vinyl> getWishlist() {
        return new ArrayList<>(wishlist);
    }
}

