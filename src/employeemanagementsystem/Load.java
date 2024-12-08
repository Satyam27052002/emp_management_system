package employeemanagementsystem;
import java.awt.*;
import javax.swing.*;

public class Load extends JFrame
{
    Load()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/connection.gif"));
        Image i2=i1.getImage().getScaledInstance(512, 512, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,512,512);
        add(image);
        
        setLayout(null);
        setBounds(350,80,512,512);
        setVisible(true);
        
        try
        {
            Thread.sleep(5500);
            setVisible(false);
            new Login();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) 
    {
        new Load();
    }
}
