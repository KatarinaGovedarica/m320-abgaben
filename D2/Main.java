package D2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Schule schule = new Schule();
        Scanner scanner = new Scanner(System.in);

        Student student1 = new Student("hans peter");
        student1.addTest(new Test(45, 50)); 
        student1.addTest(new Test(38, 40)); 
        student1.addTest(new Test(32, 35)); 
        schule.addStudent(student1);

        Student student2 = new Student("bob");
        student2.addTest(new Test(30, 50)); 
        student2.addTest(new Test(20, 30)); 
        student2.addTest(new Test(10, 35)); 
        schule.addStudent(student2);

        Student student3 = new Student("heinz");
        student3.addTest(new Test(50, 50)); 
        student3.addTest(new Test(48, 50)); 
        student3.addTest(new Test(35, 35)); 
        schule.addStudent(student3);

        System.out.println("drei vordefinierte schüler wurden hinzugefügt.");
        System.out.println("1. alice mit 3 Tests.");
        System.out.println("2. bob mit 3 Tests.");
        System.out.println("3. charlie mit 3 Tests.");

// das hauptmenü
        while (true) {
            System.out.println("\nhauptmenü:");
            System.out.println("1. student hinzufügen");
            System.out.println("2. notendurchschnitt pro student anzeigen");
            System.out.println("3. klassendurchschnitt anzeigen");
            System.out.println("4. beenden");
            System.out.print("option auswählen: ");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1 -> {
                    System.out.print("name des studenten: ");
                    String name = scanner.nextLine();
                    Student student = new Student(name);

                    System.out.print("anzahl der tests hinzufügen: ");
                    int anzahlTests = scanner.nextInt();

                    for (int i = 0; i < anzahlTests; i++) {
                        System.out.print("punkte für test " + (i + 1) + ": ");
                        int points = scanner.nextInt();
                        System.out.print("maximale punkte für test " + (i + 1) + ": ");
                        int maxPoints = scanner.nextInt();
                        student.addTest(new Test(points, maxPoints)); 
                    }

                    schule.addStudent(student);
                    System.out.println("student " + name + " wurde hinzugefügt.");
                }
                case 2 -> {
                    System.out.println("\nnotendurchschnitt pro student:");
                    for (Student student : schule.getStudenten()) {
                        System.out.println(student.getName() + ": " + student.getDurchschnitt());
                    }
                }
                case 3 -> {
                    System.out.println("\nklassendurchschnitt: " + schule.getKlassendurchschnitt());
                }
                case 4 -> {
                    System.out.println("programm beendet.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("ungültige option. bitte erneut versuchen.");
            }
        }
    }
}
