/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;    

/**java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver
 *
 * @author jonathan
 */
public class Conexion {
    Connection con=null;
    public Connection getConnection(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://144.22.52.137/PRIMEMEDICAL", "JONAT", "JONAT996");
            System.out.println("Done!!");
        }catch(Exception e){
            System.err.println("No se pudo conectarrr" + e);
        }
        return con;
    }
    
     }
    
    

