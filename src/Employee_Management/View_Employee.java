package Employee_Management;

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;

public class View_Employee implements ActionListener {
    JFrame f;
    JComboBox<String> comboBox; // Replaces JTextField
    JLabel l1, l2;
    JButton b, b2;

    View_Employee() {
        f = new JFrame("View Employee");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 500, 270);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icon/View_emp1.jpg"));
        Image i1 = img.getImage().getScaledInstance(700, 370, Image.SCALE_DEFAULT);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);

        l2 = new JLabel("Employee Id");
        l2.setBounds(40, 60, 250, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        f.add(l1);

        // Create JComboBox and make it editable
        comboBox = new JComboBox<>();
        comboBox.setBounds(240, 60, 220, 30);
        comboBox.setEditable(true);
        l1.add(comboBox);

        // Load IDs from database
        loadEmployeeIDs();

        b = new JButton("Search");
        b.setBounds(140, 150, 100, 30);
        b.addActionListener(this);
        l1.add(b);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.red);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(260, 150, 100, 30);
        l1.add(b2);

        f.setSize(500, 270);
        f.setLocation(450, 250);
        f.setVisible(true);
    }

    // Method to load IDs into JComboBox
    private void loadEmployeeIDs() {
        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT eid FROM employee1 ORDER BY eid ASC";
            ResultSet rs = obj.stm.executeQuery(query);

            while (rs.next()) {
                comboBox.addItem(rs.getString("eid"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading IDs: " + ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            f.setVisible(false);
            new View_Employee_Data(comboBox.getSelectedItem().toString());
        }
        if (e.getSource() == b2) {
            f.setVisible(false);
            new HomePage();
        }
    }

    public static void main(String args[]) {
        new View_Employee();
    }
}
