package D2;

public class Test {
    private int points; 
    private int maxPoints; 

    // konstruktor: initialisiert die erzielten und maximalen Punkte.
    public Test(int points, int maxPoints) {
        this.points = points;
        this.maxPoints = maxPoints;
    }


    public double calculateGrade() {
        if (maxPoints <= 0) {
            throw new IllegalArgumentException("maximale punkte müssen größer als 0 sein.");
        }
        return (points * 5.0 / maxPoints) + 1; // formel: punktzahl * 5 / totalpunktzahl + 1
    }

    public int getPoints() {
        return points;
    }

    public int getMaxPoints() {
        return maxPoints;
    }
}
