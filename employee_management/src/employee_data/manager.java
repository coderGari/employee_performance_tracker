
package employee_data;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class manager implements ActionListener
{
  JFrame f;
  JPanel p,p1,temp;
  JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
  JButton b,b1,feedback,attend,back,submit,cal,submit1;
  JTable tb;
  JScrollPane sp;
  int i=1,rows,columns,n=0,sum=0,a=0;
  static int rc,cc;
  String ab;
  TextField t,t1;
  String str,str1,fa="false";
  JRootPane rp;
  static JTable table;
  manager()
  {
      f=new JFrame("manager form");
      f.setContentPane(new JLabel((Icon)((new ImageIcon("feedback1.jpg")))));
      feedback=new JButton(new ImageIcon(((new ImageIcon("feedbackicon.png")).getImage()).getScaledInstance(300,200,java.awt.Image.SCALE_SMOOTH)));
      feedback.setBounds(800,300,300,200);
      feedback.setBackground(Color.white);
      feedback.setOpaque(false);
      feedback.setBorderPainted(false);
      feedback.setToolTipText("FEEDBACK");
      f.add(feedback);
      attend=new JButton(new ImageIcon(((new ImageIcon("attend.png")).getImage()).getScaledInstance(110,110,java.awt.Image.SCALE_SMOOTH)));
      attend.setBounds(800,520,300,200);
      attend.setBackground(Color.white);
      attend.setOpaque(false);
      attend.setBorderPainted(false);
      attend.setToolTipText("ATTENDANCE");
      f.add(attend);
      p=new JPanel();
      p.setBounds(0,0,2000,150);
      p.setBackground(Color.green);
      p.setLayout(null);
      p.setVisible(false);
      f.add(p);
      f.setSize(900,1000);
      f.setLayout(null);
      l=new JLabel("Name:-");
      l.setBounds(1450,10,50,30);
      p.add(l);
      t=new TextField();
      t.setBounds(1480,10,170,30);
      p.add(t);
      l1=new JLabel("  ID:-");
      l1.setBounds(1660,10,30,30);
      p.add(l1);
      t1=new TextField();
      t1.setBounds(1700,10,170,30);
      p.add(t1);
      back=new JButton(new ImageIcon(((new ImageIcon("back.png")).getImage()).getScaledInstance(70,70,java.awt.Image.SCALE_SMOOTH)));
      back.setBounds(0,0,70,70);
      back.setBackground(Color.red);
      back.setOpaque(false);
      back.setBorderPainted(false);
      p.add(back);
      b=new JButton("ENTER");
      b.setBounds(1780,50,100,35);
      p.add(b);
      b.addActionListener(this);
      feedback.addActionListener(this);
      back.addActionListener(this);
      attend.addActionListener(this);
      p1=new JPanel();
      p1.setBounds(655,160,655,780);
      p1.setBackground(new Color(0,0,0,0)); 
      p1.setVisible(false); 
      f.add(p1);
      f.setExtendedState(JFrame.MAXIMIZED_BOTH);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
  }
  
  @Override
  public void actionPerformed(ActionEvent e)
  {
      if(e.getSource()==attend)
      {
          p.setVisible(false);
          p1.setVisible(false);
          feedback.setVisible(false);
          attend.setVisible(false);
          try {
              attendance();
          } catch (Exception ex) {
              Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      if(e.getSource()==back)
      {
          p.setVisible(false);
          p1.setVisible(false);
          feedback.setVisible(true);
          attend.setVisible(true);
          sp.setVisible(false);
          table.setVisible(false);
          submit1.setVisible(false);
          cal.setVisible(false);
          
      }
      if(e.getSource()==feedback)
      {
          
          feedback.setBounds(800,300,300,200);
          p.setVisible(true);
          feedback.setVisible(false);
          attend.setVisible(false);
      }
      if(e.getSource()==b)
      {
          if("".equals(t.getText())||"".equals(t1.getText()))
             {
                JOptionPane.showMessageDialog(rp,"INVALID NAME OR ID");
             }
          else
          {
               try {
              
                conn();
               
          } catch (Exception ex) {
              Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
          }
          }
      }
     
  }
  
  public void conn()throws Exception
  {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","garima");
      str=t1.getText();
      Statement stmt1=con.createStatement();
      ResultSet rs=stmt1.executeQuery("select NAME,ID from employee where ID='"+str+"'");
      while(rs.next())
      {
           fa="true";
          System.out.println(fa);
      
      PreparedStatement stmt=con.prepareStatement("update employee set Q1=?,Q2=?,Q3=?,Q4=?,Q5=?,total=? where ID=?");
      l7=new JLabel("Name :-");
      l7.setBounds(10,10,80,30);
      l7.setForeground(Color.black);
      l7.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,20)); 
      p1.add(l7);
      l8=new JLabel(t.getText());
      l8.setBounds(90,10,150,30);
      l8.setForeground(Color.black);
      l8.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,20)); 
      p1.add(l8);
      l9=new JLabel("ID :-");
      l9.setBounds(240,10,50,30);
      l9.setForeground(Color.black);
      l9.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,20)); 
      p1.add(l9);
      l10=new JLabel(t1.getText());
      l10.setBounds(285,10,150,30);
      l10.setForeground(Color.black);
      l10.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,20)); 
      p1.add(l10);    
      DefaultTableModel model;
      model = new DefaultTableModel()
      {
          @Override
          public Class getColumnClass(int column)
          {
            switch(column)
              {
                case 0: return String.class;
                case 1: return Boolean.class;
                case 2: return Boolean.class;
                case 3: return Boolean.class;
                case 4: return Boolean.class;
                default: return String.class;
            }
          }
      };
      JTable tb=new JTable();
      tb.setModel(model);
      model.addColumn("grading scheme");
      model.addColumn("5");
      model.addColumn("4");
      model.addColumn("3");
      model.addColumn("2");
      
      model.addRow(new Object[0]);
      model.setValueAt("Employee work quality", 0, 0);
      model.setValueAt(false, 0, 1);
      model.setValueAt(false, 0, 2);
      model.setValueAt(false, 0, 3);
      model.setValueAt(false, 0, 4);
      
      model.addRow(new Object[0]);
      model.setValueAt("attendance", 1, 0);
      model.setValueAt(false, 1, 1);
      model.setValueAt(false, 1, 2);
      model.setValueAt(false, 1, 3);
      model.setValueAt(false, 1, 4);
   
      model.addRow(new Object[0]);
      model.setValueAt("Accomplish of job deadline", 2, 0);
      model.setValueAt(false, 2, 1);
      model.setValueAt(false, 2, 2);
      model.setValueAt(false, 2, 3);
      model.setValueAt(false, 2, 4);
       
      model.addRow(new Object[0]);
      model.setValueAt("Employee Discipline", 3, 0);
      model.setValueAt(false, 3, 1);
      model.setValueAt(false, 3, 2);
      model.setValueAt(false, 3, 3);
      model.setValueAt(false, 3, 4);
     
      model.addRow(new Object[0]);
      model.setValueAt("Overtime", 4, 0);
      model.setValueAt(false, 4, 1);
      model.setValueAt(false, 4, 2);
      model.setValueAt(false, 4, 3);
      model.setValueAt(false, 4, 4);
      rows=tb.getRowCount();
      columns=tb.getColumnCount();
      tb.setRowHeight(70);   
      TableColumnModel columnmodel=tb.getColumnModel();
      columnmodel.getColumn(0).setPreferredWidth(202);
      tb.setForeground(Color.white);
      tb.setFont(new Font(Font.SERIF,Font.TRUETYPE_FONT+Font.BOLD,20));
      tb.setBackground(Color.darkGray);
      tb.setForeground(Color.white);
      tb.setBorder(BorderFactory.createLineBorder(Color.black,1));
      tb.setGridColor(Color.black);
      //tb.setBounds(2,100,650,380);
      tb.setRowSelectionAllowed(false);
      p1.setLayout(null);
      JScrollPane sp=new JScrollPane();
      sp.setBounds(2,100,650,376);
      sp.setViewportView(tb);
      sp.setBackground(Color.pink);
      p1.add(sp);
    //p1.add(tb);
      b1=new JButton("Submit");
      b1.setBounds(550,486,90,30);
      p1.add(b1);
      b1.addActionListener(new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent ee)
       {
           try {
               for(int x=0;x<rows;x++)
               {
                   for(int j=1;j<columns;j++)
                   {
                       boolean ischecked = ((Boolean)tb.getModel().getValueAt(x,j));
                       if(ischecked==true)
                       {
                           String value=tb.getColumnName(j);
                           n=Integer.parseInt(value);
                           sum=sum+n;
                       }//tb.setValueAt(ee, rows, columns);
                   }
                   stmt.setInt(x+1,0);
                   stmt.setInt(x+1,n);
               }
               stmt.setInt(6,0);
               stmt.setInt(6,sum);
               System.out.println(sum);
               stmt.setString(7,str);
               stmt.executeUpdate();
               con.close();
           } catch (SQLException ex) {
               Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
       });
      p1.setVisible(true);
      }
      if(fa=="false")
      {
        JOptionPane.showMessageDialog(rp,"INVALID NAME OR ID");  
      }


      
  }
   
  public void attendance()throws Exception
  {
      submit1=new JButton("submit");
      submit1.setBounds(1780,60,100,30);
      submit1.setVisible(true);
      f.add(submit1);
      cal=new JButton("cal %");
      cal.setBounds(1700,60,70,30);
      cal.setVisible(true);
      f.add(cal);
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","garima");
      Statement stmt=con.createStatement();
      System.out.println("table creating");
      // stmt.executeQuery("create table attend(NAME varchar(100),ID varchar(12),day_1 number(1),day_2 number(1),day_3 number(1),day_4 number(1),day_5 number(1),day_6 number(1), day_7 number(1),day_8 number(1),day_9 number(1),day_10 number(1),day_11 number(1),day_12 number(1),day_13 number(1),day_14 number(1),day_15 number(1),day_16 number(1),day_17 number(1),day_18 number(1),day_19 number(1),day_20 number(1),day_21 number(1),day_22 number(1),day_23 number(1),day_24 number(1),day_25 number(1),day_26 number(1),day_27 number(1),day_28 number(1),day_29 number(1),day_30 number(1))");
      System.out.println("table created");
      ResultSet rs= stmt.executeQuery("select * from attend");
           DefaultTableModel model;
      model = new DefaultTableModel()
      {
          @Override
          public Class getColumnClass(int column)
          {
            switch(column)
              {
                case 0: return String.class;
                case 1: return String.class;
                case 2: return Integer.class;
                case 3: return Integer.class;
                case 4: return Integer.class;
                default: return String.class;
            }
          }
      }; 
      table=new JTable();
      table.setModel(model);
      model.addColumn("NAME");
      model.addColumn("ID");
      for(int n=1;n<=31;n++)
      {
          model.addColumn(n);
      }
      model.addColumn("total");
      
      JScrollPane sp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      sp.setBounds(10,100,1900,376);
      f.add(sp);
      while(rs.next())
      {
          System.out.println(rs.getString(1));
          System.out.println(rs.getString(2));
          System.out.println(rs.getString(4));
          model.addRow(new Object[0]);
          model.setValueAt(rs.getString(1), a, 0);
          model.setValueAt(rs.getString(2), a, 1); 
          model.setValueAt(rs.getString(3), a, 2);
          model.setValueAt(rs.getString(4), a, 3);
          model.setValueAt(rs.getString(5), a, 4);
          model.setValueAt(rs.getString(6), a, 5);
          model.setValueAt(rs.getString(7), a, 6);
          model.setValueAt(rs.getString(8), a, 7);
          model.setValueAt(rs.getString(9), a, 8);
          model.setValueAt(rs.getString(10), a, 9);
          model.setValueAt(rs.getString(11), a, 10);
          model.setValueAt(rs.getString(12), a, 11);
          model.setValueAt(rs.getString(13), a, 12);
          model.setValueAt(rs.getString(14), a, 13);
          model.setValueAt(rs.getString(15), a, 14);
          model.setValueAt(rs.getString(16), a, 15);
          model.setValueAt(rs.getString(17), a, 16);
          model.setValueAt(rs.getString(18), a, 17);
          model.setValueAt(rs.getString(19), a, 18);
          model.setValueAt(rs.getString(20), a, 19);
          model.setValueAt(rs.getString(21), a, 20);
          model.setValueAt(rs.getString(22), a, 21);
          model.setValueAt(rs.getString(23), a, 22);
          model.setValueAt(rs.getString(24), a, 23);
          model.setValueAt(rs.getString(25), a, 24);
          model.setValueAt(rs.getString(26), a, 25);
          model.setValueAt(rs.getString(27), a, 26);
          model.setValueAt(rs.getString(28), a, 27);
          model.setValueAt(rs.getString(29), a, 28);
          model.setValueAt(rs.getString(30), a, 29);
          model.setValueAt(rs.getString(31), a, 30);
          model.setValueAt(rs.getString(32), a, 31);
          model.setValueAt(rs.getString(33), a, 32);
          model.setValueAt(rs.getBigDecimal(34), a, 33);
          
        a++;
        
      }
      
      submit1.addActionListener(new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
             
             int rowcount=table.getRowCount();
             int b=table.getSelectedColumn();
             int da=b-1;
             System.out.println("coloum "+b);
             System.out.println(da);

                    for(rc=0;rc<rowcount;rc++)
                        {if(table.getValueAt(rc,b)!="null")
                        {
                            System.out.println(rowcount);
                        try {   String id=table.getValueAt(rc,1).toString();
                                PreparedStatement stmt1=con.prepareStatement("update attend set day_"+da+"=? where ID=?");
                                ab=table.getValueAt(rc,b).toString();
                                int num=Integer.parseInt(ab);                             
                                stmt1.setInt(1,num);
                                stmt1.setString(2,id);
                                System.out.println(num);
                                stmt1.executeUpdate();
                        } catch (SQLException ex) {
                            Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
              
                        }
           }
         });
      TableColumnModel columnmodel=table.getColumnModel();
      columnmodel.getColumn(0).setPreferredWidth(300);
      columnmodel.getColumn(1).setPreferredWidth(250);
      table.setRowHeight(20);

      cal.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             /* try {
                  percentage();
              } catch (Exception ex) {
                  Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
              }*/
          }
      });
      //con.close();
  }
  
 /* public void percentage()throws Exception
  {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","garima");

      int sum=0;
      double p=0.0;
      int rcount=table.getRowCount();
      int ccount=table.getColumnCount();
     for(int r=0;r<rcount;r++)
     {
         PreparedStatement stmt2=con.prepareStatement("update attend set total=?");
          for(int c=2;c<ccount;c++)
             {
                 if(table.getValueAt(r,c).toString()!="null")
                 {
                     System.out.println(table.getValueAt(r,c));
                      String value=table.getValueAt(r,c).toString();
                      int n=Integer.parseInt(value);  
                      sum=sum+n;
                 }
             }
          p=((sum/31)*100);
         stmt2.setDouble(1,p);
     }
  }*/
  
  public static void main(String args[])
  {
      manager m=new manager();
  }
  
}

