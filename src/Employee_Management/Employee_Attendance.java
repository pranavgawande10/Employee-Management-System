
package Employee_Management;

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;

public class Employee_Attendance extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5;
    Choice c1,c2,c3;
    JTextField tf1,tf2;
    JButton btn1,btn2;
    Font f;
    JPanel p;
    
    Employee_Attendance()
    {
        super("Employee_Attendance");
        setSize(450,300);
        setLocation(300,200);
        setResizable(false);
        f= new Font("senserif",Font.BOLD,15);
        
        l1 = new JLabel("Select Employee ID");
        l2 = new JLabel("First Half");
        l3 = new JLabel("Seconf Half");
        l4 = new JLabel("Name");
        l5 = new JLabel("Email");
        
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf1.setFont(f);
        tf2.setFont(f);
        
        tf1.setEditable(false);
        tf2.setEditable(false);
        
        c2 = new Choice();
        c2.add("Present");
        c2.add("Absent");
        
        c3 = new Choice();
        c3.add("Present");
        c3.add("Absent");
        
        c2.setFont(f);
        c3.setFont(f);
        
        btn1 = new JButton("Submit");
        btn2 =new JButton("Close");
        
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        
        btn1.setFont(f);
        btn2.setFont(f);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        
        c1 = new Choice();
        
        try
        {
            ConnectionClass obj = new ConnectionClass();
            String query = "select * from employee1";
            ResultSet rest = obj.stm.executeQuery(query);
            while(rest.next())
            {
               c1.add(rest.getString("Eid"));         
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        p=new JPanel();
        p.setLayout(new GridLayout(6,2,10,10));
        
        p.add(l1);
        p.add(c1);
        p.add(l4);
        p.add(tf1);
        p.add(l5);
        p.add(tf2);
        p.add(l2);
        p.add(c2);
        p.add(l3);
        p.add(c3);
        p.add(btn1);
        p.add(btn2);
        
        add(p); 
        
        c1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                 try
                 {
                    ConnectionClass obj = new ConnectionClass();
                    String eid = c1.getSelectedItem();
                    String query = "Select *from employee1 where Eid='"+eid+"'";
                    ResultSet rest = obj.stm.executeQuery(query);
                    while(rest.next())
                    {
                       tf1.setText(rest.getString("name"));
                       tf2.setText(rest.getString("email"));
                    }
                 }
                 catch(Exception ex)
                 {
                     ex.printStackTrace();
                 }
            }
        
         });
    }
    
    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==btn1)
        {
            String ch_eid= c1.getSelectedItem();
            String ch_first_half = c2.getSelectedItem();
            String ch_second_half = c2.getSelectedItem();
            String name = tf1.getText();
            String email = tf2.getText();
            String dt = new java.util.Date().toString();
            
            try
            {
                  ConnectionClass obj = new ConnectionClass();
                  
                  String query = "insert into attendance values('"+ch_eid+"','"+name+"','"+email+"','"+ch_first_half+"','"+ch_second_half+"','"+dt+"')";
                  obj.stm.executeUpdate(query);
                  JOptionPane.showMessageDialog(null,"data inserted");
                  setVisible(false);
                  
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(e.getSource()==btn2)
        {
            JOptionPane.showMessageDialog(null,"are you sure?");
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new Employee_Attendance().setVisible(true);
    }
}
