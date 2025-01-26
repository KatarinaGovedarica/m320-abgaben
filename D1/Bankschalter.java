package D1;

import java.math.BigDecimal;
import java.util.Scanner;

public class Bankschalter {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Konto konto1 = new Konto(1, new BigDecimal("-50.00"));
        Konto konto2 = new Konto(2, new BigDecimal("-100.00"));
        Konto konto3 = new Konto(3, new BigDecimal("-200.00"));

        Konto[] konten = {konto1, konto2, konto3};

        while (true) {
            
            System.out.println("\nwillkommen beim bankschalter!");
            System.out.println("wählen Sie eine aktion:");
            System.out.println("1 - betrag einzahlen");
            System.out.println("2 - betrag abheben");
            System.out.println("3 - saldo abfragen");
            System.out.println("4 - beenden");

            int auswahl = scanner.nextInt();

            // auswahl beenden
            if (auswahl == 4) {
                System.out.println("programm beendet. auf wiedersehen!");
                break;
            }

            System.out.println("wählen sie ein konto (1, 2 oder 3):");
            int kontoAuswahl = scanner.nextInt();

            // guckt ob das ausgewählte konto innerhalb des gültigen bereichs liegt
            if (kontoAuswahl < 1 || kontoAuswahl > 3) {
                System.out.println("ungültige kontonummer.");
                // spriiiiingt zur nachsten iiiteratiom
                continue;
            }

            // ruft das ausgewählte konto aus dem array ab :-1 um aufs richtige element zuzugreifen weil arrays bei 0 starten
            Konto ausgewaehltesKonto = konten[kontoAuswahl - 1];

            switch (auswahl) {
                case 1: // einzahlen
                    System.out.println("geben sie den einzahlungsbetrag ein:");
                    BigDecimal einzahlungsbetrag = scanner.nextBigDecimal();
                    // methode fügt den eingegebenen betrag zum saldo hinzu.
                    ausgewaehltesKonto.einzahlen(einzahlungsbetrag);
                    System.out.println("einzahlung erfolgreich! neuer saldo: " + ausgewaehltesKonto.getSaldo());
                    break;

                case 2: // abheben
                    System.out.println("geben sie den abhebungsbetrag ein:");
                    BigDecimal abhebungsbetrag = scanner.nextBigDecimal();
                    // methode prüft ob der betrag abgehoben werden kann ohne das konto über das limit zu überziehen
                    ausgewaehltesKonto.abheben(abhebungsbetrag);
                    break;

                case 3: // saldo abfragen
                    System.out.println("der aktuelle saldo von konto " + ausgewaehltesKonto.getKontoNR() + " beträgt: " + ausgewaehltesKonto.getSaldo());
                    break;

                default:
                    System.out.println("ungültige auswahl. bitte erneut versuchen.");
            }
        }

        scanner.close();
    }
}
