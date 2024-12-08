package employeemanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmp extends JFrame implements ActionListener
{
    Choice choiceEmp;
    JTable table;
    JButton back,srch,update,print;
    ViewEmp()
    {
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/view.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,700);
       add(image);
       
       JLabel search=new JLabel("Search by Employee ID: ");
       search.setBounds(140,20,280,50);
       search.setFont(new Font("serif", Font.BOLD, 25));
       image.add(search);
       
       choiceEmp=new Choice();
       choiceEmp.setBounds(420,37,150,50);
       image.add(choiceEmp);
       
       table=new JTable();
       JScrollPane scroll=new JScrollPane(table);
       scroll.setBounds(85,80,700,500);
       image.add(scroll);
       try
       {
           Connect c=new Connect();
           ResultSet rs=c.st.executeQuery("select * from emp");
           while(rs.next())
           {
               choiceEmp.add(rs.getString("empno"));
           }
           rs=c.st.executeQuery("select * from emp");
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       
       back=new JButton("Back");
       back.setBounds(200,600,120,40);
       back.setBackground(Color.BLACK);
       back.setOpaque(false);
       back.setForeground(Color.BLACK);
       back.setFont(new Font("serif", Font.BOLD, 20));
       back.addActionListener(this);
       image.add(back);
       
       srch=new JButton("Search");
       srch.setBounds(600,30,100,30);
       srch.setBackground(Color.BLACK);
       srch.setOpaque(false);
       srch.setForeground(Color.BLACK);
       srch.setFont(new Font("serif", Font.BOLD, 20));
       srch.addActionListener(this);
       image.add(srch);
       
       update=new JButton("Update");
       update.setBounds(375,600,120,40);
       update.setBackground(Color.BLACK);
       update.setOpaque(false);
       update.setForeground(Color.BLACK);
       update.setFont(new Font("serif", Font.BOLD, 20));
       update.addActionListener(this);
       image.add(update);
       
       print=new JButton("Print");
       print.setBounds(550,600,120,40);
       print.setBackground(Color.BLACK);
       print.setOpaque(false);
       print.setForeground(Color.BLACK);
       print.setFont(new Font("serif", Font.BOLD, 20));
       print.addActionListener(this);
       image.add(print);
       
       setLayout(null);
       setBounds(200,20,900,700);
       setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Main();
        }
        else if(ae.getSource()==srch)
        {
//            String query="select * from emp where empno='"+choiceEmp.getSelectedItem()+"'";
            try
            {
                Connect c=new Connect();
                ResultSet rs=c.st.executeQuery("select * from emp where empno='"+choiceEmp.getSelectedItem()+"'");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update)
        {
            setVisible(false);
            new UpdateEmp(choiceEmp.getSelectedItem());
        }
        else if(ae.getSource()==print)
        {
            try
            {
                table.print();
            }
            catch(Exception pe)
            {
                pe.printStackTrace();
            }
        }
    }
    public static void main(String[] args) 
    {
        new ViewEmp();
    }
}
