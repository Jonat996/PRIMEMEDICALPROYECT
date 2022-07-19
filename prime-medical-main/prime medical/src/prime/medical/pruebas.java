/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prime.medical;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.UsuarioDAO;
import modelo.usuario;

/**
 *
 * @author jonathan
 */
public class pruebas {
    public static void main (String[]args){
        validarUsuario();
    }
    static Conexion conectar = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    UsuarioDAO dao = new UsuarioDAO();
    
    public static void validarUsuario(){
        List<usuario> Lista =Listar();
        
        
        for (int i = 0; i < Lista.size(); i++) {
            System.out.println(Lista.get(i).getNombre());
        }
    }
    
    
    public static List Listar(){
        List<usuario>datos=new ArrayList<>();
        String sql="select * from usuarios";
        
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
        
            while(rs.next()){
                usuario p = new usuario();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setCorreo(rs.getString(4));
                p.setNumero(rs.getLong(5));
                p.setContraseña(rs.getString(6));
                datos.add(p);
                
            }
            System.out.println("doneeeee");
        }catch(Exception e){
            
            System.out.println("fail");
        }return datos;
    }
}
