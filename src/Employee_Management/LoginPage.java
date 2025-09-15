/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee_Management;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    LoginPage()
    {
        f = new JFrame("Login");
        
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1 = new JLabel("UserName");
        l1.setBounds(40,70,100,30);
        f.add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,20,100,30);
        f.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);
        
        t2 = new JPasswordField();
        t2.setBounds(150,70,150,30);
        f.add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/icon/qwert.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        f.add(l3);
        
        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setBounds(40,140,120,30);
        b1.addActionListener(this);
        b1.setForeground(Color.WHITE);
        f.add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setBounds(180,140,120,30);
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        f.add(b2);
        
        f.getContentPane();
        f.setSize(500,240);
        f.setLocation(400,300);
        f.setVisible( true);
        
        
       
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
                ConnectionClass obj = new ConnectionClass();
                String name = t1.getText();
                String pass = t2.getText();
                String query = "Select *from logindata where username ='"+name+"' and password='"+pass+"'";
                ResultSet rs =obj.stm.executeQuery(query);
                if(rs.next())
                {
                    
                    new HomePage().setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"wrong user name and password!");
                    f.setVisible(false);
                    f.setVisible(true);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==b2)
        {
            this.f.setVisible(false);
        }
    } 
    public static void main(String args[])
    {
        new LoginPage();
    }
}
