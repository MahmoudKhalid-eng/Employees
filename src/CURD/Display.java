package CURD;
import static CURD.Delete.c;
import static CURD.Display.c;
import static CURD.Insert.c;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class Display extends JFrame {
    public static Connection c;
    public static Statement ss;
    public static String query;   
    public static ResultSet r;
    Secure c1=new Secure();

    public Display() {
        Font font1 = new Font("Arial",Font.BOLD, 25);
        JTextArea text=new JTextArea();
        text.setFont(font1);
        setSize(900,600);
        text.setEditable(false);
        add(text);
        setVisible(true);
        Secure c1=new Secure();
        try{
            ArrayList<Elements> list=new ArrayList();
            c =c1.connect();
            ss =c.createStatement();
            query = "select * from empss";
            r=ss.executeQuery(query);
            
            while(r.next()){
               Elements e1=new Elements(r.getInt("id"), 
                r.getString("name"),r.getInt("age"),r.getString("company"),
                r.getString("depart"), r.getString("salary"));
                list.add(e1);
            }
            for(int i=0;i<list.size();i++){
                String textt=" "+list.get(i).id+" || "+list.get(i).name+" || "+
                list.get(i).age+" || "+list.get(i).company+" || "+
                list.get(i).department+" || "+list.get(i).salary+"\n";
                text.append(textt);
            }
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
        
     
            
        
        
}
