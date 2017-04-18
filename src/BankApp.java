import java.awt.*;
import javax.swing.*;

public class BankApp
{
    public static int accNo;

    public JPanel contentPane;
    public OpeningPanel p1;
    public RegisterPanel p2;
    public LoginPanel p3;
    public UserInfoPanel p4;
    public DepositPanel p5;
    public WithdrawPanel p6;

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
        p4 = new UserInfoPanel(contentPane);
        p5 = new DepositPanel(contentPane);
        p6 = new WithdrawPanel(contentPane);
        contentPane.add(p1, "Opening");
        contentPane.add(p2, "Register");
        contentPane.add(p3, "Login");
        contentPane.add(p4, "UserInfo");
        contentPane.add(p5, "Deposit");
        contentPane.add(p6, "Withdraw");
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
