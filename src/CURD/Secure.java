
package CURD;

import java.sql.*;
public class Secure {
    private final static String user="root";
    private final static String pass="";
    private final static String add="jdbc:mysql://localhost/employeees";
    
    public Connection connect() throws SQLException{
        
        return DriverManager.getConnection(add, user, pass);
    }
}
