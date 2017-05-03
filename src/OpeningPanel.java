import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OpeningPanel extends JPanel
{
    public JPanel contentPane;

    public OpeningPanel(JPanel panel)
    {

        contentPane = panel;
        JLabel l = new JLabel("CITY BANK JAIPUR");
        CheckboxGroup c=new CheckboxGroup();
        Checkbox c1=new Checkbox("Sign Up",c,false);
        Checkbox c2=new Checkbox("Sign In",c,true);
        JButton b=new JButton("Go");
        l.setBounds(250,150,300,100);
        c1.setBounds(250,250,100,50);
        c2.setBounds(250,300,100,50);
        b.setBounds(250,350,100,40);
        b.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();

                if(c1.getState() == true) {
                    c1.setState(false);
                    c2.setState(true);
                    cardLayout.show(contentPane, "Register");

                } else {
                    c1.setState(false);
                    c2.setState(true);
                    cardLayout.show(contentPane, "Login");
                }
            }
        });
        add(l);
        add(c1);
        add(c2);
        add(b);
        setLayout(null);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }
}
