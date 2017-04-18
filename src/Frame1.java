import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame1
{
    public JPanel contentPane;
    public Start p1;
    public Create p2;
    public Open p3;
    public Data p4;
    public Deposit p5;
    public Withdraw p6;

    public void displayGUI()
    {
        JFrame jf = new JFrame("Bank");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new CardLayout());
        p1 = new Start(contentPane);
        p2 = new Create(contentPane);
        p3 = new Open(contentPane);
        p4 = new Data(contentPane);
        p5 = new Deposit(contentPane);
        p6 = new Withdraw(contentPane);
        contentPane.add(p1, "Panel 1");
        contentPane.add(p2, "Panel 2");
        contentPane.add(p3, "Panel 3");
        contentPane.add(p4, "Panel 4");
        contentPane.add(p5, "Panel 5");
        contentPane.add(p6, "Panel 6");
        jf.setContentPane(contentPane);
        jf.pack();
        jf.setLocationByPlatform(true);
        jf.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Frame1().displayGUI();
            }
        });
    }
}

class Start extends JPanel
{
    public JPanel contentPane;

    public Start(JPanel panel)
    {

        contentPane = panel;
        CheckboxGroup c=new CheckboxGroup();
        Checkbox c1=new Checkbox("Create Account",c,false);
        Checkbox c2=new Checkbox("Open Account",c,true);
        JButton b=new JButton("Go");
        b.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();

                if(c1.getState() == true) {
                    cardLayout.show(contentPane, "Panel 2");
                } else {
                    cardLayout.show(contentPane, "Panel 3");
                }
            }
        });
        add(c1);
        add(c2);
        add(b);
        setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }
}

class Create extends JPanel
{

    public JPanel contentPane;

    public Create(JPanel panel)
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
                //Mysql.insert(Integer.parseInt(t1.getText()), t2.getText(), t3.getText(), t4.getText(), t5.getText(),
                  //      Long.parseLong(t6.getText()), t7.getText(), t8.getText(), t9.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Panel 3");
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

class Open extends JPanel
{

    public JPanel contentPane;

    public Open(JPanel panel)
    {
        contentPane = panel;
        JLabel l1=new JLabel("User Name");
        JLabel l2=new JLabel("Password");
        JTextField t1=new JTextField();
        JTextField t2=new JTextField();
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
                Mysql.select(t1.getText(), t2.getText());


                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Panel 4");
            }
        });
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }
}

class Data extends JPanel
{

    public JPanel contentPane;

    public Data(JPanel panel)
    {
        contentPane = panel;
        JLabel l1 = new JLabel("Account Number: ");
        JLabel l2 = new JLabel("Aadhar Number: ");
        JLabel l3 = new JLabel("Name: ");
        JLabel l4 = new JLabel("Gender: ");
        JLabel l5 = new JLabel("Birth Date: ");
        JLabel l6 = new JLabel("Address: ");
        JLabel l7 = new JLabel("Mobile Number: ");
        JLabel l8 = new JLabel("Email ID: ");
        JTextField t6 = new JTextField();
        JTextField t7 = new JTextField();
        JTextField t8 = new JTextField();
        JButton b1 = new JButton("Deposit");
        JButton b2 = new JButton("Withdraw");
        JButton b3 = new JButton("Exit");
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(l8);
        add(t8);
        add(b1);
        add(b2);
        add(b3);
        setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));

        b1.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Panel 5");
            }
        });
        b2.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Panel 6");
            }
        });
        b3.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Panel 1");
            }
        });
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }
}

class Deposit extends JPanel
{

    public JPanel contentPane;

    public Deposit(JPanel panel)
    {
        contentPane = panel;
        JLabel l1 = new JLabel("Account Number: ");
        JLabel l2 = new JLabel("Name: ");
        JLabel l3 = new JLabel("Balance: ");
        JLabel l4 = new JLabel("Amount: ");
        JTextField t4 = new JTextField();
        JButton b = new JButton("Deposit");
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
                cardLayout.show(contentPane, "Panel 4");
            }
        });
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }
}

class Withdraw extends JPanel
{

    public JPanel contentPane;

    public Withdraw(JPanel panel)
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
                cardLayout.show(contentPane, "Panel 4");
            }
        });
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }
}