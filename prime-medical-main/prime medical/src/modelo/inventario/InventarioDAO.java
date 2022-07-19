/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan
 */
public class InventarioDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

//Listar 
    public List Listar() {
        List<Inventario> datos = new ArrayList<>();
        String sql = "Select CodigoInventario, NombreProducto, Cantidad, PrecioVenta "
                + "From inventario, productos where inventario.Producto=productos.CodigoProducto";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Inventario i = new Inventario();
                i.setCodigoInventario(rs.getInt(1));
                i.setNombre(rs.getString(2));
                i.setCantidad(rs.getInt(3));
                i.setPrecioVenta(rs.getInt(4));
                datos.add(i);
            }
        } catch (SQLException e) {
            System.out.println("Something is wrong in inventario DAO " + e);

        }
        return datos;
    }

    //Agregar
    public boolean Agregar(Inventario i) throws SQLException {
        ps = null;
        int nombre = Iguales(i.getNombre());
        String sql = "INSERT INTO inventario (Producto, Cantidad, PrecioVenta) VALUES (" + nombre + ",?,?)";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, i.getCantidad());

            ps.setInt(2, i.getPrecioVenta());

            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("Something is wrong in InventarioDAO si qui " + e);
            return false;
        }
    }
    //Metodo Actualizar

    public boolean Actualizar(Inventario i) throws SQLException {

        ps = null;
        int nombre = Iguales(i.getNombre());
        String sql = "Update inventario set  Producto=" + nombre + ", Cantidad=?, PrecioVenta=? where CodigoInventario=?";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            System.out.println(sql);
            //ps.setInt(1, nombre);

            ps.setInt(1, i.getCantidad());

            ps.setInt(2, i.getPrecioVenta());
            ps.setInt(3, i.getCodigoInventario());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("Something is wrong in InventarioDAO si qui " + e);
            return false;
        }
    }

    //Este metodo trae un string que viene del Combobox. La idea de este metodo es que busque en el array el string que sea igual a este
    //y me retorne la llave primaria que contiene dicho String.
    public int Iguales(String dato) throws SQLException {
        String sql = "Select * from productos";
        con = conectar.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        int resultado = 0;
        String Producto;
        while (rs.next()) {

            resultado = rs.getInt(1);
            Producto = rs.getString(2);
            if (dato.equals(Producto)) {
                System.out.println("El resultado es: " + resultado + " del producto " + Producto);
                return resultado;
            }

        }
        con.close();
        return resultado;
    }
    //Metodo Eliminar

    public void Eliminar(int id) {
        String sql = "delete from inventario where CodigoInventario =" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Producto Eliminado");
        } catch (SQLException e) {
            System.out.println("Error en eliminar" + e);
        }

    }

    public ArrayList Nombres() {
        String sql = "select NombreProducto from productos";
        ArrayList<String> datos = new ArrayList<>();

        try {
            con = conectar.getConnection();

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                datos.add(rs.getString(1));

            }
        } catch (SQLException e) {
            System.out.println("Error en idao" +e);
        }

        return datos;

    }
    public boolean descontarCantidad(int can, int cod){
         String sql = "UPDATE inventario set CANTIDAD="+can+" where CodigoInventario="+cod;
        

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();System.out.println("Hecho perras!!");
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en descontarCantidad" + ex);
            return false;
        }
            
    }

};
