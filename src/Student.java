// Class:       CMIS 242 - Project 4
// Date:        04 May 2017
// Filename:    StudentDatabaseGUI.java
// Purpose:     This is the data structure class for a student records database

class Student {

    private final String name;
    private final String major;
    private int credits; // holds total number of credits
    private double points; // holds GPA point totals

    Student(String aName, String aMajor) {
        name = aName;
        major = aMajor;
        credits = 0;
        points = 0;
    }

    // takes int c for credits and double p for points
    // adds credits and class GPA to instance variables
    public void courseCompleted(int c, double p) {
        credits += c;
        points += p * c;
    }

    @Override
    public String toString() {
        String s = ("Name: ") + name;
        s += (", Major: ") + major;
        if (credits == 0) {
            s += (", GPA: n/a");
        } else {
            s += (", GPA: ") + (points / credits);
        }
        return s;
    }
}
