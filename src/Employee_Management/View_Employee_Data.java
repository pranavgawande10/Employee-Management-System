/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
package Employee_Management;

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
public class View_Employee_Data implements ActionListener {
    
    JFrame f;
    JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15,lb16,lb17,lb18;
    String empid,name,father,address,phone,email,education,post,age,dob,aadhar;
    JButton b1,b2;
    ImageIcon icon;
    
    
    View_Employee_Data(String emid)
    {
        try
        {
            ConnectionClass obj = new ConnectionClass();
            String query = "Select *from employee1 where eid ='"+emid+"'";
            ResultSet rs = obj.stm.executeQuery(query);
            
            while(rs.next())
            {
                name =rs.getString("name");
                father =rs.getString("fname");
                age = rs.getString("age");
                dob = rs.getString("dob");
                address = rs.getString("address");
                phone = rs.getString("phone");
                email = rs.getString("email");
                education = rs.getString("Education");
                post = rs.getString("post");
                aadhar = rs.getString("aadhar");
                empid = rs.getString("Eid");
                
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        f= new JFrame("Display Employee Details");
        f.setVisible(true);
        f.setSize(595,642);
        f.setLocation(450,200);
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        lb1 = new JLabel();
        lb1.setBounds(0,0,595,642);
        lb1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employment_Management/Icon/View_emp2.jpg"));
        lb1.setIcon(img);
        
        lb2 = new JLabel("Employee Details");
        lb2.setBounds(170,10,250,40);
        f.add(lb2);
        lb2.setFont(new Font("Arial",Font.BOLD,28));
        lb1.add(lb2);
        f.add(lb1);
        
        lb3 = new JLabel("Employee Id:");
        lb3.setBounds(150,70,120,30);
        lb3.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb3);
        
        lb4 = new JLabel(empid);
        lb4.setBounds(330,70,200,30);
        lb4.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb4);
        
        lb5 = new JLabel("Name:");
        lb5.setBounds(150,120,100,30);
        lb5.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb5);
        
        lb6 = new JLabel(name);
        lb6.setBounds(330,120,300,30);
        lb6.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb6);
        
        lb7 = new JLabel("Father Name:");
        lb7.setBounds(150,170,200,30);
        lb7.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb7);
        
        lb8 = new JLabel(father);
        lb8.setBounds(330,170,300,30);
        lb8.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb8);
        
        lb9 = new JLabel("Address:");
        lb9.setBounds(150,220,100,30);
        lb9.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb9);
        
        lb10 = new JLabel(address);
        lb10.setBounds(330,220,300,30);
        lb10.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb10);
        
        lb11 = new JLabel("Mobile Number:");
        lb11.setBounds(150,270,100,30);
        lb11.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb11);
        
        lb12 = new JLabel(phone);
        lb12.setBounds(330,270,300,30);
        lb12.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb12);
        
        lb13 = new JLabel("Email Id:");
        lb13.setBounds(150,320,100,30);
        lb13.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb13);
        
        lb14 = new JLabel(email);
        lb14.setBounds(330,320,300,30);
        lb14.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb14);
        
        lb15 = new JLabel("Education:");
        lb15.setBounds(150,370,100,30);
        lb15.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb15);
        
        lb16 = new JLabel(education);
        lb16.setBounds(330,370,300,30);
        lb16.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb16);
        
        lb17 = new JLabel("Job Post");
        lb17.setBounds(150,420,100,30);
        lb17.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb17);
        
        lb18 = new JLabel(post);
        lb18.setBounds(330,420,300,30);
        lb18.setFont(new Font("serif",Font.BOLD,20));
        lb1.add(lb18);
        
        b1=new JButton("Print");
        b1.setBackground(Color.red);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(160,520,100,30);
        lb1.add(b1);
         
        b2=new JButton("Cancel");
        b2.setBackground(Color.red);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(350,520,100,30);
        lb1.add(b2);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            JOptionPane.showMessageDialog(null, "Printed successfully");
            f.setVisible(false);
            new HomePage();
            
        }
        if(e.getSource()==b2)
        {
            f.setVisible(false);
            new View_Employee();
        }
    }
    

    
    
}*/
package Employee_Management;

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;

public class View_Employee_Data implements ActionListener {

    JFrame f;
    JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10;
    JLabel lb11, lb12, lb13, lb14, lb15, lb16, lb17, lb18, lb19, lb20, lb21, lb22;
    String empid, name, father, address, phone, email, education, post, age, dob, aadhar;
    JButton b1, b2;

    View_Employee_Data(String emid) {
        boolean recordFound = false;

        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT * FROM employee1 WHERE eid = '" + emid + "'";
            ResultSet rs = obj.stm.executeQuery(query);

            while (rs.next()) {
                recordFound = true;
                name = rs.getString("name");
                father = rs.getString("fname");
                age = rs.getString("age");
                dob = rs.getString("dob");
                address = rs.getString("address");
                phone = rs.getString("phone");
                email = rs.getString("email");
                education = rs.getString("education");
                post = rs.getString("post");
                aadhar = rs.getString("aadhar");
                empid = rs.getString("eid");
            }

            if (!recordFound) {
                JOptionPane.showMessageDialog(null, "No employee found with ID: " + emid);
                return;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
            return;
        }

        // GUI Setup
        f = new JFrame("Display Employee Details");
        f.setSize(595, 700);
        f.setLocation(450, 150);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.WHITE);

        lb1 = new JLabel();
        lb1.setBounds(0, 0, 595, 700);
        lb1.setLayout(null);

        // Corrected path
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icon/Viewemp2.jpg"));

        lb1.setIcon(img);

        Font font = new Font("serif", Font.BOLD, 20);

        lb2 = new JLabel("Employee Details");
        lb2.setBounds(170, 10, 300, 40);
        lb2.setFont(new Font("Arial", Font.BOLD, 28));
        lb1.add(lb2);

        lb3 = new JLabel("Employee ID:");
        lb3.setBounds(150, 70, 150, 30);
        lb3.setFont(font);
        lb1.add(lb3);

        lb4 = new JLabel(empid);
        lb4.setBounds(330, 70, 200, 30);
        lb4.setFont(font);
        lb1.add(lb4);

        lb5 = new JLabel("Name:");
        lb5.setBounds(150, 110, 150, 30);
        lb5.setFont(font);
        lb1.add(lb5);

        lb6 = new JLabel(name);
        lb6.setBounds(330, 110, 300, 30);
        lb6.setFont(font);
        lb1.add(lb6);

        lb7 = new JLabel("Father Name:");
        lb7.setBounds(150, 150, 150, 30);
        lb7.setFont(font);
        lb1.add(lb7);

        lb8 = new JLabel(father);
        lb8.setBounds(330, 150, 300, 30);
        lb8.setFont(font);
        lb1.add(lb8);

        lb9 = new JLabel("Address:");
        lb9.setBounds(150, 190, 150, 30);
        lb9.setFont(font);
        lb1.add(lb9);

        lb10 = new JLabel(address);
        lb10.setBounds(330, 190, 300, 30);
        lb10.setFont(font);
        lb1.add(lb10);

        lb11 = new JLabel("Phone:");
        lb11.setBounds(150, 230, 150, 30);
        lb11.setFont(font);
        lb1.add(lb11);

        lb12 = new JLabel(phone);
        lb12.setBounds(330, 230, 300, 30);
        lb12.setFont(font);
        lb1.add(lb12);

        lb13 = new JLabel("Email:");
        lb13.setBounds(150, 270, 150, 30);
        lb13.setFont(font);
        lb1.add(lb13);

        lb14 = new JLabel(email);
        lb14.setBounds(330, 270, 300, 30);
        lb14.setFont(font);
        lb1.add(lb14);

        lb15 = new JLabel("Education:");
        lb15.setBounds(150, 310, 150, 30);
        lb15.setFont(font);
        lb1.add(lb15);

        lb16 = new JLabel(education);
        lb16.setBounds(330, 310, 300, 30);
        lb16.setFont(font);
        lb1.add(lb16);

        lb17 = new JLabel("Job Post:");
        lb17.setBounds(150, 350, 150, 30);
        lb17.setFont(font);
        lb1.add(lb17);

        lb18 = new JLabel(post);
        lb18.setBounds(330, 350, 300, 30);
        lb18.setFont(font);
        lb1.add(lb18);

        lb19 = new JLabel("DOB:");
        lb19.setBounds(150, 390, 150, 30);
        lb19.setFont(font);
        lb1.add(lb19);

        lb20 = new JLabel(dob);
        lb20.setBounds(330, 390, 300, 30);
        lb20.setFont(font);
        lb1.add(lb20);

        lb21 = new JLabel("Aadhar:");
        lb21.setBounds(150, 430, 150, 30);
        lb21.setFont(font);
        lb1.add(lb21);

        lb22 = new JLabel(aadhar);
        lb22.setBounds(330, 430, 300, 30);
        lb22.setFont(font);
        lb1.add(lb22);

        b1 = new JButton("Print");
        b1.setBounds(160, 580, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        lb1.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(330, 580, 100, 30);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        lb1.add(b2);

        f.add(lb1);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            JOptionPane.showMessageDialog(null, "Printed Successfully");
            f.setVisible(false);
            new HomePage();
        } else if (e.getSource() == b2) {
            f.setVisible(false);
            new View_Employee();  // Make sure this class exists
        }
    }
}

