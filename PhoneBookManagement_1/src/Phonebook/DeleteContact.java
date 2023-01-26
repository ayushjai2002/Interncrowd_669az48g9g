package Phonebook;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class DeleteContact extends JFrame implements ActionListener {
    String x[] = {"Id","Name","Nick Name","Phone","Mobile","Email","Address","Company","Position","Group_name"};
    String y[][] = new String[20][10];
    int i = 0,j=0;
    JTable t;
    Font f,f1;
    JLabel l1;
    JTextField tx1;
    JButton bt1;
    JPanel p1,p2;
     DeleteContact()
     {
         super("Contact information");
         setLocation(1,1);
         setSize(800,400);
         
         f = new Font("Arial",Font.BOLD,10);
         try
            {
                ConnectionClass obj = new ConnectionClass();
                String q = "select * from add_contact";
                ResultSet rest = obj.stm.executeQuery(q);
                while(rest.next())
                {
                    y[i][j++]=rest.getString("Id");
                    y[i][j++]=rest.getString("name");
                    y[i][j++]=rest.getString("nickname");
                    y[i][j++]=rest.getString("phone");
                    y[i][j++]=rest.getString("mobile");
                    y[i][j++]=rest.getString("email");
                    y[i][j++]=rest.getString("address");
                    y[i][j++]=rest.getString("company");
                    y[i][j++]=rest.getString("position");
                    y[i][j++]=rest.getString("group_name");
                    i++;
                    j=0;
                }
                t = new JTable(y,x);
                t.setFont(f);
                
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
         JScrollPane sp = new JScrollPane(t);
         l1 = new JLabel("Enter Contact ID for Delete");
         tx1 = new JTextField();
         bt1 = new JButton("Delete");
         bt1.setBackground(Color.black);
         bt1.setForeground(Color.yellow);
         bt1.addActionListener(this);
         
         p1 = new JPanel();
         p1.setLayout(new GridLayout(1,3,10,10));
         p1.add(l1);
         p1.add(tx1);
         p1.add(bt1);
         
         setLayout(new BorderLayout(10,10));
         add(p1,"South");
         add(sp,"Center");
      
     }
     
     public void actionPerformed(ActionEvent e)
     {
         
         if(e.getSource()==bt1)
         {
             int idno = Integer.parseInt(tx1.getText());
             try{
                 ConnectionClass obj1 = new ConnectionClass();
                 String q2 = "delete from add_contact where Id='"+idno+"'";
                 int res = obj1.stm.executeUpdate(q2);
                 
                 if(res==1)
                 {
                     JOptionPane.showMessageDialog(null,"Your Contact successfully deleted");
                     this.setVisible(false);
                     new DeleteContact().setVisible(true);
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null,"Your Contact did not deleted");
                     this.setVisible(false);
                     new DeleteContact().setVisible(true);
                 }
                 
             }
             catch(Exception ex)
             {
                 ex.printStackTrace();
             }
             new EditData(idno).setVisible(true);
             this.setVisible(false);
         }
         
     }
     
    public static void main(String ar[])
    {
        new DeleteContact().setVisible(true);
    }
}
