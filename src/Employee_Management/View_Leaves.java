
package Employee_Management;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;

public class View_Leaves extends JFrame implements ActionListener
{
    JTable t;
    JButton btn1;
    JTextField tf1;
    JPanel p1, p2, p3;
    String x[] = {"Employee ID", "Name", "Email", "Start Date", "End Date", "Reason", "Apply Date"};
    String y[][] = new String[20][7];
    int i = 0, j = 0;
    Font f, f1;
    JLabel l1, l2;
    int count=0;
      
    View_Leaves()
    {
        super("All Employee Leave Records");
        setSize(1480, 400);
        setLocation(0, 10);
        f = new Font("MS UI Gothic", Font.BOLD, 17);
        
        try
        {
            ConnectionClass obj = new ConnectionClass();
            String query = "select * from apply_leave";
            ResultSet rest = obj.stm.executeQuery(query);
            while(rest.next())
            {
               count++;
               y[i][j++] = rest.getString("Eid");
               y[i][j++] = rest.getString("name");
               y[i][j++] = rest.getString("email");
               y[i][j++] = rest.getString("start_date");
               y[i][j++] = rest.getString("end_date");
               y[i][j++] = rest.getString("reason");
               y[i][j++] = rest.getString("apply_date");
               i++;
               j=0;
            }
            t = new JTable(y, x);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        t.setFont(f);
       
        JScrollPane js = new JScrollPane(t);
        f1 = new Font("Lucida Fax", Font.BOLD, 25);
        
        l1 = new JLabel("Search Employee Leave");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);
        l1.setForeground(Color.YELLOW);
        
        l2 = new JLabel("Employee ID");
        l2.setFont(f1);
        l2.setForeground(Color.GRAY);
        
        tf1 = new JTextField();
        btn1 = new JButton("Search Leave");
        tf1.setFont(f);
        btn1.setFont(f);
        
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.RED);
        btn1.addActionListener(this);
        
        p1 = new JPanel(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        
        p2 = new JPanel(new GridLayout(1, 3, 10, 10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(btn1);
        
        p3 = new JPanel(new GridLayout(2, 1, 10, 10));
        p3.add(p1);
        p3.add(p2);
        
        p1.setBackground(Color.BLACK);
        p2.setBackground(Color.BLACK);
        p3.setBackground(Color.BLACK);
        
        add(p3, "South");
        add(js);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        String eid = tf1.getText();
        if(e.getSource() == btn1)
        {
            new View_Attendance_single(eid).setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new View_Leaves().setVisible(true);
    }
}
