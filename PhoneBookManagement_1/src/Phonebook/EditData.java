
package Phonebook;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class EditData extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton bt1,bt2;
    JPanel p1,p2,p3;
    Font f,f1;
    JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9,tx10;
    EditData()
    {
        
    }
    EditData(int idno)
    {
        super("Edit Contact");
        setLocation(450,50);
        setSize(450,650);
        
        f = new Font("Arial",Font.BOLD,25);
        f1 = new Font("Arial",Font.BOLD,15);
        
        l1 = new JLabel("Update Contact");
        l2 = new JLabel("Name");
        l3 = new JLabel("Nick Name");
        l4 = new JLabel("Phone NO.");
        l5 = new JLabel("Mobile No.");
        l6 = new JLabel("Email Address");
        l7 = new JLabel("Home Address");
        l8 = new JLabel("Company");
        l9 = new JLabel("Position");
        l10 = new JLabel("Group Name");
        l11 = new JLabel("Id");
        
        tx1 = new JTextField();
        tx2 = new JTextField();
        tx3 = new JTextField();
        tx4 = new JTextField();
        tx5 = new JTextField();
        tx6 = new JTextField();
        tx7 = new JTextField();
        tx8 = new JTextField();
        tx9 = new JTextField();
        tx10 = new JTextField();
        
        bt1 = new JButton("Edit Contact");
        bt2 = new JButton("Back");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.RED);
        
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
        l11.setFont(f1);
        
        tx1.setFont(f1);
        tx2.setFont(f1);
        tx3.setFont(f1);
        tx4.setFont(f1);
        tx5.setFont(f1);
        tx6.setFont(f1);
        tx7.setFont(f1);
        tx8.setFont(f1);
        tx9.setFont(f1);
        tx10.setFont(f1);
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(11,2,10,10));
        p2.add(l11);
        p2.add(tx10);
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
        try
        {
            ConnectionClass obj1 = new ConnectionClass();
            String q1 = "select * from add_contact where Id = '"+idno+"'";
            ResultSet rest1 = obj1.stm.executeQuery(q1);
            while(rest1.next())
            {
                tx10.setText(rest1.getString("Id"));
                tx1.setText(rest1.getString("name"));
                tx2.setText(rest1.getString("nickname"));
                tx3.setText(rest1.getString("phone"));
                tx4.setText(rest1.getString("mobile"));
                tx5.setText(rest1.getString("email"));
                tx6.setText(rest1.getString("address"));
                tx7.setText(rest1.getString("company"));
                tx8.setText(rest1.getString("position"));
                tx9.setText(rest1.getString("group_name"));
                
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        tx10.setEditable(false);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
                
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            int Cid = Integer.parseInt(tx10.getText());
            String name=tx1.getText();
        String nickname = tx2.getText();
        String phone = tx3.getText();
        String mobile = tx4.getText();
        String email = tx5.getText();
        String address = tx6.getText();
        String company = tx7.getText();
        String position = tx8.getText();
        String group_name = tx9.getText();
        try{
            ConnectionClass obj3 = new ConnectionClass();
             String q1 = "update add_contact set name='"+name+"',nickname='"+nickname+"',phone='"+phone+"',mobile='"+mobile+"',email='"+email+"',address='"+address+"',company='"+company+"',position='"+position+"',group_name='"+group_name+"' where Id='"+Cid+"'";
             int aaa = obj3.stm.executeUpdate(q1);
             if(aaa==1)
             {
                 JOptionPane.showMessageDialog(null,"YOur data successfully updated");
                 this.setVisible(false);
                 new SearchDatatable(name).setVisible(true);
             }
             else{
                 JOptionPane.showMessageDialog(null, "Fill data carefully");
             }
        }
        catch(Exception exx){
             exx.printStackTrace();
        }
        }
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
            new Home().setVisible(true);
        }
    }
    public static void main(String ar[])
    {
        new EditData().setVisible(true);
    }
}
