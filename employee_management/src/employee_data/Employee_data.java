
package employee_data;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Employee_data implements ActionListener {
    JFrame f;
    JButton b;
    JLabel l;
    JTextField t,t1;
    JTextField jp;
    JRootPane rp;
    Employee_data() 
    {
        f=new JFrame("login");
        f.getContentPane().setBackground(Color.BLACK);
        l = new JLabel("LOGIN");
        l.setBounds(400,100,300,50);
        l.setForeground(Color.white);
        l.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,30));
        t=new JTextField("Username");
        t.setCaretColor(Color.white);
        t.setBounds(280,150,350,40);
        t.setBackground(Color.DARK_GRAY);   
        t.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,20));
        t.setForeground(Color.GRAY);
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ee)
                {
                  t.setText("");  
                }
        });
        jp=new JPasswordField("Password");
        jp.setCaretColor(Color.white);
        jp.setBounds(280,200,350,40);
        jp.setBackground(Color.darkGray);
        jp.setForeground(Color.GRAY);
        jp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ee)
                {
                  jp.setText("");
                }
        });
        b=new JButton("Let me in");
        b.setBounds(280,250,350,40);
        b.addActionListener(this);
        f.add(l);
        f.add(jp);
        f.add(t);
        f.add(b);
        f.add(t);
        
        f.setSize(900,500);
        f.setLocation(500,300);
        f.setResizable(false);
        f.setLayout(null);
        f.setVisible(true);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  

    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getSource()==b)
       {
             conn();
       } 
   }
    public void conn()
    {
        String username=t.getText();
        String password=jp.getText();
        try {
            System.out.println("running1");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("running2");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","garima");
            System.out.println("running3");
            Statement stmt=con.createStatement();
            System.out.println("running4");
           // stmt.executeQuery("create table employee(Name varchar(20),ID varchar(12),Email varchar(30),DOB DATE,phone number(10),Gender varchar(10),status varchar(10),Qualification varchar(20),Country varchar(10),Address varchar(30),Employee_type varchar(10),Shift varchar(10),Employee_hrs_per_day number(5),salary number(10),Date_of_joinning DATE,Expire_Date DATE,Q1 number(5),Q2 number(5),Q3 number(5),Q4 number(5),Q5 number(5),total number(10))");  
            System.out.println("running5");
            ResultSet rs =stmt.executeQuery("select NAME,ID from employee where ID='"+password+"' ");
           // System.out.println(rs.next());
            System.out.println("running10");
           if("Admin".equals(username)&&"G2016004831".equals(password))
            {
               Admin a=new Admin();
               f.dispose();
            }
            else if("Manager".equals(username) && "G2016004831".equals(password))
            {
                 manager m=new manager();
                 f.dispose();
            }
            else
            {
               
                while(rs.next())
            {
                System.out.println("running7");
                if(rs.getString(1).equals(username)&&rs.getString(2).equals(password))
                {
                    
                    JOptionPane.showMessageDialog(rp,"login successfully");
                   // portal portal=new portal(username,password);
                }
                else
                {
                    System.out.println(rs.getString(1) + rs.getString(2));
                    JOptionPane.showMessageDialog(rp,"INVALID USERNAME OR PASSWORD");
                }
            }
            }
            System.out.println("running8");
            con.close();
            
        } catch(Exception e) {System.out.println("database is not running");}
    }
    
    
     public static void main(String[] args) 
    {
        Employee_data ed=new Employee_data();
    }
    
}
    