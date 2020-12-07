package CURD;

import static CURD.Delete.c;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class Update extends JFrame  implements ActionListener {
    static Connection c;
    static Statement ss;
    static String query;
    Update(){
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setTitle("Update an employee's data");
        setSize(400,350);
        setLocationRelativeTo(null);
        setResizable(false);
        JLabel enterid=new JLabel("Enter the ID");
        enterid.setBounds(5,20,500,50);
        Font font1 = new Font("Arial",Font.BOLD, 25);
        Font font2 = new Font("Arial",Font.ROMAN_BASELINE, 25);
        enterid.setFont(font1);
        JLabel enternew=new JLabel("The new value");
        enternew.setBounds(5,160,500,50);
        enternew.setFont(font1);
        JLabel by=new JLabel("Update by");
        by.setBounds(5,90,500,50);
        by.setFont(font1);
        JTextField idd=new JTextField();
        idd.setBounds(180,20,200,50);
        idd.setFont(font2);
        JComboBox co=new JComboBox();
        co.setBounds(180, 90, 150, 50);
        co.setFont(font1);
        co.addItem("Name");
        co.addItem("Age");
        co.addItem("Company");
        co.addItem("Department");
        co.addItem("Salary");
        JTextField thenew=new JTextField();
        thenew.setBounds(180,160,200,50);
        thenew.setFont(font2);
        JButton update=new JButton("Update");
        update.setBounds(135,240,120,50);
        update.setFont(font1);
        add(by);
        add(enterid);add(idd);add(co);add(thenew);add(update);
        add(enternew);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String change=thenew.getText();
                int choice = 1;
                int id1=Integer.parseInt(idd.getText());
                if(co.getSelectedIndex()==0) choice=1;
                else if (co.getSelectedIndex()==1) choice=2;
                else if (co.getSelectedIndex()==2) choice=3;
                else if (co.getSelectedIndex()==3) choice=4;
                else  if (co.getSelectedIndex()==4) choice=5;
                Secure c1=new Secure();
        try{
            c =c1.connect();
            ss =c.createStatement();
            if(choice==1){
                query = "update empss set name = '"+change+"' where id = '"+id1+"'";
            }
            else if(choice==2){
                query = "update empss set age = '"+Integer.parseInt(change)+"' where id = '"+id1+"'";
            }
            else if(choice==3){
                query = "update empss set company = '"+change+"' where id = '"+id1+"'";
            }
            else if(choice==4){
                query = "update empss set depart = '"+change+"' where id = '"+id1+"'";
            }
            else if(choice==5){
                query = "update empss set salary = '"+change+"' where id = '"+id1+"'";
            }
            ss.execute(query);
            JOptionPane.showMessageDialog(null, "Updated"); 
            idd.setText("");
            co.setSelectedIndex(0);
            thenew.setText("");
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

