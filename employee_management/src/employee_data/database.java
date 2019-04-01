
package employee_data;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class database 
{
    JFrame f;
    JButton b,b1;
    database()throws Exception
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","garima");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select *from employee");
        ResultSetMetaData rstmt=rs.getMetaData();
        int c=rstmt.getColumnCount();
        Vector column=new Vector(c);
        for(int i=1;i<=c;i++)
        {
            column.add(rstmt.getColumnName(i));
        }
        Vector data=new Vector();
        Vector row=new Vector();
        while(rs.next())
        {
            System.out.println("1");
            row=new Vector(c);
            for(int i=1;i<=c;i++)
            {
                System.out.println("");
                row.add(rs.getString(i));
            }
             data.add(row);
        }
        f=new JFrame();
        f.setSize(2000,1560);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JTable table=new JTable(data,column);
        JScrollPane jsp=new JScrollPane(table);
        table.setRowHeight(25);
        jsp.setBounds(15,100,1890,900);
        f.add(jsp);
        f.setLayout(null);
        f.setVisible(true);
        b=new JButton("Delete");
        b.setBounds(1750,50,100,30);
        f.add(b);
        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int rsel=table.getSelectedRow();
                String id=table.getValueAt(rsel,1).toString();
                try {
                    PreparedStatement stmt2=con.prepareStatement("delete * from employee where ID=?");
                    stmt2.setString(1,id);
                    stmt2.executeUpdate();
                    
                                         ResultSet rs=stmt.executeQuery("select *from employee");
                     ResultSetMetaData rstmt=rs.getMetaData();
                     int c=rstmt.getColumnCount();
                     Vector column=new Vector(c);
                     for(int i=1;i<=c;i++)
                        {
                            column.add(rstmt.getColumnName(i));
                        }
                        Vector data=new Vector();
                        Vector row=new Vector();
                        while(rs.next())
                            {
                                System.out.println("1");
                                row=new Vector(c);
                                for(int i=1;i<=c;i++)
                                    {
                                        System.out.println("");
                                        row.add(rs.getString(i));
                                    }
                                data.add(row);
                            }
                } catch (SQLException ex) {
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        b1=new JButton("Update");
        b1.setBounds(1640,50,100,30);
        f.add(b1);
        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ee)
            {  
                int rsel=table.getSelectedRow();
                int csel=table.getSelectedColumn();
                String cname=table.getColumnName(csel);
                String rss=table.getValueAt(rsel,1).toString();
                
                try {
                    PreparedStatement stmt1 = con.prepareStatement("update employee set "+cname+"=? where id=?");
                    String ch=table.getValueAt(rsel, csel).toString();
                    if(table.getValueAt(rsel, csel) instanceof String)
                        stmt1.setString(1,ch);
                    else if(table.getValueAt(rsel, csel) instanceof Integer)
                    {
                        int cha=Integer.parseInt(ch);
                        stmt1.setInt(1,cha);
                    }
                    else if(table.getValueAt(rsel, csel) instanceof Double)
                    {
                        Double cha=Double.parseDouble(ch);
                        stmt1.setDouble(rsel, cha);
                    }
                    else if(table.getValueAt(rsel, csel) instanceof Date)
                    {
                        Date da=Date.valueOf(ch);
                        stmt1.setDate(rsel, da);
                    }
                    stmt1.setString(2,rss);
                    stmt1.executeUpdate();
                  
                } catch (SQLException ex) {
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[])throws Exception
    {
        database d=new database();
        
    }
    
}
