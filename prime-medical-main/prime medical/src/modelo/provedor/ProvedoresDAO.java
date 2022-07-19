/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.provedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;

/**
 *
 * @author jonathan
 */
public class ProvedoresDAO {
    
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List Listar(){
        List<Proveedores>datos=new ArrayList<>();
        String sql="select * from proveedores";
    try{
        con=conectar.getConnection();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            Proveedores p = new Proveedores();
            p.setCodigoProveedor(rs.getInt(1));
            p.setNombreProveedor(rs.getString(2));
            p.setDescripcion(rs.getString(3));
            p.setNumero(rs.getLong(4));
            datos.add(p);
            System.out.println("Lista Hecha");
            }
    }catch(Exception e){
        System.out.println("falló consulta Proveedores");
    }return datos;
    }
    public boolean Agregar(Proveedores p){
    String sql="Insert into proveedores (NombreProveedor,Descripcion, Numero) Values (?,?,?)";
        try{
        
        con=conectar.getConnection();
        ps=con.prepareStatement(sql);
       
       ps.setString(1, p.getNombreProveedor());
       ps.setString(2,p.getDescripcion());
       ps.setLong(3,p.getNumero());
       ps.execute();
       return true;
    }catch(Exception e){
        System.out.println(e);
        return false;
    }
    }
    public boolean Actualizar(Proveedores p) throws SQLException{
     String sql="Update proveedores set NombreProveedor =?, Descripcion=?,Numero=? where CodigoProveedor=?";
     try{
         con=conectar.getConnection();
        ps=con.prepareStatement(sql);
        ps.setString(1, p.getNombreProveedor());
        ps.setString(2, p.getDescripcion());
        ps.setLong(3, p.getNumero());
        ps.setInt(4, p.getCodigoProveedor());
        
        ps.execute();
        return true;
     }catch(SQLException e){
         
         System.out.println("Something in wrong in ProveedorDAO " + e);
         return false;
     }
     
    }
    public void Eliminar(int id){
        String sql = "delete from proveedores where CodigoProveedor =" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Proveedor eliminado con Exito");
            
        } catch (SQLException e) {
            System.out.println("Error en eliminar" + e);
            JOptionPane.showMessageDialog(null, "No se puede Eliminar un Proveedor que está siendo Usado");
        }
    }
}
