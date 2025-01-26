package D1;

import java.math.BigDecimal;

public class Konto {
    
    /* mit float und double können rundungsfehler passieren, deswegen benutzt man 
    bigdecimal eher für akkuratere resultate, habe ich über google herausgefunden juhu
    */

    private int kontoNR;
    private BigDecimal saldo;
    private BigDecimal limit; 

    // konstruktor juhu
    public Konto(int kontoNR, BigDecimal limit) {
        this.kontoNR = kontoNR;
        this.saldo = new BigDecimal("100.00"); 
        this.limit = limit;
    }

    public int getKontoNR() {
        return kontoNR;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    // einzahlen
    // bigdecimal zero ist eine konstante in bigdecimal, wenn man berechnungen machen muss werden werte 0 und 1 in konstanten dargestellt
    // bigdecimal kann nicht mit primitiven typen verglichen werden, compare vergleicht ob es kleiner, 0 oder weniger ist weil man nicht 0 aufs konto oder vom nehmen kann
    public void einzahlen(BigDecimal betrag) {
        if (betrag.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(betrag);
        } else {
            System.out.println("betrag muss positiv sein.");
        }
    }

    // abheben
    public void abheben(BigDecimal betrag) {
        // prüft ist btrag grösser als 0, und ob kontostand nachher unters limit geht
        if (betrag.compareTo(BigDecimal.ZERO) > 0 && saldo.subtract(betrag).compareTo(limit) >= 0) {
            saldo = saldo.subtract(betrag);
            System.out.println("abhebung erfolgreich! neuer saldo: " + saldo);
        } else {
            System.out.println("abhebung fehlgeschlagen: betrag überschreitet das limit.");
        }
    }
    
    

    // überweisen
    public void ueberweisen(Konto nachKonto, BigDecimal betrag) {
        // negate macht aus wert gegenteil wert yk, hier macht limit von -50.00 zu 50.00 um gucken ob nicht über limit macht vergleich einfacher
        if (betrag.compareTo(BigDecimal.ZERO) > 0 && saldo.subtract(betrag).compareTo(limit.negate()) >= 0) {
            this.abheben(betrag);
            nachKonto.einzahlen(betrag);
            System.out.println("überweisung erfolgreich: " + betrag + " von konto " + kontoNR + " zu konto " + nachKonto.getKontoNR());
        } else {
            System.out.println("überweisung fehlgeschlagen: betrag überschreitet das limit.");
        }
    }
}
