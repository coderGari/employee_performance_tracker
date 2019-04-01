
package employee_data;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin implements ActionListener
{
JFrame f;
JButton b,b1,b2,back,b3;
JLabel l;
Admin()
{
    f=new JFrame("Administrator block");
    //f.getContentPane().setBackground(Color.gray);
    f.setContentPane(new JLabel(new ImageIcon(((new ImageIcon("paper.jpg")).getImage()).getScaledInstance(900,500,java.awt.Image.SCALE_SMOOTH))));
    f.setSize(900,500);
    f.setLayout(null);
   // ImageIcon fimg=new ImageIcon(((new ImageIcon("C:\\Users\\DELL\\Pictures\\mediaimages\\pattern.jpg")).getImage()).getScaledInstance(900,500,java.awt.Image.SCALE_SMOOTH));
   // JLabel img=new JLabel(fimg);
    //mg.setBounds(0,0,900,500);
    //f.add(img);
    l=new JLabel("ADMINISTRATOR");
    l.setBounds(20,20,300,40);
    l.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,30));
    f.add(l);
    b=new JButton(new ImageIcon(((new ImageIcon("add employee.png")).getImage()).getScaledInstance(150,140,java.awt.Image.SCALE_SMOOTH)));
    b.setBounds(50,80,150,140);
    b.setToolTipText("Add_Employee");
    b.setBorderPainted(false);
    b.setBackground(Color.BLACK);
    b.setOpaque(false);
    f.add(b);
    b1=new JButton(new ImageIcon(((new ImageIcon("employee record.png")).getImage()).getScaledInstance(130,120,java.awt.Image.SCALE_SMOOTH)));
    b1.setBounds(240,80,150,140);
    b1.setToolTipText("Emploee_record");
    b1.setBorderPainted(false);
    b1.setBackground(Color.black);
    b1.setOpaque(false);
    f.add(b1);
   /* b2=new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\DELL\\Pictures\\mediaimages\\Complaints.jpg")).getImage()).getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH)));
    b2.setBounds(430,80,150,140);
    b2.setToolTipText("complaints");
    b2.setBorderPainted(false);
    b2.setBackground(Color.black);
    b2.setOpaque(false);
    f.add(b2);
    b3=new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\DELL\\Pictures\\mediaimages\\icon.png")).getImage()).getScaledInstance(110,110,java.awt.Image.SCALE_SMOOTH)));
    b3.setBounds(590,80,150,140);
    b3.setToolTipText("leave request");
    b3.setBorderPainted(false);
    b3.setBackground(Color.black);
    b3.setOpaque(false);*/
    b.addActionListener(this);
    b1.addActionListener(this);
//    b2.addActionListener(this);
//    f.add(b3);
    back=new JButton(new ImageIcon(((new ImageIcon("back.png")).getImage()).getScaledInstance(50,30,java.awt.Image.SCALE_SMOOTH)));
    back.setBounds(800,0,80,30);
    back.setBackground(Color.ORANGE);
    back.setBorderPainted(false);
    back.setOpaque(false);
    back.addActionListener(this);
    f.add(back);
    f.setVisible(true);    
}

@Override
public void actionPerformed(ActionEvent e)
{
  if(e.getSource()==b)
  {
      employee_database ed= new employee_database();
  }
  if(e.getSource()==b1)
  {
      try {
          database d=new database();
      } catch (Exception ex) {
          Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  if(e.getSource()==back)
  {
      Employee_data ed=new Employee_data();
      f.dispose();
  }
}

public static void main(String args[])
{
    Admin a=new Admin();
}
}

