import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

class UserInfoPanel extends JPanel
{

    public JPanel contentPane;

    public UserInfoPanel(JPanel panel)
    {
        contentPane = panel;
        ResultSet rs = DbHelper.getAccDetails();
        try {
            rs.next();
            JLabel l1 = new JLabel("Account Number: " + rs.getString("Account_No"));
            JLabel l2 = new JLabel("Aadhar Number: " + rs.getInt("Aadhar_No"));
            JLabel l3 = new JLabel("Name: " + rs.getString("Name"));
            JLabel l4 = new JLabel("Gender: " + rs.getString("Gender"));
            JLabel l5 = new JLabel("Birth Date: " + rs.getString("Birth_Date"));
            JLabel l6 = new JLabel("Balance: " + rs.getDouble("Balance"));
            JLabel l7 = new JLabel("Address: ");
            JLabel l8 = new JLabel("Mobile Number: ");
            JLabel l9 = new JLabel("Email ID: ");
            JTextField t7 = new JTextField(rs.getString("Address"));
            JTextField t8 = new JTextField(rs.getString("Mobile_No"));
            JTextField t9 = new JTextField(rs.getString("Email_Id"));
            JButton b1 = new JButton("Deposit/Withdraw Money");
            JButton b2 = new JButton("Save");
            JButton b3 = new JButton("Exit");

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(t7);
        add(l8);
        add(t8);
        add(l9);
        add(t9);
        add(b1);
        add(b2);
        add(b3);
        setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));

        b1.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                if(contentPane.getComponentCount() > 4) {
                    contentPane.remove(4);
                }
                contentPane.add(new TransactionPanel(contentPane), "Transaction", 4);
                cardLayout.show(contentPane, "Transaction");
            }
        });
        b2.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DbHelper.updateData(t7.getText(), Long.parseLong(t8.getText()), t9.getText());
                if(contentPane.getComponentCount() > 3) {
                    contentPane.remove(3);
                }
                contentPane.add(new UserInfoPanel(contentPane), "UserInfo", 3);
                contentPane.revalidate();
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
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }
}
