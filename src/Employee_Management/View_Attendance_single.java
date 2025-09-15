/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee_Management;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
public class View_Attendance_single extends JFrame implements ActionListener {

    JTable t;
 
    String x[] = {"Employee ID","Name","Email","First Half","Second Half","Date"};
    String y[][] = new String [20][6];
    int i =0,j=0;
    Font f,f1;
    int count=0;
  
    
    View_Attendance_single(String eid)
    {
        super("Particular Employee attendance records");
        setSize(1480,400);
        setLocation(0,10);
        
        f= new Font("MS UI Gothic",Font.BOLD,17);
        
        try
        {
            ConnectionClass obj = new ConnectionClass();
            String query = "select * from attendance where Eid='"+eid+"'";
            ResultSet rest = obj.stm.executeQuery(query);
            while(rest.next())
            {
               count++;
               y[i][j++] = rest.getString("Eid");
               y[i][j++] = rest.getString("name");
               y[i][j++] = rest.getString("email");
               y[i][j++] = rest.getString("first_half");
               y[i][j++] = rest.getString("second_half");
               y[i][j++] = rest.getString("day_date");
               i++;
               j=0;
            }
            if(count==0)
            {
                JOptionPane.showMessageDialog(null,"No Record Found.");
                
            }
            else
            {
                t= new JTable(y,x);
                t.setBackground(Color.BLACK);
                t.setForeground(Color.WHITE);
                t.setFont(f);
                setSize(1480,400);
                setLocation(0,10);
                JScrollPane js = new JScrollPane(t);
                add(js);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
