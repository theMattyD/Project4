// Developer:   Matthew Daniels
// Class:       CMIS 242 - Project 4
// Date:        04 May 2017
// Filename:    StudentDatabaseGUI.java
// Purpose:     This is the data structure class for a student records database

class Student {

    private final String name;
    private final String major;
    private int creditHours;
    private double gpaPoints;

    Student(String thisName, String thisMajor) {
        name = thisName;
        major = thisMajor;
        creditHours = 0;
        gpaPoints = 0;
    }

    // -------- RUNNING TOTAL OF CREDIT HOURS AND POINTS ACCUMULATED ------
    public void courseCompleted(int credits, double points) {
        creditHours += credits;
        gpaPoints += points * credits;
    }

    @Override
    public String toString() {
        String output = ("Name: ") + name + "\n";
        output += ("Major: ") + major + "\n";
        if (creditHours == 0) {
            output += ("GPA: 4.00 \n");
        } else {
            output += ("GPA: ") + (gpaPoints / creditHours);
        }
        return output;
    }
}
