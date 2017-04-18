import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Raj Srivastava
 */
class UserInfoPanel extends JPanel
{

    public JPanel contentPane;

    public UserInfoPanel(JPanel panel)
    {
        contentPane = panel;
        JLabel l1 = new JLabel("Account Number: ");
        JLabel l2 = new JLabel("Aadhar Number: ");
        JLabel l3 = new JLabel("Name: ");
        JLabel l4 = new JLabel("Gender: ");
        JLabel l5 = new JLabel("Birth Date: ");
        JLabel l6 = new JLabel("Address: ");
        JLabel l7 = new JLabel("Mobile Number: ");
        JLabel l8 = new JLabel("Email ID: ");
        JTextField t6 = new JTextField();
        JTextField t7 = new JTextField();
        JTextField t8 = new JTextField();
        JButton b1 = new JButton("Deposit");
        JButton b2 = new JButton("Withdraw");
        JButton b3 = new JButton("Exit");
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(l8);
        add(t8);
        add(b1);
        add(b2);
        add(b3);
        setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));

        b1.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Deposit");
            }
        });
        b2.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Withdraw");
            }
        });
        b3.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Opening");
            }
        });
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }
}
