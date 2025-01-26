package Projekt;

public class VinylManagerSingleton {
    private static VinylManager instance;

    private VinylManagerSingleton() {
    }

    public static VinylManager getInstance() {
        if (instance == null) {
            instance = new VinylManager();
        }
        return instance;
    }
}
