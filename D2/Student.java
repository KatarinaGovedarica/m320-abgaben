package D2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name; 
    private List<Test> tests;

    // konstruktor: initialisiert namen und test liste
    public Student(String name) {
        this.name = name;
        this.tests = new ArrayList<>();
    }

    public void addTest(Test test) {
        tests.add(test); 
    }

    public double getDurchschnitt() {
        if (tests.isEmpty()) {
            return 0.0; // no tests = notendurchschnitt 0
        }

        double summe = 0;
        for (Test test : tests) {
            summe += test.calculateGrade(); // berechnet die note von jedem test und summiert sie dann
        }

        return summe / tests.size(); // teilt die summe durch die anzahl der tests
    }

    public String getName() {
        return name;
    }

    public List<Test> getTests() {
        return tests;
    }
}
