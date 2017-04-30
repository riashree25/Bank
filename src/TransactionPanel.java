import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class TransactionPanel extends JPanel
{

    public JPanel contentPane;

    public TransactionPanel(JPanel panel)
    {
        contentPane = panel;
        ResultSet rs = DbHelper.getAccDetails();
        try
        {
            rs.next();
            JLabel l1 = new JLabel("Account Number: " + rs.getString("Account_No"));
            JLabel l2 = new JLabel("Name: " + rs.getString("Name"));
            JLabel l3 = new JLabel("Balance: " + rs.getDouble("Balance"));
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
                    double y = Double.parseDouble(t4.getText());

                    if(c1.getState() == true) {
                        DbHelper.updateBalance(x,y);
                        c1.setState(false);
                        c2.setState(true);
                        if(contentPane.getComponentCount() > 3) {
                            contentPane.remove(3);
                        }
                        contentPane.add(new UserInfoPanel(contentPane), "UserInfo", 3);
                        contentPane.revalidate();
                        cardLayout.show(contentPane, "UserInfo");
                    } else {
                        DbHelper.updateBalance(-x,y);
                        c1.setState(false);
                        c2.setState(true);
                        if(contentPane.getComponentCount() > 3) {
                            contentPane.remove(3);
                        }
                        contentPane.add(new UserInfoPanel(contentPane), "UserInfo", 3);
                        contentPane.revalidate();
                        cardLayout.show(contentPane, "UserInfo");
                    }
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
