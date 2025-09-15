
package Employee_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Generate_PaySlip extends JFrame implements ActionListener {

    Choice chEmpId, chMonth, chYear;
    JTextArea ta;
    JButton btnGenerate, btnClose;

    Generate_PaySlip() {
        super("Generate Pay Slip");
        setSize(500, 500);
        setLocation(400, 200);
        setLayout(null);

        JLabel lblTitle = new JLabel("---------Pay Slip---------");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setBounds(150, 10, 300, 30);
        add(lblTitle);

        ta = new JTextArea();
        ta.setBounds(30, 50, 420, 250);
        ta.setEditable(false);
        add(ta);

        JLabel lblEmp = new JLabel("Employee Id");
        lblEmp.setBounds(30, 320, 100, 20);
        add(lblEmp);

        chEmpId = new Choice();
        try {
            ConnectionClass obj = new ConnectionClass();
            ResultSet rs = obj.stm.executeQuery("select * from employee1");
            while (rs.next()) {
                chEmpId.add(rs.getString("eid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        chEmpId.setBounds(150, 320, 100, 20);
        add(chEmpId);

        JLabel lblMonth = new JLabel("Month");
        lblMonth.setBounds(30, 350, 100, 20);
        add(lblMonth);

        chMonth = new Choice();
        String months[] = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        for (String m : months) chMonth.add(m);
        chMonth.setBounds(150, 350, 100, 20);
        add(chMonth);

        JLabel lblYear = new JLabel("Year");
        lblYear.setBounds(30, 380, 100, 20);
        add(lblYear);

        chYear = new Choice();
        for (int i = 2015; i <= 2030; i++) chYear.add("" + i);
        chYear.setBounds(150, 380, 100, 20);
        add(chYear);

        btnGenerate = new JButton("Generate");
        btnGenerate.setBounds(300, 350, 100, 25);
        btnGenerate.addActionListener(this);
        add(btnGenerate);

        btnClose = new JButton("Close");
        btnClose.setBounds(300, 380, 100, 25);
        btnClose.addActionListener(e -> dispose());
        add(btnClose);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnGenerate) {
            String eid = chEmpId.getSelectedItem();
            String month = chMonth.getSelectedItem();
            String year = chYear.getSelectedItem();
            String monthYear = month + " " + year;

            try {
                ConnectionClass obj = new ConnectionClass();
                String q1 = "select * from employee1 where eid='" + eid + "'";
                ResultSet rs1 = obj.stm.executeQuery(q1);

                String name = "", email = "";
                if (rs1.next()) {
                    name = rs1.getString("name");
                    email = rs1.getString("email");
                }

                String q2 = "select * from salary where eid='" + eid + "' and month_year='" + monthYear + "'";
                ResultSet rs2 = obj.stm.executeQuery(q2);

                ta.setText("---------Pay Slip---------\n");
                ta.append("Employee Id : " + eid + "\n");
                ta.append("Employee Name : " + name + "\n");
                ta.append("Employee Email : " + email + "\n");
                ta.append("============================================\n");

                if (rs2.next()) {
                    ta.append("HRA: " + rs2.getString("hra") + "\n");
                    ta.append("DA: " + rs2.getString("da") + "\n");
                    ta.append("MID: " + rs2.getString("mid") + "\n");
                    ta.append("PF: " + rs2.getString("pf") + "\n");
                    ta.append("Basic Salary: " + rs2.getString("basic") + "\n");
                    ta.append("Month-Year: " + rs2.getString("month_year") + "\n");
                    ta.append("============================================\n");
                } else {
                    ta.append("Record Not Found of this month and year.\n");
                    ta.append("----------------OR-----------------\n");
                    ta.append("Please add the Salary of this month and year for this record.\n");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Generate_PaySlip();
    }
}

