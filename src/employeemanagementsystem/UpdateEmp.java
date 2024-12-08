package employeemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class UpdateEmp extends JFrame implements ActionListener
{
    JTextField deptno,sal;
    JLabel eno,ename;
    JButton update,back;
    String eid;
    UpdateEmp(String eid)
    {
       this.eid=eid;
        
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/add.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,600);
       add(image);
        
       JLabel heading=new JLabel("Update Employee Details");
       heading.setBounds(300, 120, 500, 50);
       heading.setFont(new Font("serif", Font.BOLD, 25));
       image.add(heading);
       
       JLabel name=new JLabel("Name: ");
       name.setBounds(250,170,150,30);
       name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
       image.add(name);
       
       ename=new JLabel();
       ename.setBounds(350,170,250,30);
       ename.setBackground(Color.white);
       image.add(ename);
       
       JLabel empno=new JLabel("Emp No: ");
       empno.setBounds(250,205,150,30);
       empno.setFont(new Font("SAN_SERIF",Font.BOLD,20));
       image.add(empno);
       
       eno=new JLabel();
       eno.setBounds(350,205,150,30);
       eno.setFont(new Font("SAN_SERIF",Font.BOLD,20));
       image.add(eno);
       
       JLabel dno=new JLabel("Dept No: ");
       dno.setBounds(250,240,150,30);
       dno.setFont(new Font("SAN_SERIF",Font.BOLD,20));
       image.add(dno);
       
       deptno=new JTextField();
       deptno.setBounds(350,240,250,30);
       deptno.setBackground(Color.white);
       image.add(deptno);
       
       JLabel salary=new JLabel("Salary: ");
       salary.setBounds(250,275,150,30);
       salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
       image.add(salary);
       
       sal=new JTextField();
       sal.setBounds(350,275,250,30);
       sal.setBackground(Color.white);
       image.add(sal);
       
       try
       {
           Connect c=new Connect();
           String query="select * from emp where empno='"+eid+"'";
           ResultSet rs=c.st.executeQuery(query);
           while(rs.next())
           {
               ename.setText(rs.getString("ename"));
               deptno.setText(rs.getString("deptno"));
               sal.setText(rs.getString("sal"));
               eno.setText(rs.getString("empno"));
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       
       update=new JButton("Update");
       update.setBounds(450,350,150,40);
       update.setBackground(Color.BLACK);
       update.setOpaque(false);
       update.setForeground(Color.BLACK);
       update.addActionListener(this);
       image.add(update);
       
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
        else if(e.getSource()==update)
        {
            String name=ename.getText();
            String salary=sal.getText();
            String dno=deptno.getText();
            String empno=eno.getText();
            try
            {
                Connect c=new Connect();
                String query="update emp set sal='"+salary+"',deptno='"+dno+"'";
                c.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated successfully");
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
        new UpdateEmp("");
    }
}
