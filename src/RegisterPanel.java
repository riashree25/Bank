import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Raj Srivastava
 */
class RegisterPanel extends JPanel
{

    public JPanel contentPane;

    public RegisterPanel(JPanel panel)
    {
        contentPane = panel;
        JLabel l1 = new JLabel("Aadhar Number");
        JLabel l2 = new JLabel("Name");
        JLabel l3 = new JLabel("Gender");
        JLabel l4 = new JLabel("Birth Date");
        JLabel l5 = new JLabel("Address");
        JLabel l6 = new JLabel("Mobile Number");
        JLabel l7 = new JLabel("Email ID");
        JLabel l8 = new JLabel("User Name");
        JLabel l9 = new JLabel("Password");
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
        JTextField t6 = new JTextField();
        JTextField t7 = new JTextField();
        JTextField t8 = new JTextField();
        JTextField t9 = new JTextField();
        JButton b = new JButton("Submit");
        setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));

        b.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //DbHelper.insert(Integer.parseInt(t1.getText()), t2.getText(), t3.getText(), t4.getText(), t5.getText(),
                  //      Long.parseLong(t6.getText()), t7.getText(), t8.getText(), t9.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Login");
            }
        });

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(l8);
        add(t8);
        add(l9);
        add(t9);
        add(b);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }
}
