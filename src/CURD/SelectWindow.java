package CURD;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectWindow extends JFrame implements ActionListener {
    JButton b1 = new JButton("Insert");
    JButton b2 = new JButton("Update");
    JButton b3 = new JButton("Diplay All");
    JButton b4 = new JButton("Delete");
    SelectWindow (){
        setTitle("Employees");
        setLayout(null);
        setSize(300,300);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Font f = new Font ("Dialog",Font.BOLD,20);
        add(b1);add(b2);add(b3);add(b4);
        b1.setBounds(70,25,150, 50);
        b1.setFont(f);
        b2.setBounds(70,85,150, 50);
        b2.setFont(f);
        b3.setBounds(70,135,150, 50);
        b3.setFont(f);
        b4.setBounds(70,185,150,50);
        b4.setFont(f);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            Insert i=new Insert();
        }
        if(e.getSource()==b2){
            Update u=new Update();
        }
        if(e.getSource()==b3){
            Display u=new Display();
        }
        if(e.getSource()==b4){
            Delete u=new Delete();
        }
    }

}


