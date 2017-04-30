import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class TxnPanel extends JPanel
{

    public JPanel contentPane;

    public TxnPanel(JPanel panel)
    {
        contentPane = panel;
        ResultSet rs = DbHelper.insertTxn();
        try
        {
            rs.next();
            String data[][]={ {"101","Amit","670000"},
                    {"102","Jai","780000"},
                    {"101","Sachin","700000"}};
            String column[]={"ID","NAME","SALARY"};
            JTable jt = new JTable();


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
