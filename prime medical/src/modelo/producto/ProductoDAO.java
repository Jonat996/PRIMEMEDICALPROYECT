/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.producto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.provedor.ProvedoresDAO;
import modelo.provedor.Proveedores;

/**
 *
 * @author jonathan
 */
public class ProductoDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    long Fecha;
    Date fe;
    java.util.Date date = new java.util.Date();
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

    ProvedoresDAO prodao = new ProvedoresDAO();
    Proveedores pro = new Proveedores();

    public int TablaOriginal(String dato) throws SQLException {

        String original = "select * from PROVEEDORES";

        con = conectar.getConnection();
        ps = con.prepareStatement(original);
        rs = ps.executeQuery();
        int resultado = 0;
        String provedor;
        while (rs.next()) {
            Producto p = new Producto();
            System.out.println(rs.getInt(1));
            resultado = rs.getInt(1);
            System.out.println(dato + rs.getString(2));
            provedor = rs.getString(2);
            //p.setProveedor(rs.getString(2));
            if (provedor.equals(dato)) {
                System.out.println(resultado + " Llegue aqui<");
                return resultado;
            } else {
                System.out.println("No llego aqui");
            }

        }
        con.close();
        return resultado;
    }

    public List Listar() throws SQLException {
        List<Producto> datos = new ArrayList<>();
        String sql = "select CodigoProducto, NombreProducto, DescripcionProducto, NombreProveedor, FechaIngreso, PrecioCompra from PRODUCTOS, PROVEEDORES WHERE PRODUCTOS.Proveedor=PROVEEDORES.CodigoProveedor";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigoProducto(rs.getInt(1));
                p.setNombreProducto(rs.getString(2));
                p.setDescripcionProducto(rs.getString(3));

                p.setProveedor(rs.getString(4));
                p.setFecha(rs.getDate(5));

                p.setPrecioCompra(rs.getInt(6));
                datos.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Something is wrong in ProductoDAO" + e);
        }
        return datos;
    }

    public boolean Agregar(Producto p) throws SQLException {
        int pro = TablaOriginal(p.getProveedor());
        String sql = "INSERT INTO PRODUCTOS (NombreProducto, DescripcionProducto, Proveedor, FechaIngreso, PrecioCompra) VALUES (?,?," + pro + ",?,?)";

        try {
            ps = null;
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, p.getNombreProducto());
            ps.setString(2, p.getDescripcionProducto());

            Fecha = (p.getFechaIngreso());

            java.sql.Date fecha = new java.sql.Date(Fecha);
            try {

                ps.setDate(3, fecha);
            } catch (SQLException e) {
                System.out.println("En fecha " + fecha + " " + e);
            }
            ps.setInt(4, p.getPrecioCompra());

            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar Producto" + e);
            return false;
        }

    }

    public boolean Actualizar(Producto p) throws SQLException {
        int pro = TablaOriginal(p.getProveedor());
        String sql = "Update PRODUCTOS set  NombreProducto=?, DescripcionProducto=?, Proveedor=" + pro + ", FechaIngreso=?, PrecioCompra=? where CodigoProducto=?";

        try {
            ps = null;
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, p.getNombreProducto());
            ps.setString(2, p.getDescripcionProducto());
            Fecha = (p.getFechaIngreso());
            java.sql.Date fecha = new java.sql.Date(Fecha);
            try {

                ps.setDate(3, fecha);
            } catch (SQLException e) {
                System.out.println("En fecha " + fecha + " " + e);
            }
            ps.setInt(4, p.getPrecioCompra());
            ps.setInt(5, p.getCodigoProducto());

            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar Producto" + e);
            return false;
        }

    }

    public void Eliminar(int id) {
        String sql = "delete from PRODUCTOS where CodigoProducto =" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Producto Eliminado");
        } catch (SQLException e) {
            System.out.println("Error en eliminar" + e);
        }
    }
    public ArrayList Proveedor(){
        ArrayList<String> datos = new ArrayList<>();
        String sql= "select NombreProveedor from PROVEEDORES";
        try{
            
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(rs.getString(1));
            }
            
        }catch(SQLException e){
            System.out.println("Error en PRODUCTODAO "+ e);
        }
        return datos;
    }
}
