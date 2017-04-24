import java.awt.*;
import javax.swing.*;

public class BankApp
{
    public static int accNo;

    public OpeningPanel p1;
    public RegisterPanel p2;
    public LoginPanel p3;

    public void displayGUI()
    {
        JFrame jf = new JFrame("Bank");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new CardLayout());
        p1 = new OpeningPanel(contentPane);
        p2 = new RegisterPanel(contentPane);
        p3 = new LoginPanel(contentPane);
        contentPane.add(p1, "Opening", 0);
        contentPane.add(p2, "Register", 1);
        contentPane.add(p3, "Login", 2);
        jf.setContentPane(contentPane);
        jf.pack();
        jf.setLocationByPlatform(true);
        jf.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new BankApp().displayGUI();
            }
        });
    }
}
