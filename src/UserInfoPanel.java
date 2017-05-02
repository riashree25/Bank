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
            JButton b4 = new JButton("Transaction History");
            l1.setBounds(50,20,300,40);
            l2.setBounds(50,60,300,40);
            l3.setBounds(50,100,300,40);
            l4.setBounds(50,140,300,40);
            l5.setBounds(50,180,300,40);
            l6.setBounds(50,220,300,40);
            l7.setBounds(50,260,300,40);
            l8.setBounds(50,300,300,40);
            l9.setBounds(50,340,300,40);
            t7.setBounds(200,260,250,40);
            t8.setBounds(200,310,250,40);
            t9.setBounds(200,360,250,40);
            b1.setBounds(50,420,200,40);
            b2.setBounds(300,420,100,40);
            b3.setBounds(300,480,100,40);
            b4.setBounds(50,480,200,40);
            setLayout(null);

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
            add(b4);
            add(b2);
            add(b3);

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
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "UserInfo");
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
        b4.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                if(contentPane.getComponentCount() > 5) {
                    contentPane.remove(5);
                }
                contentPane.add(new TxnPanel(contentPane), "Txn", 5);
                cardLayout.show(contentPane, "Txn");
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
