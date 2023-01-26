
package Phonebook;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class EntryData extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f,f1;
    JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9;
    EntryData()
    {
        super("Add Contact");
        setLocation(450,50);
        setSize(450,650);
        
        f = new Font("Arial",Font.BOLD,25);
        f1 = new Font("Arial",Font.BOLD,15);
        
        l1 = new JLabel("Add Contact");
        l2 = new JLabel("Name");
        l3 = new JLabel("Nick Name");
        l4 = new JLabel("Phone NO.");
        l5 = new JLabel("Mobile No.");
        l6 = new JLabel("Email Address");
        l7 = new JLabel("Home Address");
        l8 = new JLabel("Company");
        l9 = new JLabel("Position");
        l10 = new JLabel("Group Name");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        tx1 = new JTextField();
        tx2 = new JTextField();
        tx3 = new JTextField();
        tx4 = new JTextField();
        tx5 = new JTextField();
        tx6 = new JTextField();
        tx7 = new JTextField();
        tx8 = new JTextField();
        tx9 = new JTextField();
        
        bt1 = new JButton("Add Contact");
        bt2 = new JButton("Back");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        
        tx1.setFont(f1);
        tx2.setFont(f1);
        tx3.setFont(f1);
        tx4.setFont(f1);
        tx5.setFont(f1);
        tx6.setFont(f1);
        tx7.setFont(f1);
        tx8.setFont(f1);
        tx9.setFont(f1);
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(10,2,10,10));
        p2.add(l2);
        p2.add(tx1);
        p2.add(l3);
        p2.add(tx2);
        p2.add(l4);
        p2.add(tx3);
        p2.add(l5);
        p2.add(tx4);
        p2.add(l6);
        p2.add(tx5);
        p2.add(l7);
        p2.add(tx6);
        p2.add(l8);
        p2.add(tx7);
        p2.add(l9);
        p2.add(tx8);
        p2.add(l10);
        p2.add(tx9);
        p2.add(bt1);
        p2.add(bt2);
        
        setLayout(new BorderLayout(10,20));
        add(p1,"North");
        add(p2,"Center");
        
    }
    public void actionPerformed(ActionEvent e)
    {
        String name=tx1.getText();
        String nickname = tx2.getText();
        String phone = tx3.getText();
        String mobile = tx4.getText();
        String email = tx5.getText();
        String address = tx6.getText();
        String company = tx7.getText();
        String position = tx8.getText();
        String group = tx9.getText();
        
        if(e.getSource()==bt1)
        {
            try
            {
                ConnectionClass obj = new ConnectionClass();
                String q = "insert into add_contact(name,nickname,phone,mobile,email,address,company,position,group_name) value('"+name+"','"+nickname+"','"+phone+"','"+mobile+"','"+email+"','"+address+"','"+company+"','"+position+"','"+group+"')";
                int aa = obj.stm.executeUpdate(q);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null, "Data Inserted");
                    this.setVisible(false);
                    new Home().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please file data carefully");
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
                
        }
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
            new Home().setVisible(true);
        }
        
    }
    public static void main(String[] ar)
    {
        new EntryData().setVisible(true);
    }
    
}
