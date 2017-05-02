import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JPasswordField t9 = new JPasswordField();
        JButton b = new JButton("Submit");
        l1.setBounds(50,20,300,40);
        l2.setBounds(50,70,300,40);
        l3.setBounds(50,120,300,40);
        l4.setBounds(50,170,300,40);
        l5.setBounds(50,220,300,40);
        l6.setBounds(50,270,300,40);
        l7.setBounds(50,320,300,40);
        l8.setBounds(50,370,300,40);
        l9.setBounds(50,420,300,40);
        t1.setBounds(200,20,250,40);
        t2.setBounds(200,70,250,40);
        t3.setBounds(200,120,250,40);
        t4.setBounds(200,170,250,40);
        t5.setBounds(200,220,250,40);
        t6.setBounds(200,270,250,40);
        t7.setBounds(200,320,250,40);
        t8.setBounds(200,370,250,40);
        t9.setBounds(200,420,250,40);
        b.setBounds(200,480,100,40);
        setLayout(null);

        b.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DbHelper.insertUserData(Integer.parseInt(t1.getText()), t2.getText(), t3.getText(), t4.getText(), t5.getText(),
                        Long.parseLong(t6.getText()), t7.getText(), t8.getText(), new String(t9.getPassword()));
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
