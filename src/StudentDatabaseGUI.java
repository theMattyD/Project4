// Developer:   Matthew Daniels
// Class:       CMIS 242 - Project 4
// Date:        04 May 2017
// Filename:    StudentDatabaseGUI.java
// Purpose:     This is the GUI constructor class for a student records database

import java.util.*;
import javax.swing.*;

public class StudentDatabaseGUI extends javax.swing.JFrame {

    private Integer id;
    private String name;
    private String major;

    private final HashMap<Integer, Student> database = new HashMap<>();

    public StudentDatabaseGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        majorLabel = new javax.swing.JLabel();
        selectionLabel = new javax.swing.JLabel();
        processButton = new javax.swing.JButton();
        idTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        majorTextField = new javax.swing.JTextField();
        selectionBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Project 4 - University of Matty");
        setAlwaysOnTop(true);

        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        idLabel.setText("ID:");

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel.setText("Name:");

        majorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        majorLabel.setText("Major:");

        selectionLabel.setText("Choose Selection:");

        processButton.setText("Process Request");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });

        selectionBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Insert", "Delete", "Find", "Update" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(selectionLabel)
                        .addComponent(majorLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel)
                            .addComponent(nameLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameTextField)
                    .addComponent(idTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(majorTextField)
                    .addComponent(selectionBox, 0, 180, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(processButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {idLabel, majorLabel, nameLabel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(majorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(majorLabel))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectionLabel)
                    .addComponent(selectionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(processButton)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // no code required
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        String selection = (String) selectionBox.getSelectedItem();
        // drop-down menu items from selectionBox
        switch (selection) {
            case "Insert":
                if (!validateFields()) {
                    break;
                }
                if (database.containsKey(id)) {
                    errorPane("ID# " + id + " already exists in the database.");
                    break;
                }
                Student joeStudent = new Student(name, major);
                database.put(id, joeStudent);
                successPane("Student #" + id + " added to database.");
                break;
            case "Delete":
                if (isValidID()) {
                    database.remove(id);
                    successPane("Student # " + id + " removed from database.");
                }
                break;
            case "Find":
                if (isValidID()) {
                    successPane("ID: " + id + "\n" + database.get(id));
                }
                break;
            case "Update":
                if (isValidID()) {
                    String grade = getGradeFromUser();
                    double basePoints = convertGradeToPoints(grade);
                    int creditPoints = getCredits();
                    database.get(id).courseCompleted(creditPoints, basePoints);
                    successPane("Student #: " + id + "\n"
                            + "Name: " + database.get(id).getName() + "\n"
                            + "Grade Assigned: " + grade + "\n"
                            + "Credit Hours:  " + creditPoints);
                }
                break;
        }
    }//GEN-LAST:event_processButtonActionPerformed
    // ------- BOOLEAN CHECK TO INSURE ID IS AN INTEGER AND WHETHER THE ID ----
    // ---------------- ALREADY EXISTS IN THE DATABASE OR NOT -----------------
    private boolean isValidID() {
        try {
            id = Integer.parseInt(idTextField.getText());
        } catch (NumberFormatException e) {
            errorPane("Please enter an integer value for the ID.");
            return false;
        }
        if (!database.containsKey(id)) {
            errorPane("No student with ID " + id + " exists in the database.");
            return false;
        }
        return true;
    }

    // ------------ BOOLEAN CHECK OF NAME AND MAJOR FIELDS ---------------
    private boolean validateFields() {
        try {
            id = Integer.parseInt(idTextField.getText());
        } catch (NumberFormatException e) {
            errorPane("Please enter an integer for the ID.");
            return false;
        }
        
        name = nameTextField.getText();
        major = majorTextField.getText();

        boolean hasName = !name.isEmpty();
        boolean hasMajor = !major.isEmpty();

        if (!hasName && hasMajor) {
            errorPane("Please enter a name.");
            return false;
        } else if (hasName && !hasMajor) {
            errorPane("Please enter a major.");
            return false;
        } else if (!hasName && !hasMajor) {
            errorPane("Please enter a name and major.");
            return false;
        }
        return true;
    }

    // ----------------- ERROR INFOPANE METHOD -------------------------
    private void errorPane(String error) {
        JOptionPane.showMessageDialog(this, error, "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    // ---------------- SUCCESS INFOPANE METHOD ---------------------
    private void successPane(String success) {
        JOptionPane.showMessageDialog(this, success, "Success",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // ----------- FOR 'UPDATE' RECORD, SELECT STUDENT GRADE ------------
    private String getGradeFromUser() {
        JPanel pointPanel = new JPanel();
        String[] gradeOptions = {"A", "B", "C", "D", "F"};
        JComboBox gradeBox = new JComboBox<>(gradeOptions);
        JLabel pointLabel = new JLabel("Choose Grade:");
        pointPanel.add(pointLabel);
        pointPanel.add(gradeBox);
        JOptionPane.showMessageDialog(this, pointPanel, "Grade",
                JOptionPane.QUESTION_MESSAGE);
        return (String) gradeBox.getSelectedItem();
    }

    // -- METHOD TO DISPLAY A LETTER GRADE INSTEAD OF THE GRADE INDEX VALUE --
    private double convertGradeToPoints(String val) {
        switch (val) {
            case "A":
                return 4;
            case "B":
                return 3;
            case "C":
                return 2;
            case "D":
                return 1;
            case "F":
                return 0;
            default:
                return 0;
        }
    }

    // --------- FOR 'UPDATE' RECORD, SELECT STUDENT CREDIT POINTS --------
    private int getCredits() {
        JPanel creditsPanel = new JPanel();
        String[] creditOptions = {"3", "6"};
        JComboBox creditsBox = new JComboBox<>(creditOptions);
        JLabel creditsLabel = new JLabel("Choose Credits:");
        creditsPanel.add(creditsLabel);
        creditsPanel.add(creditsBox);
        creditsPanel.validate();
        JOptionPane.showMessageDialog(this, creditsPanel, "Credits",
                JOptionPane.QUESTION_MESSAGE);
        return 3 * (creditsBox.getSelectedIndex() + 1);
    }

    // ------------------- MAIN METHOD -------------------------
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentDatabaseGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel majorLabel;
    private javax.swing.JTextField majorTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton processButton;
    private javax.swing.JComboBox<String> selectionBox;
    private javax.swing.JLabel selectionLabel;
    // End of variables declaration//GEN-END:variables
}