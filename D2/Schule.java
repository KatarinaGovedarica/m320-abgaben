package D2;

import java.util.ArrayList;
import java.util.List;

public class Schule {
    private List<Student> studenten; 
    
// konstruktor initiailisiert die studenten

    public Schule() {
        this.studenten = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studenten.add(student);
    }

    public double getKlassendurchschnitt() {
        if (studenten.isEmpty()) {
            return 0.0; 
        }

        double summe = 0;
        int anzahlNoten = 0;

     // iteriert über alle students und üer alle tests
        for (Student student : studenten) {
            for (Test test : student.getTests()) {
                summe += test.calculateGrade(); // sumiert noten von allen tests
                anzahlNoten++; 
            }
        }

        return anzahlNoten == 0 ? 0.0 : summe / anzahlNoten; // gesammtdurchschnitt
    }


    public List<Student> getStudenten() {
        return studenten;
    }
}
