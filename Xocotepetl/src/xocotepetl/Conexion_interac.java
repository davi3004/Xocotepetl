package xocotepetl;

import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion_interac {
    
public static final String DRIVER ="com.mysql.jdbc.Driver";    
public static final String URL = "jdbc:mysql://localhost:3306/chocolateria";
public static final String USER = "root";
public static final String CLAVE = "";
  
 public static Connection getConexion(){
            Connection con = null;
            System.out.println("Conectando con la base de datos");
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, USER, CLAVE);
                System.out.println("Conexion establecida");
            }catch(ClassNotFoundException | SQLException e){
                System.out.println("Ha habido un error");
                System.out.println("Error: " + e.getMessage());
                exit(0);
                
            }
            return con;
    }
 
 public static ResultSet getTable(String consulta) {
        Connection con = null;
        Statement st;
        ResultSet datos = null;
        try {
            con = getConexion();
            st = con.createStatement();
            datos = st.executeQuery(consulta);
            System.out.println("Consulta de tabla buena");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return datos;
    }
 
}
