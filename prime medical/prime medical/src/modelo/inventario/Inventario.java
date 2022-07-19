/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.inventario;

/**
 *
 * @author jonathan
 */
public class Inventario {
    int CodigoInventario;
    int NombreProducto;
    String Nombre;
    int Cantidad;
    int PrecioVenta;

    public Inventario() {
    }

    public Inventario(int CodigoInventario, int NombreProducto,String Nombre, int Cantidad, int PrecioVenta) {
        this.CodigoInventario = CodigoInventario;
        this.NombreProducto = NombreProducto;
        this.Nombre=Nombre;
        this.Cantidad = Cantidad;
        this.PrecioVenta = PrecioVenta;
    }

    public int getCodigoInventario() {
        return CodigoInventario;
    }

    public void setCodigoInventario(int CodigoInventario) {
        this.CodigoInventario = CodigoInventario;
    }

    public int getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(int NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(int PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }
    
    
}
