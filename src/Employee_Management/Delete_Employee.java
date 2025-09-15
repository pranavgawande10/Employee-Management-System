package Employee_Management;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Delete_Employee extends JFrame implements ActionListener {
 
    JTable t;
    JButton btn1;
    JTextField tf1;
    JPanel p1,p2,p3;
    String x[] = {"Employee Id", "Name", "Email", "Age","Date of Birth", "Post"};
    String y[][] = new String [20][6];
    int i=0,j=0;
    Font f,f1;
    JLabel l1,l2;
    

    public Delete_Employee() {
        super ("All Employee records");
        setSize(1489,400);
        setLocation(0,10);
        f= new Font("MS UI Gothic", Font.BOLD,17);
        
        try
        {
            ConnectionClass obj = new ConnectionClass();
            String query = "select * from employee1";
            ResultSet rest = obj.stm.executeQuery(query);
            while(rest.next())
            {
               
               y[i][j++] = rest.getString("Eid");
               y[i][j++] = rest.getString("name");
               y[i][j++] = rest.getString("email");
               y[i][j++] = rest.getString("age");
               y[i][j++] = rest.getString("dob");
               y[i][j++] = rest.getString("post");
               
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
        
        f1 = new Font("Lucida Fax",Font.BOLD,26);
        
        l1 = new JLabel("Delete any Employee");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);
        l1.setForeground(Color.YELLOW);
        
        l2 = new JLabel("Employee ID");
        l2.setFont(f1);
        l2.setBackground(Color.GRAY);
        
        tf1 = new JTextField();
        btn1 = new JButton ("Delete Employee");
        tf1.setFont(f);
        btn1.setFont(f);
        
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.RED);
        btn1.addActionListener(this);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,3,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(btn1);
        
        
        p3 = new JPanel();
        p3.setLayout(new GridLayout(2,1,10,10));
        p3.add(p1);
        p3.add(p2);
        p1.setBackground(Color.BLACK);
        p2.setBackground(Color.BLACK);
        p3.setBackground(Color.BLACK);
        
        add(p3,"South");
        add(js);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==btn1)
       {
           String eid = tf1.getText();
           
           try
           {
               ConnectionClass obj1 = new ConnectionClass();
               String q = "delete from employee1 where eid='" +eid+"'";
               String q1 = "delete from apply_leave where eid='" +eid+"'";
               String q2 = "delete from attendance where eid='" +eid+"'";
               String q3 = "delete from salary where eid='" +eid+"'";
               
               int res = obj1.stm.executeUpdate(q);
               
               
               if(res==1)
               {
                   
                   JOptionPane.showMessageDialog(null," Your data successfully Deleted");
                   obj1.stm.executeUpdate(q1);
                   obj1.stm.executeUpdate(q2);
                   obj1.stm.executeUpdate(q3);
                   this.setVisible(false);
                   new Delete_Employee().setVisible(true);
                   
               }
               else
               {
                   JOptionPane.showMessageDialog(null," Data not Deleted");
                   this.setVisible(false);
                   new Delete_Employee().setVisible(true);
               }
               
               
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
       }
    }

    public static void main(String[] args) {
        new Delete_Employee().setVisible(true);
    }
}
