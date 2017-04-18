import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Raj Srivastava
 */
class WithdrawPanel extends JPanel
{

    public JPanel contentPane;

    public WithdrawPanel(JPanel panel)
    {
        contentPane = panel;
        JLabel l1 = new JLabel("Account Number: ");
        JLabel l2 = new JLabel("Name: ");
        JLabel l3 = new JLabel("Balance: ");
        JLabel l4 = new JLabel("Amount: ");
        JTextField t4 = new JTextField();
        JButton b = new JButton("Withdraw");
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(t4);
        add(b);
        setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));

        b.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "UserInfo");
            }
        });
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }
}
