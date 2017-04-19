import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Raj Srivastava
 */
class DepositWithdrawPanel extends JPanel
{

    public JPanel contentPane;

    public DepositWithdrawPanel(JPanel panel)
    {
        contentPane = panel;
        JLabel l1 = new JLabel("Account Number: ");
        JLabel l2 = new JLabel("Name: ");
        JLabel l3 = new JLabel("Balance: ");
        JLabel l4 = new JLabel("Amount: ");
        JTextField t4 = new JTextField();
        CheckboxGroup c=new CheckboxGroup();
        Checkbox c1=new Checkbox("Deposit",c,false);
        Checkbox c2=new Checkbox("Withdraw",c,true);
        JButton b = new JButton("Go");
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(t4);
        add(c1);
        add(c2);
        add(b);
        setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));

        b.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                double x = Double.parseDouble(t4.getText());

                if(c1.getState() == true) {
                    DbHelper.updateBalance(x);
                    cardLayout.show(contentPane, "UserInfo");
                } else {
                    DbHelper.updateBalance(-x);
                    cardLayout.show(contentPane, "UserInfo");
                }
            }
        });

    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }
}
