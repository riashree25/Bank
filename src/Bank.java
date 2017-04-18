import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Bank extends Frame implements ActionListener {
    Label     l1, l2, l3, l4, l5, l6, l7, l8;
    TextField t1, t2, t3, t4, t5, t6, t7, t8;
    Frame     f;
    Button    b;

    Bank() {
        f = new Frame("Bank");
        l1 = new Label("Aadhar Number");
        l2 = new Label("First Name");
        l3 = new Label("Last Name");
        l4 = new Label("Gender");
        l5 = new Label("Birth Date");
        l6 = new Label("Address");
        l7 = new Label("Mobile Number");
        l8 = new Label("Email ID");
        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t4 = new TextField();
        t5 = new TextField();
        t6 = new TextField();
        t7 = new TextField();
        t8 = new TextField();
        b = new Button("Submit");
        setSize(500, 500);
        l1.setBounds(50, 50, 150, 20);
        l2.setBounds(50, 100, 150, 20);
        l3.setBounds(50, 150, 150, 20);
        l4.setBounds(50, 200, 150, 20);
        l5.setBounds(50, 250, 150, 20);
        l6.setBounds(50, 300, 150, 20);
        l7.setBounds(50, 350, 150, 20);
        l8.setBounds(50, 400, 150, 20);
        t1.setBounds(200, 50, 150, 20);
        t2.setBounds(200, 100, 150, 20);
        t3.setBounds(200, 150, 150, 20);
        t4.setBounds(200, 200, 150, 20);
        t5.setBounds(200, 250, 150, 20);
        t6.setBounds(200, 300, 150, 20);
        t7.setBounds(200, 350, 150, 20);
        t8.setBounds(200, 400, 150, 20);
        b.setBounds(200, 450, 150, 20);
        b.addActionListener(this);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(t7);
        add(t8);
        add(b);
        setLayout(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
       // Mysql.insert(Integer.parseInt(t1.getText()), t2.getText(), t3.getText(), t4.getText(), t5.getText(),
         //       t6.getText(), Long.parseLong(t7.getText()), t8.getText());
    }

    public static void main(String args[]) {
        Bank ob = new Bank();
    }
}
