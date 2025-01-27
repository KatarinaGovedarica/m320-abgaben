package Projekt;

import java.util.List;
import java.util.Scanner;

public class VinylCollectionApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final VinylManager manager = VinylManagerSingleton.getInstance();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    addVinylToCollection();
                    break;
                case 2:
                    removeVinylFromCollection();
                    break;
                case 3:
                    viewCollection();
                    break;
                case 4:
                    addVinylToWishlist();
                    break;
                case 5:
                    viewWishlist();
                    break;
                case 6:
                    sortCollection();
                    break;
                case 7:
                    saveCollection();
                    break;
                case 8:
                    loadCollection();
                    break;
                case 9:
                    running = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nVinyl Collection Manager");
        System.out.println("1. Add Vinyl to Collection");
        System.out.println("2. Remove Vinyl from Collection");
        System.out.println("3. View Collection");
        System.out.println("4. Add Vinyl to Wishlist");
        System.out.println("5. View Wishlist");
        System.out.println("6. Sort Collection");
        System.out.println("7. Save Collection");
        System.out.println("8. Load Collection");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void addVinylToCollection() {
        System.out.print("Enter Vinyl Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Artist: ");
        String artist = scanner.nextLine();
        System.out.print("Enter Variant: ");
        String variant = scanner.nextLine();

        System.out.print("Is this a special edition? (yes/no): ");
        String specialEdition = scanner.nextLine();

        if (specialEdition.equalsIgnoreCase("yes")) {
            System.out.print("Enter Special Feature: ");
            String specialFeature = scanner.nextLine();
            manager.addVinyl(new SpecialEditionVinyl(title, artist, variant, specialFeature));
        } else {
            manager.addVinyl(new Vinyl(title, artist, variant));
        }

        System.out.println("Vinyl added to collection!");
    }

    private static void removeVinylFromCollection() {
        System.out.print("Enter the title of the Vinyl to remove: ");
        String title = scanner.nextLine();

        try {
            manager.removeVinyl(title);
            System.out.println("Vinyl removed from collection.");
        } catch (VinylNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewCollection() {
        System.out.println("\nYour Vinyl Collection:");
        for (Vinyl vinyl : manager.getCollection()) {
            System.out.println(vinyl);
        }
    }

    private static void addVinylToWishlist() {
        System.out.print("Enter Vinyl Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Artist: ");
        String artist = scanner.nextLine();
        System.out.print("Enter Variant: ");
        String variant = scanner.nextLine();

        manager.addToWishlist(new Vinyl(title, artist, variant));
        System.out.println("Vinyl added to wishlist!");
    }

    private static void viewWishlist() {
        System.out.println("\nYour Wishlist:");
        for (Vinyl vinyl : manager.getWishlist()) {
            System.out.println(vinyl);
        }
    }

    private static void sortCollection() {
        System.out.println("Sort by: 1. Title 2. Artist");
        int choice = getChoice();
        List<Vinyl> sorted;

        if (choice == 1) {
            sorted = VinylSorter.sortByTitle(manager.getCollection());
        } else if (choice == 2) {
            sorted = VinylSorter.sortByArtist(manager.getCollection());
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.println("\nSorted Collection:");
        for (Vinyl vinyl : sorted) {
            System.out.println(vinyl);
        }
    }

    private static void saveCollection() {
        VinylDataManager.saveCollection(manager.getCollection());
    }

    private static void loadCollection() {
        VinylDataManager.loadCollection(manager.getCollection());
    }
}

