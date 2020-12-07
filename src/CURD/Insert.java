package CURD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Insert extends JFrame  implements ActionListener {
    static Connection c;
    static Statement ss;
    static String query;
    public Insert(){
        setLocationRelativeTo(null);
        setSize(500,550);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Insert a new Employee");
        Font font1 = new Font("Arial",Font.BOLD, 25);
        Font font2 = new Font("Arial",Font.ROMAN_BASELINE, 25);
        JLabel Id=new JLabel("ID");
        Id.setBounds(5,20,500,50);
        Id.setFont(font1);
        
        JLabel Name=new JLabel("Name");
        Name.setBounds(5,90,500,50);
        Name.setFont(font1);

        JLabel Age=new JLabel("Age");
        Age.setFont(font1);
        Age.setBounds(5,160,500,50);

        JLabel Company=new JLabel("Company");
        Company.setFont(font1);
        Company.setBounds(5,230,550,50);

        JLabel Depart=new JLabel("Depart");
        Depart.setFont(font1);
        Depart.setBounds(5,300,550,50);

        JLabel Salary=new JLabel("Salary");
        Salary.setFont(font1);
        Salary.setBounds(5,370,550,50);
        
        final JTextField id=new JTextField();
        id.setBounds(120,20,350,50);
        id.setFont(font2);
        
        final JTextField name=new JTextField();
        name.setBounds(120,90,350,50);
        name.setFont(font2);

        final JTextField age=new JTextField();
        age.setBounds(120,160,350,50);
        age.setFont(font2);
        JTextField company=new JTextField();
        company.setFont(font2);
        company.setBounds(120,230,350,50);

        JTextField depart=new JTextField();
        depart.setBounds(120,300,350,50);
        depart.setFont(font2);
        final JTextField salary=new JTextField();
        salary.setFont(font2);
        salary.setBounds(120,370,350,50);

        JButton insert=new JButton("Insert");
        insert.setFont(font1);
        insert.setBounds(170,440,150,50);

        add(Id);add(id);
        add(Name);add(Age);add(Company);add(Depart);add(Salary);
        add(name);add(age);add(company);add(depart);add(salary);
        add(insert);
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name1,company1,depart1;
                String salary1=salary.getText();
                int id1=Integer.parseInt(id.getText());
                int age1=Integer.parseInt(age.getText());
                name1=name.getText();
                company1=company.getText();
                depart1=depart.getText();
            Secure c1=new Secure();
        try{
            c=c1.connect();
            ss=c.createStatement();
            query = "insert into empss values('"+id1+"','"+name1+"',"
                    + "'"+age1+"','"+company1+"','"+depart1+"','"+salary1+"')";
            ss.execute(query);
            JOptionPane.showMessageDialog(null, "Done");
            id.setText("");
            name.setText("");
            age.setText("");
            company.setText("");
            depart.setText("");
            salary.setText("");
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

