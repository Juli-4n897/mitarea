
package mitarea;

import java.sql.Connection;
import javax.swing.JOptionPane;


public class Mitarea {


    public static void main(String[] args) {
        Connection con;
        try {
           con = conexion.open();
           if (con!=null) {
               JOptionPane.showMessageDialog(null, "Conexion exitosa");
           }else{
               JOptionPane.showMessageDialog(null, "error en la conexion");
           }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
}
