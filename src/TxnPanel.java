/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class TxnPanel extends JPanel
{

    public JPanel contentPane;

    public TxnPanel(JPanel panel)
    {
        contentPane = panel;
        ResultSet rs = DbHelper.insertTxn();
        try
        {
            rs.next();
            JLabel l1 = new JLabel("Account Number: " + rs.getString("Account_No"));
            JLabel l2 = new JLabel("Name: " + rs.getString("Name"));
            JLabel l3 = new JLabel("Balance: " + rs.getDouble("Balance"));
            JLabel l4 = new JLabel("Amount: ");
            JTextField t4 = new JTextField();
            JButton b = new JButton("Exit");
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
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }
}*/
