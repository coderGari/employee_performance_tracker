
package employee_data;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class portal 
{
    JFrame f;
    JLabel l,himg;
    JPanel p,p1,home,attend,profil,EditProfil,leave,complaint;
    JButton b1,b2,b3,b4,b5,b6;
    int center = GridBagConstraints.CENTER;
    int north = GridBagConstraints.NORTH;
    int south = GridBagConstraints.SOUTH;
    int east = GridBagConstraints.EAST;
    int west = GridBagConstraints.WEST;
    int nw = GridBagConstraints.NORTHWEST;
    int none = GridBagConstraints.NONE;
    int rel = GridBagConstraints.RELATIVE;
    int vertical = GridBagConstraints.VERTICAL;
    int horizontal = GridBagConstraints.HORIZONTAL;
    Insets in = new Insets(0,0,0,0);
    Insets in2 = new Insets(0,0,0,0);
    Insets in3 = new Insets(0,0,0,0);
    Insets in4 = new Insets(0,0,0,0);
    GridBagConstraints gbc,gbc1;
      public portal() 
     {
         super();
     }
  portal(String username,String password) throws Exception
  {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","garima");
     Statement stmt=con.createStatement();
     ResultSet rs=stmt.executeQuery("select *from employee where NAME='"+username+"' and ID='"+password+"'");
     f=new JFrame(); 
     f.setSize(1900,700);
     f.setContentPane(new JLabel((Icon)((new ImageIcon("C:\\Users\\DELL\\Pictures\\mediaimages\\info1.png")))));
     f.setExtendedState(JFrame.MAXIMIZED_BOTH);
     p=new JPanel();
     p.setBounds(10,20,f.getWidth(),90);
     gbc = new GridBagConstraints(0,0,0,0,0.1,0.1,north,horizontal,in2,0,0);
     p.setBorder(BorderFactory.createLineBorder(Color.black,4, true));
     p.setOpaque(false);
     f.add(p,gbc);
     l=new JLabel("WELCOME "+username);
     l.setBounds(0,20,1000,80);
     l.setForeground(Color.black);
     l.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,60));
     p.add(l);
     
     p1=new JPanel();
     p1.setBounds(10,130,270,800);
     p1.setLayout(null);
     gbc1 = new GridBagConstraints(0,0,0,0,0.1,0.1,west,vertical,in2,0,0);
     p1.setBorder(BorderFactory.createLineBorder(Color.black,3));
     f.add(p1,gbc1);
     
     b1=new JButton("HOME");
     b1.setBounds(5,4,260,50);
     b1.setBorder(BorderFactory.createLineBorder(Color.black,1));
     p1.add(b1);
     
     b2=new JButton("ATTANCDENCE");
     b2.setBounds(5,60,260,50);
     b2.setBorder(BorderFactory.createLineBorder(Color.black,1));
     b2.setOpaque(true);
     p1.add(b2);
     
     b3=new JButton("PROFILE");
     b3.setBounds(5,120,260,50);
     b3.setBorder(BorderFactory.createLineBorder(Color.black,1));
     p1.add(b3);

     b4=new JButton("EDIT PROFILE");
     b4.setBounds(5,180,260,50);
     b4.setBorder(BorderFactory.createLineBorder(Color.black,1));
     p1.add(b4);
     
     b5=new JButton("LEAVE");
     b5.setBounds(5,240,260,50);
     b5.setBorder(BorderFactory.createLineBorder(Color.black,1));
     p1.add(b5);
     
     b6=new JButton("COMPLAINT");
     b6.setBounds(5,300,260,50);
     b6.setBorder(BorderFactory.createLineBorder(Color.black,1));
     p1.add(b6);
     
     home=new JPanel();
     home.setBounds(300,130,1600,800);
     home.setLayout(null);
     home.setOpaque(false);
     ImageIcon img=(new ImageIcon("C:\\Users\\DELL\\Pictures\\mediaimages\\dogs01.gif"));
     himg=new JLabel(img);
     himg.setBounds(500,130,500,500);
     home.add(himg);
     home.setVisible(false);
     f.add(home);
     b1.addActionListener(new ActionListener()
     {
         @Override
         public void actionPerformed(ActionEvent e)
         {
             home.setVisible(true);
             attend.setVisible(false);
             profil.setVisible(false);
             EditProfil.setVisible(false);
             complaint.setVisible(false);
             leave.setVisible(false);
         }
     });
     
     attend=new JPanel();
     attend.setBounds(300,130,1600,800);
     attend.setLayout(null);
     attend.setBorder(BorderFactory.createLineBorder(Color.black,2)); 
     attend.setVisible(false);
     f.add(attend);
     b2.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ee)
         {
             home.setVisible(false);
             attend.setVisible(true);
             profil.setVisible(false);
             EditProfil.setVisible(false);
             complaint.setVisible(false);
            leave.setVisible(false);
         }
     });
     
     profil=new JPanel();
     profil.setBounds(300,130,1600,800);
     profil.setLayout(null);
     profil.setBorder(BorderFactory.createLineBorder(Color.black,2)); 
     profil.setVisible(false);
     while(rs.next())
     {
         JLabel name=new JLabel("NAME:-");
         name.setBounds(140,20,100,30);
         name.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(name);
         JLabel name1=new JLabel(rs.getString(1));
         name1.setBounds(260,20,250,30);
         name1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,30));
         profil.add(name1);
         JLabel id=new JLabel("ID:-");
         id.setBounds(190,180,60,30);
         id.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25)); 
         profil.add(id);
         JLabel id1=new JLabel(rs.getString(2));
         id1.setBounds(260,180,200,30);
         id1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25)); 
         profil.add(id1);
         JLabel dob=new JLabel("DATE OF BIRTH:-");
         dob.setBounds(23,60,230,30);
         dob.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25)); 
         profil.add(dob);
         JLabel dob1=new JLabel(rs.getString(4));
         dob1.setBounds(260,60,250,30);
         dob1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25)); 
         profil.add(dob1);
         JLabel email=new JLabel("EMAIL:-");
         email.setBounds(131,100,120,30);
         email.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25)); 
         profil.add(email);
         JLabel email1=new JLabel(rs.getString(3));
         email1.setBounds(260,100,300,30);
         email1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25)); 
         profil.add(email1);
         JLabel phone=new JLabel("PHONE:-");
         phone.setBounds(130,140,120,30);
         phone.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(phone);
         JLabel phone1=new JLabel(rs.getString(5));
         phone1.setBounds(260,140,200,30);
         phone1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(phone1);
         JLabel gender=new JLabel("GENDER:-");
         gender.setBounds(110,220,150,30);
         gender.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(gender);
         JLabel gender1=new JLabel(rs.getString(6));
         gender1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         gender1.setBounds(260,220,100,30);
         profil.add(gender1);
         JLabel status=new JLabel("STATUS:-");
         status.setBounds(121,260,150,30);
         status.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(status);
         JLabel status1=new JLabel(rs.getString(7));
         status1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         status1.setBounds(260,260,150,30);
         profil.add(status1);
         JLabel quali=new JLabel("QUALIFICATION:-");
         quali.setBounds(8,300,240,30);
         quali.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(quali);
         JLabel quali1=new JLabel(rs.getString(8));
         quali1.setBounds(260,300,60,30);
         quali1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(quali1);
         JLabel cont=new JLabel("COUNTRY:-");
         cont.setBounds(94,340,140,30);
         cont.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(cont);
         JLabel cont1=new JLabel(rs.getString(9));
         cont1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         cont1.setBounds(260,340,100,30);
         profil.add(cont1);
         JLabel add=new JLabel("ADDRESS:-");
         add.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         add.setBounds(101,380,140,30);
         profil.add(add);
         JLabel add1=new JLabel(rs.getString(10));
         add1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         add1.setBounds(260,380,500,30);
         profil.add(add1);
         JLabel job=new JLabel("JOB TYPE:-");
         job.setBounds(96,420,140,30);
         job.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(job);
         JLabel job1=new JLabel(rs.getString(11));
         job1.setBounds(260,420,100,30);
         job1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(job1);
         JLabel shift=new JLabel("SHIFT:-");
         shift.setBounds(147,460,90,30);
         shift.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(shift);
         JLabel shift1=new JLabel(rs.getString(12));
         shift1.setBounds(260,460,100,30);
         shift1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(shift1);
         JLabel hrs=new JLabel("WORKING HRS:-");
         hrs.setBounds(40,500,200,30);
         hrs.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(hrs);
         JLabel hrs1=new JLabel(rs.getString(13));
         hrs1.setBounds(260,500,100,30);
         hrs1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(hrs1);
         JLabel sal=new JLabel("SALARY:-");
         sal.setBounds(120,540,200,30);
         sal.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(sal);
         JLabel sal1=new JLabel(rs.getString(14));
         sal1.setBounds(260,540,100,30);
         sal1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(sal1);
         JLabel doj=new JLabel("DATE OF JOINING:-");
         doj.setBounds(0,580,250,30);
         doj.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         profil.add(doj);
         JLabel doj1=new JLabel(rs.getString(15));
         doj1.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,25));
         doj1.setBounds(260,580,300,30);
         profil.add(doj1);
         
     }
     f.add(profil);
     b3.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ee)
         {
             home.setVisible(false);
             attend.setVisible(false);
             profil.setVisible(true);
             EditProfil.setVisible(false);
             complaint.setVisible(false);
             leave.setVisible(false);
         }
     });
     
     EditProfil=new JPanel();
     EditProfil.setBounds(300,130,1600,800);
     EditProfil.setLayout(null);
     EditProfil.setBorder(BorderFactory.createLineBorder(Color.black,2)); 
     EditProfil.setVisible(false);
     f.add(EditProfil);
     b4.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ee)
         {
             home.setVisible(false);
             attend.setVisible(false);
             profil.setVisible(false);
             complaint.setVisible(false);
             EditProfil.setVisible(true);
             leave.setVisible(false);
         }
     });
     
     leave=new JPanel();
     leave.setBounds(300,130,1600,800);
     leave.setLayout(null);
     leave.setBorder(BorderFactory.createLineBorder(Color.black,2)); 
     leave.setVisible(false);
     f.add(leave);
     b5.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ee)
         {
             home.setVisible(false);
             attend.setVisible(false);
             profil.setVisible(false);
             EditProfil.setVisible(false);
             complaint.setVisible(false);
             leave.setVisible(true);
         }
     });
     
     complaint=new JPanel();
     complaint.setBounds(300,130,1600,800);
     complaint.setLayout(null);
     complaint.setBorder(BorderFactory.createLineBorder(Color.black,2)); 
     complaint.setVisible(false);
     f.add(complaint);
     b6.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ee)
         {
             home.setVisible(false);
             attend.setVisible(false);
             profil.setVisible(false);
             EditProfil.setVisible(false);
             leave.setVisible(false);
             complaint.setVisible(true);
         }
     });
     
     f.setLayout(null);
     f.setVisible(true);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
     
  public static void main(String args[]) throws Exception
  {
      portal portal=new portal("Garima sharma","G2016004831");
  }
}
