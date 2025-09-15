package Employee_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Salary extends JFrame implements ActionListener {

    Choice chEmpId, chMonth, chYear;
    JTextField tfName, tfEmail, tfHra, tfDa, tfMid, tfPf, tfBasic;
    JButton submitBtn, closeBtn;

    Salary() {
        super("Employee Salary");
        setLayout(null);
        setSize(550, 450);
        setLocation(400, 200);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblTitle = new JLabel("Employee Salary");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(180, 10, 250, 30);
        add(lblTitle);

        JLabel lblEid = new JLabel("Select Employee ID");
        lblEid.setBounds(50, 60, 150, 25);
        add(lblEid);

        chEmpId = new Choice();
        chEmpId.setBounds(220, 60, 150, 25);
        add(chEmpId);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(50, 100, 150, 25);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(220, 100, 150, 25);
        tfName.setEditable(false);
        add(tfName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(50, 140, 150, 25);
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(220, 140, 150, 25);
        tfEmail.setEditable(false);
        add(tfEmail);

        JLabel lblHra = new JLabel("HRA");
        lblHra.setBounds(50, 180, 150, 25);
        add(lblHra);

        tfHra = new JTextField();
        tfHra.setBounds(220, 180, 150, 25);
        add(tfHra);

        JLabel lblDa = new JLabel("DA");
        lblDa.setBounds(50, 220, 150, 25);
        add(lblDa);

        tfDa = new JTextField();
        tfDa.setBounds(220, 220, 150, 25);
        add(tfDa);

        JLabel lblMid = new JLabel("MID");
        lblMid.setBounds(50, 260, 150, 25);
        add(lblMid);

        tfMid = new JTextField();
        tfMid.setBounds(220, 260, 150, 25);
        add(tfMid);

        JLabel lblPf = new JLabel("PF");
        lblPf.setBounds(50, 300, 150, 25);
        add(lblPf);

        tfPf = new JTextField();
        tfPf.setBounds(220, 300, 150, 25);
        add(tfPf);

        JLabel lblBasic = new JLabel("Basic Salary");
        lblBasic.setBounds(50, 340, 150, 25);
        add(lblBasic);

        tfBasic = new JTextField();
        tfBasic.setBounds(220, 340, 150, 25);
        add(tfBasic);

        JLabel lblMonth = new JLabel("Select Month");
        lblMonth.setBounds(400, 60, 100, 25);
        add(lblMonth);

        chMonth = new Choice();
        chMonth.add("January");
        chMonth.add("February");
        chMonth.add("March");
        chMonth.add("April");
        chMonth.add("May");
        chMonth.add("June");
        chMonth.add("July");
        chMonth.add("August");
        chMonth.add("September");
        chMonth.add("October");
        chMonth.add("November");
        chMonth.add("December");
        chMonth.setBounds(400, 90, 100, 25);
        add(chMonth);

        JLabel lblYear = new JLabel("Select Year");
        lblYear.setBounds(400, 130, 100, 25);
        add(lblYear);

        chYear = new Choice();
        for (int i = 2010; i <= 2030; i++) {
            chYear.add(String.valueOf(i));
        }
        chYear.setBounds(400, 160, 100, 25);
        add(chYear);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(400, 250, 100, 30);
        submitBtn.addActionListener(this);
        add(submitBtn);

        closeBtn = new JButton("Close");
        closeBtn.setBounds(400, 300, 100, 30);
        closeBtn.addActionListener(this);
        add(closeBtn);

        // Load Employee IDs from DB
        try {
            ConnectionClass obj = new ConnectionClass();
            ResultSet rs = obj.stm.executeQuery("SELECT eid FROM employee1");
            while (rs.next()) {
                chEmpId.add(rs.getString("eid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Load details for first employee
        if (chEmpId.getItemCount() > 0) {
            loadEmployeeDetails();
        }

        // Listener for change
        chEmpId.addItemListener(e -> loadEmployeeDetails());

        setVisible(true);
    }

    void loadEmployeeDetails() {
        try {
            ConnectionClass obj = new ConnectionClass();
            String eid = chEmpId.getSelectedItem();
            ResultSet rs = obj.stm.executeQuery("SELECT name, email FROM employee1 WHERE eid='" + eid + "'");
            if (rs.next()) {
                tfName.setText(rs.getString("name"));
                tfEmail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitBtn) {
            String eid = chEmpId.getSelectedItem();
            String name = tfName.getText();
            String email = tfEmail.getText();
            String hra = tfHra.getText();
            String da = tfDa.getText();
            String mid = tfMid.getText();
            String pf = tfPf.getText();
            String basic = tfBasic.getText();
            String monthYear = chMonth.getSelectedItem() + " " + chYear.getSelectedItem();

            try {
                ConnectionClass obj = new ConnectionClass();
                String query = "INSERT INTO salary (eid, name, email, hra, da, mid, pf, basic, month_year) VALUES ('"
                        + eid + "', '" + name + "', '" + email + "', '" + hra + "', '" + da + "', '" + mid + "', '"
                        + pf + "', '" + basic + "', '" + monthYear + "')";
                obj.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Salary details added successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == closeBtn) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Salary();
    }
}
