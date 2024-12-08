package employeemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DeleteEmp extends JFrame implements ActionListener
{
    Choice choiceEmpNo;
    JButton delete,back;
    DeleteEmp()
    {
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/add.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,600);
       add(image);
       
       JLabel label=new JLabel("Employee No:");
       label.setBounds(350,150,100,30);
       label.setFont(new Font("serif", Font.BOLD, 15));
       image.add(label);
       
       choiceEmpNo=new Choice();
       choiceEmpNo.setBounds(450,150,150,30);
       image.add(choiceEmpNo);
       try
       {
           Connect c=new Connect();
           ResultSet rs=c.st.executeQuery("select * from emp");
           while(rs.next())
           {
               choiceEmpNo.add(rs.getString("empno"));
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       JLabel name=new JLabel("Name:");
       name.setBounds(350,200,100,30);
       name.setFont(new Font("serif", Font.BOLD, 15));
       image.add(name);
       
       JLabel ename=new JLabel();
       ename.setBounds(450,200,100,30);
       image.add(ename);
       
       JLabel salary=new JLabel("Salary:");
       salary.setBounds(350,250,100,30);
       salary.setFont(new Font("serif", Font.BOLD, 15));
       image.add(salary);
       
       JLabel sal=new JLabel();
       sal.setBounds(450,250,100,30);
       image.add(sal);
       
       JLabel dno=new JLabel("Dept No:");
       dno.setBounds(350,300,100,30);
       dno.setFont(new Font("serif", Font.BOLD, 15));
       image.add(dno);
       
       JLabel deptno=new JLabel();
       deptno.setBounds(450,300,100,30);
       image.add(deptno);
       
       try
       {
           Connect c=new Connect();
           ResultSet rs=c.st.executeQuery("select * from emp where empno='"+choiceEmpNo.getSelectedItem()+"'");
           while(rs.next())
           {
               ename.setText(rs.getString("ename"));
               sal.setText(rs.getString("sal"));
               deptno.setText(rs.getString("deptno"));
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       choiceEmpNo.addItemListener(new ItemListener()
       {
           @Override
           public void itemStateChanged(ItemEvent e)
           {
               try
               {
                  Connect c=new Connect();
                  ResultSet rs=c.st.executeQuery("select * from emp where empno='"+choiceEmpNo.getSelectedItem()+"'");
                  while(rs.next())
                  {
                        ename.setText(rs.getString("ename"));
                        sal.setText(rs.getString("sal"));
                        deptno.setText(rs.getString("deptno"));
                  } 
               }
               catch(Exception ae)
               {
                   ae.printStackTrace();
               }
           }
       });
        
       delete=new JButton("Delete");
       delete.setBounds(450,350,150,40);
       delete.setBackground(Color.BLACK);
       delete.setOpaque(false);
       delete.setForeground(Color.BLACK);
       delete.addActionListener(this);
       image.add(delete);
       
       back=new JButton("Back");
       back.setBounds(250,350,150,40);
       back.setBackground(Color.BLACK);
       back.setOpaque(false);
       back.setForeground(Color.BLACK);
       back.addActionListener(this);
       image.add(back);
        
       setLayout(null);
       setBounds(200,50,900,600);
       setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==back)
        {
            setVisible(false);
            new ViewEmp();
        }
        else if(e.getSource()==delete)
        {
            try
            {
                Connect c=new Connect();
                String query="delete from emp where empno='"+choiceEmpNo.getSelectedItem()+"'";
                c.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee deleted successfully");
                setVisible(false);
                new Main();
            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }
        }
    }
    public static void main(String[] args) 
    {
        new DeleteEmp();
    }
}
