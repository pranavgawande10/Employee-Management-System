package Employee_Management;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.Timer;

public class HomePage extends JFrame implements ActionListener {

    Font fTitle, fButton;
    JPanel mainPanel;
    JLabel dateTimeLabel;

    public HomePage() {
        super("Employee Management System");
        setSize(1550, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Fonts
        fTitle = new Font("Segoe UI", Font.BOLD, 36);
        fButton = new Font("Segoe UI", Font.BOLD, 18);

        // Title Panel
        JPanel titlePanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 102, 204), getWidth(), 0, new Color(0, 153, 153));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        titlePanel.setPreferredSize(new Dimension(0, 80));

        JLabel title = new JLabel("Employee Management System", JLabel.CENTER);
        title.setFont(fTitle);
        title.setForeground(Color.WHITE);

        dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        dateTimeLabel.setForeground(Color.WHITE);
        dateTimeLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        startClock();

        titlePanel.add(title, BorderLayout.CENTER);
        titlePanel.add(dateTimeLabel, BorderLayout.EAST);
        add(titlePanel, BorderLayout.NORTH);

        // Main Panel for Buttons
        mainPanel = new JPanel(new GridLayout(4, 3, 20, 20)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(245, 247, 250), getWidth(), getHeight(), new Color(220, 230, 240));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        // Add buttons as cards
        addTile("Complete Profile", "Add_Employee", new Color(72, 126, 176));
        addTile("View Profile", "View_Employee", new Color(39, 174, 96));
        addTile("Update Details", "Update_Details_Data", new Color(155, 89, 182));
        addTile("Take Attendance", "Employee_Attendance", new Color(241, 196, 15));
        addTile("View Attendance", "View_Attendance", new Color(230, 126, 34));
        addTile("Apply Leave", "Apply_Leave", new Color(26, 188, 156));
        addTile("View Leaves", "View_Leaves", new Color(22, 160, 133));
        addTile("Add Salary", "Salary", new Color(46, 204, 113));
        addTile("Generate Salary Slip", "Generate_PaySlip", new Color(41, 128, 185));
        addTile("Delete Employee", "Delete_Employee", new Color(192, 57, 43));
        addTile("Logout", "Logout", new Color(127, 140, 141));

        add(mainPanel, BorderLayout.CENTER);
    }

    // Method to create button tiles
    private void addTile(String text, String command, Color bgColor) {
        JButton btn = new JButton("<html><center>" + text + "</center></html>");
        btn.setFont(fButton);
        btn.setFocusPainted(false);
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setOpaque(true);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        btn.setActionCommand(command);
        btn.addActionListener(this);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        Color hoverColor = bgColor.brighter();
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(bgColor);
            }
        });

        mainPanel.add(btn);
    }

    // Clock for date and time
    private void startClock() {
        Timer timer = new Timer(1000, e -> {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy  HH:mm:ss");
            dateTimeLabel.setText(sdf.format(new Date()));
        });
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Add_Employee": new Add_Employee(); break;
            case "View_Employee": new View_Employee(); break;
            case "Update_Details_Data": new Update_Details_Data().setVisible(true); break;
            case "Employee_Attendance": new Employee_Attendance().setVisible(true); break;
            case "View_Attendance": new View_Attendance().setVisible(true); break;
            case "Apply_Leave": new Apply_Leave().setVisible(true); break;
            case "View_Leaves": new View_Leaves().setVisible(true); break;
            case "Salary": new Salary().setVisible(true); break;
            case "Generate_PaySlip": new Generate_PaySlip().setVisible(true); break;
            case "Delete_Employee": new Delete_Employee().setVisible(true); break;
            case "Logout": System.exit(0); break;
        }
    }

    public static void main(String[] args) {
        new HomePage().setVisible(true);
    }
}
