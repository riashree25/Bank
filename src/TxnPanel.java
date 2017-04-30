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
        List<TxnData> data = DbHelper.selectTransaction();
        try
        {
            if(data.size() == 0) {
                // there are no transactions for this account, show a msg in JLabel
            } else {
                // there are transactions for this account, so we will show table

                Object[][] rowData = new Object[data.size()][4];

                for (int i = 0; i < data.size(); i++) {
                    TxnData txnData = data.get(i);

                    Object[] objects = new Object[] {txnData.getTxnId(), txnData.getAmount(), txnData.getTxnType(),
                            txnData.getTime()};

                    rowData[i] = objects;
                }
                JTable jt = new JTable(rowData, new Object[]{"TxnId", "Amount", "Debit/Credit", "Time"});

                // show this JTable
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
