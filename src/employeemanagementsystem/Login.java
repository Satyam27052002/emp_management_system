package employeemanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;


public class Login extends JFrame implements ActionListener
{
    JTextField name,pw;
    JButton login,back;
    Login()
    {
        JLabel admin=new JLabel("Admin Login");
        admin.setBounds(950,120,250,50);
        admin.setForeground(Color.WHITE);
        admin.setFont(new Font("Times New Roman", Font.BOLD, 40)); 
        add(admin);
        
        JLabel username=new JLabel("User Name: ");
        username.setBounds(900,200,120,30);
        username.setForeground(Color.WHITE);
        username.setFont(new Font("Arial", Font.BOLD, 18)); 
        add(username);
        
        name=new JTextField();
        name.setBounds(1020,200,200,30);
        name.setBackground(Color.white);
        name.setForeground(Color.white);
        name.setBorder(new LineBorder(Color.WHITE, 2));
        name.setOpaque(false);
        name.setFont(new Font("Arial", Font.PLAIN, 18));
        add(name);
        
        JLabel password=new JLabel("Password: ");
        password.setBounds(900,250,120,30);
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Arial", Font.BOLD, 18)); 
        add(password);
        
        pw=new JTextField();
        pw.setBounds(1020,250,200,30);
        pw.setBackground(Color.white);
        pw.setForeground(Color.white);
        pw.setBorder(new LineBorder(Color.WHITE, 2));
        pw.setOpaque(false);
        pw.setFont(new Font("Arial", Font.PLAIN, 18));
        add(pw);
        
        login=new JButton("Login");
        login.setBounds(1020,310,100,30);
        login.setBackground(Color.white);
        login.setForeground(Color.WHITE);
        login.setOpaque(false);
        login.setFont(new Font("Arial", Font.BOLD, 16));
        login.setBorder(new LineBorder(Color.WHITE, 2));
        login.addActionListener(this);
        add(login);
        
        back=new JButton("Back");
        back.setBounds(1020,360,100,30);
        back.setBackground(Color.white);
        back.setOpaque(false);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.setBorder(new LineBorder(Color.WHITE, 2));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1300, 760, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1300,760);
        add(image);
        
        setLayout(null);
        setBounds(0,0,1300,760);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==login)
        {
            try
            {
                String username=name.getText();
                String password=pw.getText();
                
                Connect con=new Connect();
                String query="select * from admin where username= '"+username+"' and password= '"+password+"'";
                ResultSet rs=con.st.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Main();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"invalid username or password");
                }
            }
            catch(Exception se)
            {
                se.getMessage();
            }
        }
        else
        {
            System.exit(0);
        }
    }
    public static void main(String[] args) 
    {
        new Login();
    }
}
