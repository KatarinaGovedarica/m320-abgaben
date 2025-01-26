package V1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MedienVerwaltung verwaltung = new MedienVerwaltung();
        Scanner scanner = new Scanner(System.in);

        // Beispielhafte Medien hinzufügen
        verwaltung.addMedium(new DVD("Gladiator", 2000, 15.50, "2h 35min"));
        verwaltung.addMedium(new CD("Deeper Well", 2024, 13.00, "Kacey Musgraves"));
        verwaltung.addMedium(new Buch("One Of Us Is Lying", 2017, 18.00, "978-3-12-578356-0"));

        boolean running = true;

        while (running) {
            System.out.println("\n--- Medienverwaltung ---");
            System.out.println("1. Medien anzeigen");
            System.out.println("2. Medium hinzufügen");
            System.out.println("3. Medium entfernen");
            System.out.println("4. Programm beenden");
            System.out.print("Ihre Auswahl: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    verwaltung.displayMedien();
                    break;
                case 2:
                    System.out.println("\nWelches Medium möchten Sie hinzufügen?");
                    System.out.println("1. DVD\n2. CD\n3. Buch");
                    System.out.print("Ihre Auswahl: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Titel: ");
                    String titel = scanner.nextLine();
                    System.out.print("Jahr: ");
                    int jahr = scanner.nextInt();
                    System.out.print("Preis: ");
                    double preis = scanner.nextDouble();
                    scanner.nextLine();

                    if (type == 1) {
                        System.out.print("Filmlänge: ");
                        String filmLaenge = scanner.nextLine();
                        verwaltung.addMedium(new DVD(titel, jahr, preis, filmLaenge));
                    } else if (type == 2) {
                        System.out.print("Bandname: ");
                        String bandName = scanner.nextLine();
                        verwaltung.addMedium(new CD(titel, jahr, preis, bandName));
                    } else if (type == 3) {
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();
                        verwaltung.addMedium(new Buch(titel, jahr, preis, isbn));
                    } else {
                        System.out.println("Ungültige Auswahl.");
                    }
                    break;
                case 3:
                    verwaltung.displayMedien();
                    System.out.print("\nGeben Sie die Nummer des Mediums ein, das entfernt werden soll: ");
                    // ist da damit wenn man 1 eingibt es den index 0 nimmt
                    int index = scanner.nextInt() - 1;
                    verwaltung.removeMedium(index);
                    break;
                case 4:
                    running = false;
                    System.out.println("Programm beendet.");
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte erneut versuchen.");
            }
        }

        scanner.close();
    }
}

