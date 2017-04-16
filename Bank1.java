import java.util.*;
import java.awt.*;
import java.awt.event.*;

class Bank1 extends Frame
{
	Label l1,l2;
	TextField t1,t2;
	Frame f;
	Button b;
	
	Bank1()
	{
		f=new Frame("Bank1");
		l1=new Label("User Name");
		l2=new Label("Password");
		t1=new TextField();
		t2=new TextField();
		b=new Button("Go");
		setSize(400,200);
		l1.setBounds(50,50,100,20);
		l2.setBounds(50,100,100,20);
		t1.setBounds(150,50,150,20);
		t2.setBounds(150,100,150,20);		
		b.setBounds(200,150,50,20);
		b.addActionListener(this);
		add(l1);add(l2);
		add(t1);add(t2);
		add(b);
		setLayout(null);
		setVisible(true);
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){dispose();}});
	}
		
	public static void main(String args[])
	{
		Bank1 ob=new Bank1();
	}
}
