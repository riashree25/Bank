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
            double balance = rs.getDouble("Balance");

            JLabel l1 = new JLabel("Account Number: " + rs.getString("Account_No"));
            JLabel l2 = new JLabel("Name: " + rs.getString("Name"));
            JLabel l3 = new JLabel("Balance: " + balance);
            JLabel l4 = new JLabel("Amount: ");
            JTextField t4 = new JTextField();
            CheckboxGroup c=new CheckboxGroup();
            Checkbox c1=new Checkbox("Deposit",c,false);
            Checkbox c2=new Checkbox("Withdraw",c,true);
            JButton b = new JButton("Go");
            l1.setBounds(100,20,300,40);
            l2.setBounds(100,70,300,40);
            l3.setBounds(100,120,300,40);
            l4.setBounds(100,170,100,40);
            t4.setBounds(200,170,150,40);
            c1.setBounds(150,220,150,40);
            c2.setBounds(150,270,150,40);
            b.setBounds(150,320,150,40);
            setLayout(null);

            add(l1);
            add(l2);
            add(l3);
            add(l4);
            add(t4);
            add(c1);
            add(c2);
            add(b);

            b.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                    //String s = t4.getText();
                    try {
                        if ((t4.getText()) == null) {
                            JOptionPane.showMessageDialog(panel, "Amount is invalid.", "An error occurred", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    catch(NumberFormatException e1)
                        {
                            JOptionPane.showMessageDialog(panel, "Amount is invalid.", "An error occurred", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    double x = Double.parseDouble(t4.getText());

                    if(c1.getState() == true)
                    {
                        DbHelper.updateBalance(x);
                        c1.setState(false);
                        c2.setState(true);
                        if(contentPane.getComponentCount() > 3) {
                            contentPane.remove(3);
                        }
                        contentPane.add(new UserInfoPanel(contentPane), "UserInfo", 3);
                        contentPane.revalidate();
                        cardLayout.show(contentPane, "UserInfo");
                    }
                    else
                    {
                        if(balance < x) {
                            JOptionPane.showMessageDialog(panel, "Not enough balance to debit this amount.", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        DbHelper.updateBalance(-x);
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
