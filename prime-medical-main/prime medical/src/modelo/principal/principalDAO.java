/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.inventario.Inventario;

/**
 *
 * @author jonathan
 */
public class principalDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List Listar() {
        List<Inventario> datos = new ArrayList<>();
        String sql = "Select CodigoInventario, NombreProducto, PrecioVenta "
                + "From inventario, productos where inventario.Producto=productos.CodigoProducto";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Inventario i = new Inventario();
                i.setCodigoInventario(rs.getInt(1));
                i.setNombre(rs.getString(2));
                i.setPrecioVenta(rs.getInt(3));
                datos.add(i);
            }
        } catch (SQLException e) {
            System.out.println("Something is wrong in PRINCIPAL DAO " + e);

        }
        return datos;
    }
    public boolean Actualizar(Inventario i) throws SQLException {

        ps = null;
        
        String sql = "Update inventario set  Cantidad=?,  where CodigoInventario=?";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, i.getCantidad());
            ps.setInt(2, i.getCodigoInventario());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("Something is wrong in PRINCIPALDAO si qui " + e);
            return false;
        }
    }

}
