
package employee_data;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class employee_database implements ActionListener
{
JFrame f;
JButton b;
JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,boder,id,type,shift,salary,hrs;
JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
TextArea ta;
Choice c,c1;
Checkbox cb1,cb2,cb3,cb4,cb5;
String gender,str,str1,status;


employee_database()
{
    f=new JFrame("Employee Database");
    f.setResizable(false);
    f.setLocation(550, 0);
    //f.setBackground(Color.orange);
    f.setSize(700,1000);
    l=new JLabel("======   Personal   ======================================================================================================================");
    l.setBounds(6,10,700,20);
    l.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,20));
    f.add(l);
    l1=new JLabel("Name:-");
    l1.setBounds(20,40,50,30);
    f.add(l1);
    t=new JTextField();
    t.setBounds(80,45,240,30);
    f.add(t);
    l2=new JLabel("E-mail:-");
    l2.setBounds(20,80,50,30);
    f.add(l2);
    t2=new JTextField();
    t2.setBounds(80,80,240,30);
    f.add(t2);
    l3=new JLabel("DOB:-");
    l3.setBounds(20,115,50,30);
    f.add(l3);
    t3=new JTextField();
    t3.setBounds(80,116,240,30);
    f.add(t3);
    l4=new JLabel("Phone:-");
    l4.setBounds(20,150,50,30);
    f.add(l4);
    t4=new JTextField();
    t4.setBounds(80,150,240,30);
    f.add(t4);
    l5=new JLabel("Gender:-");
    l5.setBounds(20,185,50,30);
    f.add(l5);
    CheckboxGroup cbg=new CheckboxGroup();
    cb1=new Checkbox("Male",cbg,false);
    cb2=new Checkbox("Female",cbg,false);
    cb3=new Checkbox("Other",cbg,false);
    cb1.setBounds(80,185,60,30);
    cb2.setBounds(140,185,60,30);
    cb3.setBounds(205,185,60,30);
    f.add(cb1);
    f.add(cb2);
    f.add(cb3);
    l6=new JLabel("status:-");
    l6.setBounds(20,220,50,30);
    f.add(l6);
    CheckboxGroup cbg1=new CheckboxGroup();
    cb4=new Checkbox("married",cbg1,false);
    cb5=new Checkbox("unmarried",cbg1,false);
    cb4.setBounds(80,220,60,20);
    cb5.setBounds(150,220,80,20);
    f.add(cb4);
    f.add(cb5);
    l7=new JLabel("qualification:-");
    l7.setBounds(20,250,80,30);
    f.add(l7);
    c =new Choice();
    c.setBounds(100,253,70,20);
    c.add("b.tech");
    c.add("m.tech");
    c.add("phD");
    f.add(c);
    l8=new JLabel("Country:-");
    l8.setBounds(20,280,70,30);
    f.add(l8);
    t5=new JTextField();
    t5.setBounds(80,283,240,30);
    f.add(t5);
    l9=new JLabel("Address:-");
    l9.setBounds(20,320,60,30);
    f.add(l9);
    ta=new TextArea(200,100);
    ta.setBounds(90,330,400,200);
    f.add(ta);
    
    
    boder=new JLabel("======OFFICIAL=============================================================================");
    boder.setBounds(6,537,700,20);
    boder.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,20));
    f.add(boder);
    id=new JLabel("employee ID:-");
    id.setBounds(20,570,90,30);
    f.add(id);
    t6=new JTextField();
    t6.setBounds(150,573,240,30);
    f.add(t6);
    type=new JLabel("Job type:-");
    type.setBounds(20,610,100,30);
    f.add(type);
    c1=new Choice();
    c1.setBounds(150,613,240,30);
    c1.add("Full time");
    c1.add("part time");
    c1.add("intern");
    f.add(c1);
    shift=new JLabel("Employee_Shift:-");
    shift.setBounds(20,650,100,30);
    f.add(shift);
    t7=new JTextField();
    t7.setBounds(150,653,240,30);
    f.add(t7);
    hrs=new JLabel("Working hrs:-");
    hrs.setBounds(20,690,100,30);
    f.add(hrs);
    t8=new JTextField();
    t8.setBounds(150,693,240,30);
    f.add(t8);
    salary=new JLabel("Salary:-");
    salary.setBounds(20,730,60,30);
    f.add(salary);
    t9=new JTextField();
    t9.setBounds(150,733,240,30);
    f.add(t9);
    l10=new JLabel("Date_of_joinning:-");
    l10.setBounds(20,770,150,30);
    f.add(l10);
    t10=new JTextField();
    t10.setBounds(150,773,240,30);
    f.add(t10);
    l11=new JLabel("Date_of_Retairment:-");
    l11.setBounds(20,810,130,30);
    f.add(l11);
    t11=new JTextField();
    t11.setBounds(150,813,240,30);
    f.add(t11);
    b=new JButton("Submit");
    b.setBounds(310,850,80,30);
    f.add(b);
    cb1.addItemListener(new ItemListener()
    {
        @Override
        public void itemStateChanged(ItemEvent ee)
        {
            if(ee.getStateChange()==1)
            {
                 gender=cb1.getLabel();
            }
        }
    });
    
        cb2.addItemListener(new ItemListener()
    {
        @Override
        public void itemStateChanged(ItemEvent ee)
        {
            if(ee.getStateChange()==1)
            {
                 gender=cb2.getLabel();
            }
        }
    });
        cb3.addItemListener(new ItemListener()
    {
        @Override
        public void itemStateChanged(ItemEvent ee)
        {
            if(ee.getStateChange()==1)
            {
                gender=cb3.getLabel();
            }
        }
    });
    cb4.addItemListener(new ItemListener()
    {
        @Override
        public void itemStateChanged(ItemEvent ea)
        {
            if(ea.getStateChange()==1)
            {
                status=cb4.getLabel();
            }
        }
    });
    
    
    cb5.addItemListener(new ItemListener()
    {
        @Override
        public void itemStateChanged(ItemEvent ea)
        {
            if(ea.getStateChange()==1)
            {
                status=cb5.getLabel();
            }
        }
    });
    b.addActionListener(this);
    f.setBackground(Color.orange); 
    f.setLayout(null);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String args[])
{
    employee_database ed= new employee_database();
}

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        str=c.getItem(c.getSelectedIndex());
        str1=c1.getItem(c1.getSelectedIndex());
    
    try {
        conn();
    } catch (Exception ex) {
        Logger.getLogger(employee_database.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    t.setText(" ");
    t1.setText(" ");
    t2.setText(" ");
    t3.setText(" ");
    t4.setText(" ");
    t5.setText(" ");
    t6.setText(" ");
    t7.setText(" ");
    t8.setText(" ");
    t9.setText(" ");
    t10.setText(" ");
    t11.setText(" ");
    t12.setText(" ");
    ta.setText(" ");
    cb1.setState(false);
    cb2.setState(false);
    cb3.setState(false);
    cb4.setState(false);
    cb5.setState(false);
    
    }
    
    public void conn()throws Exception
    {
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","garima");
        PreparedStatement stmt=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        String name=t.getText();
        String Id=t6.getText();
        String email=t2.getText();
        String dob=t3.getText();
        String sphone=t4.getText();
        long phone=Long.parseLong(sphone);
        String country=t5.getText();
        String address=ta.getText();
        String shift=t7.getText();
        String shr=t8.getText();
        int hr=Integer.parseInt(shr);
        String s= t9.getText();
        int salary=Integer.parseInt(s);
        String join=t10.getText();
        String retaired=t11.getText();
        stmt.setString(1,name);
        stmt.setString(2,Id);
        stmt.setString(3,email);
        stmt.setString(4,dob);
        stmt.setLong(5,phone);
        stmt.setString(6,gender);
        stmt.setString(7,status);
        stmt.setString(8,str);
        stmt.setString(9,country);
        stmt.setString(10,address);
        stmt.setString(11,str1);
        stmt.setString(12,shift);
        stmt.setInt(13,hr);
        stmt.setInt(14,salary);
        stmt.setString(15,join);
        stmt.setString(16,retaired);
        stmt.setNull(17,Types.INTEGER);
        stmt.setNull(18,Types.INTEGER);
        stmt.setNull(19,Types.INTEGER);
        stmt.setNull(20,Types.INTEGER);
        stmt.setNull(21,Types.INTEGER);
        stmt.setNull(22,Types.INTEGER);

        stmt.executeUpdate();
        con.close();
  
    }
}

