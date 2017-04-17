import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame1
{
    public JPanel contentPane;
    public MyPanel p1;
    public MyPanel2 p2;
    public MyPanel3 p3;
    public MyPanel4 p4;

    public void displayGUI()
    {
        JFrame jf = new JFrame("Bank");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        contentPane.setLayout(new CardLayout());
        p1 = new MyPanel(contentPane);
        p2 = new MyPanel2(contentPane);
        p3 = new MyPanel3(contentPane);
        p4 = new MyPanel4(contentPane);
        contentPane.add(p1, "Panel 1");
        contentPane.add(p2, "Panel 2");
        contentPane.add(p3, "Panel 3");
        contentPane.add(p4, "Panel 4");
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

class MyPanel extends JPanel
{
    public JPanel contentPane;

    public MyPanel(JPanel panel)
    {

        contentPane = panel;
        CheckboxGroup c=new CheckboxGroup();
        Checkbox c1=new Checkbox("Create Account",c,true);
        Checkbox c2=new Checkbox("Open Account",c,false);
        JButton b=new JButton("Go");
        b.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
		/*c1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//Bank();
			}
		});
		c2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//Bank1();
			}
		});*/
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
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
        return (new Dimension(300, 200));
    }
}

class MyPanel2 extends JPanel
{

    public JPanel contentPane;

    public MyPanel2(JPanel panel)
    {
        contentPane = panel;
        JLabel l1 = new JLabel("Aadhar Number");
        JLabel l2 = new JLabel("First Name");
        JLabel l3 = new JLabel("Last Name");
        JLabel l4 = new JLabel("Gender");
        JLabel l5 = new JLabel("Birth Date");
        JLabel l6 = new JLabel("Address");
        JLabel l7 = new JLabel("Mobile Number");
        JLabel l8 = new JLabel("Email ID");
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
        JTextField t6 = new JTextField();
        JTextField t7 = new JTextField();
        JTextField t8 = new JTextField();
        JButton b = new JButton("Submit");
        setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));

        b.addActionListener( new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
        {
            //Mysql.insert(Integer.parseInt(t1.getText()), t2.getText(), t3.getText(), t4.getText(), t5.getText(),
              //      t6.getText(), Long.parseLong(t7.getText()), t8.getText());
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.next(contentPane);
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
        add(b);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 500));
    }
}

class MyPanel3 extends JPanel
{

    public JPanel contentPane;

    public MyPanel3(JPanel panel)
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
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(400, 200));
    }
}

class MyPanel4 extends JPanel
{

    public JPanel contentPane;

    public MyPanel4(JPanel panel)
    {
        contentPane = panel;
        JLabel l1 = new JLabel("Account Number");
        JLabel l2 = new JLabel("Aadhar Number");
        JLabel l3 = new JLabel("First Name");
        JLabel l4 = new JLabel("Last Name");
        JLabel l5 = new JLabel("Gender");
        JLabel l6 = new JLabel("Birth Date");
        JLabel l7 = new JLabel("Address");
        JLabel l8 = new JLabel("Mobile Number");
        JLabel l9 = new JLabel("Email ID");
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
        JTextField t6 = new JTextField();
        JTextField t7 = new JTextField();
        JTextField t8 = new JTextField();
        JTextField t9 = new JTextField();
        JButton b = new JButton("Show");
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
        setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));

        b.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 500));
    }
}