import java.awt.*;
import java.awt.event.*;

class Bank2 extends Frame implements ActionListener
{
	Checkbox c1,c2;
	CheckboxGroup c;
	Frame f;
	Button b;
	
	Bank2()
	{
		f=new Frame("Bank2");
		c=new CheckboxGroup();
		c1=new Checkbox("Create Account",c,true);
		c2=new Checkbox("Open Account",c,false);
		b=new Button("Go");
		setSize(300,200);
		c1.setBounds(75,50,150,20);
		c2.setBounds(75,100,150,20);
		b.setBounds(100,150,50,20);
		b.addActionListener(this);
		add(c1);
		add(c2);
		add(b);
		setLayout(null);
		setVisible(true);
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){dispose();}});
	}

	public void actionPerformed(ActionEvent e)
	{
		c1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Bank();
			}
		});
		c2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Bank1();
			}
		});
	}

	public static void main(String args[])
	{
		Bank2 ob=new Bank2();
	}
}
