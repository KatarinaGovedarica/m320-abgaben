package V1;

import java.util.ArrayList;
import java.util.List;

public class MedienVerwaltung {
    private List<Medien> medienListe;

    public MedienVerwaltung() {
        this.medienListe = new ArrayList<>();

    }


    public void addMedium(Medien medium) {
        medienListe.add(medium);
    }



    public void displayMedien() {
        System.out.println("Medien in der Liste:");
        if (medienListe.isEmpty()) {
            System.out.println("Die Liste ist leer.");
        } else {
            // .size gibt basically die anzahl der elemnte zurück
            for (int i = 0; i < medienListe.size(); i++) {
                System.out.println((i + 1) + ". " + medienListe.get(i));
            }
            medienListe.stream().forEach(m -> System.out.println(m));
        }
    }

    public void removeMedium(int index) {
        if (index >= 0 && index < medienListe.size()) {
            medienListe.remove(index);
            System.out.println("Das Medium wurde erfolgreich entfernt.");
        } else {
            System.out.println("Ungültige Nummer. Kein Medium wurde entfernt.");
        }
    }

    public List<Medien> getMedienListe() {
        return medienListe;
    }
}
