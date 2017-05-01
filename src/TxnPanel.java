import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class TxnPanel extends JPanel
{

    public JPanel contentPane;

    public TxnPanel(JPanel panel)
    {
        contentPane = panel;
        Object[][] data = DbHelper.selectTransaction();
        try
        {
            if(data.length == 0)
            {
                JLabel j = new JLabel("There are no transactions for this account.");
                add(j);
            }
            else
            {
                JTable jt = new JTable(data, new Object[]{"TxnId", "Amount", "Debit/Credit", "Time"});
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.getViewport().add(jt);
                add(scrollPane);
            }

            JButton b = new JButton("Exit");
            add(b);
            setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));
            b.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                    cardLayout.show(contentPane, "UserInfo");
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
