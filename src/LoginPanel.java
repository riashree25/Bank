import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

class LoginPanel extends JPanel
{

    public JPanel contentPane;

    public LoginPanel(JPanel panel)
    {
        contentPane = panel;
        JLabel l1=new JLabel("User Name");
        JLabel l2=new JLabel("Password");
        JTextField t1=new JTextField();
        JPasswordField t2=new JPasswordField();
        JButton b=new JButton("Go");
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b);
        setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));

        b.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                ResultSet rs = DbHelper.selectFromUserPwd(t1.getText());
                try {
                    if(rs.next() == false) {
                        JOptionPane.showMessageDialog(panel, "UserName not found in db.", "An error occurred", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if(!(rs.getString("Password").equals(t2.getText()))) {
                        JOptionPane.showMessageDialog(panel, "Password is wrong", "An error occurred", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    BankApp.accNo = rs.getInt("Account_No");
                    t1.setText("");
                    t2.setText("");

                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                }

                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                if(contentPane.getComponentCount() > 3) {
                    contentPane.remove(3);
                }
                contentPane.add(new UserInfoPanel(contentPane), "UserInfo", 3);
                if(contentPane.getComponentCount() > 4) {
                    contentPane.remove(4);
                }
                contentPane.add(new TransactionPanel(contentPane), "Transaction", 4);
                contentPane.revalidate();
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
