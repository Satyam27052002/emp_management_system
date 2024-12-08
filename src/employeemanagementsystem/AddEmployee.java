package employeemanagementsystem;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;


public class AddEmployee extends JFrame implements ActionListener
{
    Random ran=new Random();
    int number=ran.nextInt(9999),num;
    String numstr=Integer.toString(Math.abs(number));
    JTextField ename,deptno,sal;
    JLabel eno;
    JButton add,back;
    AddEmployee()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/add.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,600);
        add(image);
        
       JLabel heading=new JLabel("Add Employee Details");
       heading.setBounds(320, 120, 500, 50);
       heading.setFont(new Font("serif", Font.BOLD, 25));
       image.add(heading);
       
       JLabel name=new JLabel("Name: ");
       name.setBounds(250,170,150,30);
       name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
       image.add(name);
       
       ename=new JTextField();
       ename.setBounds(350,170,250,30);
       ename.setBackground(Color.white);
       image.add(ename);
       
       if(numstr.length()==4)
       {
           num=number;
       }
       eno=new JLabel("Emp No:    "+num);
       eno.setBounds(250,205,150,30);
       eno.setFont(new Font("SAN_SERIF",Font.BOLD,20));
       image.add(eno);
       
//       empno=new JTextField();
//       empno.setBounds(150,190,250,30);
//       empno.setBackground(new Color(177,252,197));
//       add(empno);
       
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
       
       add=new JButton("Add");
       add.setBounds(450,350,150,40);
       add.setBackground(Color.BLACK);
       add.setOpaque(false);
       add.setForeground(Color.BLACK);
       add.addActionListener(this);
       image.add(add);
       
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
        if(e.getSource()==add)
        {
            String name=ename.getText();
            String salary=sal.getText();
            String dno=deptno.getText();
            String emno=eno.getText().substring(11);
            try
            {
                Connect c=new Connect();
                String query="insert into emp (empno,ename,sal,deptno) values('"+emno+"','"+name+"','"+salary+"','"+dno+"')";
                c.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Main();
            }
            catch(Exception ce)
            {
                ce.printStackTrace();
            }
        }
        else if(e.getSource()==back)
        {
            setVisible(false);
            new Main();
        }
    }
    public static void main(String[] args) 
    {
        new AddEmployee();
    }
}
