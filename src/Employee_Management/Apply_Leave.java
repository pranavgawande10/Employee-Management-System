/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee_Management;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
public class Apply_Leave extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton btn1,btn2;
    JPanel p1,p2,p3;
    JTextField tf1,tf2,tf3,tf4;
    Font f,f1;
    Choice ch1,ch2;
    
   
    Apply_Leave()
    {
        super("Apply Employee leave");
        setLocation(450,50);
        setSize(950,450);
        setResizable(false);
        
        f= new Font("Arial",Font.BOLD,25);
        f1 = new Font("Arial",Font.BOLD,16);
        
        l1 = new JLabel("Apply Employee Leave");
        l2 = new JLabel("Select Employee ID");
        l3 = new JLabel("Name");
        l4 = new JLabel("Email");
        l5 = new JLabel("Start Date");
        l6 = new JLabel("End Date");
        l7 = new JLabel("Leave Reason");
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        
        btn1 = new JButton("Submit");
        btn2 = new JButton("Close");
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        
        btn1.setForeground(Color.WHITE);
        btn2.setForeground(Color.WHITE);
        
        btn2.setBackground(Color.RED);
        btn1.setBackground(Color.BLACK);
        
        ch1 = new Choice();
        
        try
        {
            ConnectionClass obj = new ConnectionClass();
            String q = "select eid from employee1";
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch1.add(rest.getString("eid"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        ch2 = new Choice();
        ch2.add("Employee Health Issue");
        ch2.add("Family Member Health Issue");
        ch2.add("Function/Celebration");
        ch2.add("Party");
        ch2.add("Personal Things");
        ch2.add("Others");
        
        l1 .setHorizontalAlignment(JLabel.CENTER);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        ch1.setFont(f1);
        ch2.setFont(f1);
        
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        
        btn1.setFont(f1);
        btn2.setFont(f1);
        
        tf1.setEditable(false);
        tf2.setEditable(false);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2= new JPanel();
        p2.setLayout(new GridLayout(7,2,10,10));
        
        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(ch2);
        p2.add(btn1);
        p2.add(btn2);
        
        p3 =new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icon/Add_Employee.jpg"));
        Image img1  = img.getImage().getScaledInstance(250,400,Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img1);
        l8 = new JLabel(ic1);
        
        p3.add(l8);
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p3,"Center");
        add(p2, "West");
        
        ch1.addMouseListener(new MouseAdapter()
        {
           public void mouseClicked(MouseEvent arg0)
           {
               try
               {
                   ConnectionClass obj2 = new ConnectionClass();
                   String eid = ch1.getSelectedItem();
                   String q1 = "select* from employee1 where eid = '"+eid+"'";
                   ResultSet rest1  =obj2.stm.executeQuery(q1);
                   while(rest1.next())
                   {
                       tf1.setText(rest1.getString("name"));
                       tf2.setText(rest1.getString("email"));
                   }
                   
                   
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
               
           }
        });
        
        
        
        
        
    }
    public void actionPerformed(ActionEvent ev)
    {
        
        if(ev.getSource()==btn1)
        {
            String eid =  ch1.getSelectedItem();
            String name = tf1.getText();
            String email = tf2.getText();
            String start_date = tf3.getText();
            String end_date = tf4.getText();
            String reason = ch2.getSelectedItem();
            String apply_date = new java.util.Date().toString();
            
            try
            {
                ConnectionClass obj1 = new ConnectionClass();
                String q1 = "insert into apply_leave values('" + eid + "','" + name + "','" + email + "','" + start_date + "','" + end_date + "','" + reason + "','" + apply_date + "')";

                int aa = obj1.stm.executeUpdate(q1);
                
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null, "Your data successfully updated");
                    this.setVisible(false);
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please, Fill all Details carefully");
                }
                
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(ev.getSource()==btn2)
        {
            JOptionPane.showMessageDialog(null, "are you sure to close?");
            this.setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new Apply_Leave().setVisible(true);
    }
}
