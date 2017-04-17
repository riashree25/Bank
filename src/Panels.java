import javax.swing.*;
import java.awt.*;

public class Panels extends {
    public static void front()
    {
        JPanel j1=new JPanel();
        CheckboxGroup c=new CheckboxGroup();
        Checkbox c1=new Checkbox("Create Account",c,true);
        Checkbox c2=new Checkbox("Open Account",c,false);
        Button b=new Button("Go");
        c1.setBounds(75,50,150,20);
        c2.setBounds(75,100,150,20);
        b.setBounds(100,150,50,20);
        b.addActionListener(this);
        j1.add(c1);
        j1.add(c2);
        j1.add(b);
        j1.setLayout(null);
        j1.setVisible(true);
    }

    public static void open()
    {
        JPanel j2=new JPanel();
        Label l1=new Label("User Name");
        Label l2=new Label("Password");
        TextField t1=new TextField();
        TextField t2=new TextField();
        Button b=new Button("Go");
        l1.setBounds(50,50,100,20);
        l2.setBounds(50,100,100,20);
        t1.setBounds(150,50,150,20);
        t2.setBounds(150,100,150,20);
        b.setBounds(200,150,50,20);
        j2.add(l1);
        j2.add(l2);
        j2.add(t1);
        j2.add(t2);
        j2.add(b);
        j2.setLayout(null);
        j2.setVisible(true);
    }

    public static void create()
    {
        JPanel j3=new JPanel();
        Label l1 = new Label("Aadhar Number");
        Label l2 = new Label("First Name");
        Label l3 = new Label("Last Name");
        Label l4 = new Label("Gender");
        Label l5 = new Label("Birth Date");
        Label l6 = new Label("Address");
        Label l7 = new Label("Mobile Number");
        Label l8 = new Label("Email ID");
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();
        TextField t5 = new TextField();
        TextField t6 = new TextField();
        TextField t7 = new TextField();
        TextField t8 = new TextField();
        Button b = new Button("Submit");
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
        j3.add(l1);
        j3.add(l2);
        j3.add(l3);
        j3.add(l4);
        j3.add(l5);
        j3.add(l6);
        j3.add(l7);
        j3.add(l8);
        j3.add(t1);
        j3.add(t2);
        j3.add(t3);
        j3.add(t4);
        j3.add(t5);
        j3.add(t6);
        j3.add(t7);
        j3.add(t8);
        j3.add(b);
        j3.setLayout(null);
        j3.setVisible(true);
    }

    public static void main(String args[]){}
}
