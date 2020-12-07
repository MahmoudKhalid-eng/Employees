package CURD;

import static CURD.Insert.c;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete extends JFrame implements ActionListener {
    static Connection c;
    static Statement ss;
    static String query;
    Delete(){
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setTitle("Delete an employee");
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false);
        JTextField idd=new JTextField();
        idd.setBounds(45,80,200,50);
        Font font1 = new Font("Arial",Font.BOLD, 25);
        Font font2 = new Font("Arial",Font.ROMAN_BASELINE, 25);
        JLabel enterid=new JLabel("Enter the ID");
        enterid.setBounds(45,30,500,50);
        
        enterid.setFont(font1);
        idd.setFont(font2);
        JButton delete=new JButton("Delete");
        delete.setBounds(90,150,120,50);
        delete.setFont(font1);
        add(idd);add(delete);add(enterid);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id1=Integer.parseInt(idd.getText());
                Secure c1=new Secure();
        try{
            c =c1.connect();
            ss =c.createStatement();
            query = "delete from empss where id  = '"+id1+"'";
            ss.execute(query);
            JOptionPane.showMessageDialog(null, "Deleted"); 
            idd.setText("");
        }
        catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
        finally{
            try{
                c.close();
                ss.close();
            }
            catch(SQLException ee){
                System.out.println(ee.getMessage());
            }
        }   
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
