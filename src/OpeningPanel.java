import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Raj Srivastava
 */
class OpeningPanel extends JPanel
{
    public JPanel contentPane;

    public OpeningPanel(JPanel panel)
    {

        contentPane = panel;
        CheckboxGroup c=new CheckboxGroup();
        Checkbox c1=new Checkbox("Sign Up",c,false);
        Checkbox c2=new Checkbox("Sign In",c,true);
        JButton b=new JButton("Go");
        b.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();

                if(c1.getState() == true) {
                    cardLayout.show(contentPane, "Register");
                } else {
                    cardLayout.show(contentPane, "Login");
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
