
package mitarea;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    private static String path;
    private static Connection con;
    
    public static Connection open() throws Exception{
        path = "jdbc:mysql://localhost:3306/registros";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            if(con==null || con.isClosed()) {
            con = DriverManager.getConnection(path,"root","");
        }
        }catch (Exception ex) {
            con = null;
        }
        return con;
    }
}
