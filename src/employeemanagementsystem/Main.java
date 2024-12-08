package employeemanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener
{
    JButton add,back,view,update,delete;
    Main()
    {
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/home.jpg"));
       Image i2=i1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,1120,630);
       add(image);
       
       JLabel heading=new JLabel("Employee Management System");
       heading.setBounds(290,50,550,50);
       heading.setForeground(Color.WHITE);
       heading.setFont(new Font("Times New Roman", Font.BOLD, 40)); 
       image.add(heading);
       
       add=new JButton("Add Employee");
       add.setBounds(440,120,250,60);
       add.setBackground(Color.BLACK);
       add.setOpaque(false);
       add.setForeground(Color.white);
       add.setFont(new Font("Times New Roman", Font.BOLD, 25));
       add.addActionListener(this);
       image.add(add);
       
       view=new JButton("View Employee");
       view.setBounds(440,200,250,60);
       view.setBackground(Color.BLACK);
       view.setOpaque(false);
       view.setForeground(Color.white);
       view.setFont(new Font("Times New Roman", Font.BOLD, 25));
       view.addActionListener(this);
       image.add(view);
       
       update=new JButton("Update Employee");
       update.setBounds(440,280,250,60);
       update.setBackground(Color.BLACK);
       update.setOpaque(false);
       update.setForeground(Color.white);
       update.setFont(new Font("Times New Roman", Font.BOLD, 25));
       update.addActionListener(this);
       image.add(update);
       
       delete=new JButton("Delete Employee");
       delete.setBounds(440,360,250,60);
       delete.setBackground(Color.BLACK);
       delete.setOpaque(false);
       delete.setForeground(Color.white);
       delete.setFont(new Font("Times New Roman", Font.BOLD, 25));
       delete.addActionListener(this);
       image.add(delete);
       
       back=new JButton("Back");
       back.setBounds(440,440,250,60);
       back.setBackground(Color.BLACK);
       back.setOpaque(false);
       back.setForeground(Color.white);
       back.setFont(new Font("Times New Roman", Font.BOLD, 25));
       back.addActionListener(this);
       image.add(back);
        
       setLayout(null);
       setBounds(80,50,1120,630);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==add)
        {
            setVisible(false);
            new AddEmployee();
        }
        else if(e.getSource()==delete)
        {
            setVisible(false);
            new DeleteEmp();
        }
        else if(e.getSource()==view)
        {
            setVisible(false);
            new ViewEmp();
        }
        else if(e.getSource()==update)
        {
            setVisible(false);
            new ViewEmp();
        }
        else
        {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) 
    {
        new Main();
    }
}
