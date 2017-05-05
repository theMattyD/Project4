// Developer:   Matthew Daniels
// Class:       CMIS 242 - Project 4
// Date:        04 May 2017
// Filename:    StudentDatabaseGUI.java
// Purpose:     This is the GUI constructor class for a student records database

import java.util.*;
import javax.swing.*;

public class StudentDatabaseGUI extends javax.swing.JFrame {
    
    Integer id;
    String name;
    String major;
    
    private HashMap<Integer, Student> database = new HashMap<>();

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
        setTitle("Project 4");
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
                .addContainerGap()
                .addComponent(processButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(24, 24, 24)
                .addComponent(processButton)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        String str = (String) selectionBox.getSelectedItem();
        switch (str) { // choose between the 4 possible menu options
            case "Insert":
                if (!getInfo()) {
                    break;
                }
                if (database.containsKey(id)) {
                    errorPane("The database already contains a student with ID " + id);
                    break;
                }
                Student s = new Student(name, major);
                database.put(id, s);
                successPane("Student #" + id + " added to database.");
                break;
            case "Delete":
                if (!getID()) {
                    break;
                }
                if (!database.containsKey(id)) {
                    errorPane("No student with ID " + id + " exists in the database.");
                    break;
                }
                database.remove(id);
                successPane("Student # " + id + " removed from database.");
                break;
            case "Find":
                if (!getID()) {
                    break;
                }
                if (!database.containsKey(id)) {
                    errorPane("No student with ID " + id + " exists in the database.");
                    break;
                }
                successPane("ID: " + id + ", " + database.get(id));
                break;
            case "Update":
                if (!getID()) {
                    break;
                }
                if (!database.containsKey(id)) {
                    errorPane("No student with ID " + id + " exists in the database.");
                    break;
                }
                double basePoints = getPoints();
                int creditPoints = getCredits();
                database.get(id).courseCompleted(creditPoints, basePoints);
                successPane("Student with ID #" + id + " awarded a grade of " + basePoints + " for a class of " + creditPoints + " credit hours.");
                break;
        }
    }//GEN-LAST:event_processButtonActionPerformed

    // sets variables to information stored in ID, name and major fields
	// returns "true" if all data was valid and "false" otherwise
	private boolean getInfo() {
		boolean hasName = true;
		boolean hasMajor = true;
		try {
			id = Integer.parseInt(idTextField.getText());
		} catch (NumberFormatException e) {
			errorPane("Please enter an integer for ID.");
			return false;
		}
		name = nameTextField.getText();
		major = majorTextField.getText();
		if (name.equals("")) hasName = false;
		if (major.equals("")) hasMajor = false;
		if (!hasName || !hasMajor) {
			if (!hasName && hasMajor) errorPane("Please enter a name.");
			else if (hasName && !hasMajor) errorPane("Please enter a major.");
			else errorPane("Please enter a name and major.");
			return false;
		}
		return true;
	}
	
	// sets ID variable to data from the idField
	// returns "true" on valid ID and "false" otherwise
	private boolean getID() {
		try {
			id = Integer.parseInt(idTextField.getText());
		} catch (NumberFormatException e) {
			errorPane("Please enter an integer for ID.");
			return false;
		}
		return true;
	}
	
	// ------------ SUCCESS INFOPANE METHOD ---------------------
	private void successPane(String s) {
		JOptionPane.showMessageDialog(this, s, "Success",
		JOptionPane.INFORMATION_MESSAGE);
	}
	
	// ------------- ERROR INFOPANE METHOD ---------------------
	private void errorPane(String s) {
		JOptionPane.showMessageDialog(this, s, "Error",
		JOptionPane.ERROR_MESSAGE);
	}
	
	// routine for querying for information to update grades
	// used in conjunction with getCredits()
	private double getPoints() {
		JPanel pointPanel = new JPanel();
		String[] gradeOptions = {"A", "B", "C", "D", "F"};
		JComboBox gradeBox = new JComboBox<>(gradeOptions);
		JLabel pointLabel = new JLabel("Choose Grade:");
		pointPanel.add(pointLabel);
		pointPanel.add(gradeBox);
		JOptionPane.showMessageDialog(this, pointPanel, "Grade", JOptionPane.QUESTION_MESSAGE);
		return 4 - gradeBox.getSelectedIndex();
	}
	
	// routine for querying for information to update credit hours
	// used in conjunction with getPoints()
	private int getCredits() {
		JPanel creditPanel = new JPanel();
		String[] creditOptions = {"3", "6"};
		JComboBox creditBox = new JComboBox<>(creditOptions);
		JLabel creditLabel = new JLabel("Choose Credits:");
		creditPanel.add(creditLabel);
		creditPanel.add(creditBox);
		creditPanel.validate();
		JOptionPane.showMessageDialog(this, creditPanel, "Credits", JOptionPane.QUESTION_MESSAGE);
		return 3 * (creditBox.getSelectedIndex() + 1);
	}
    
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
