package modelo.producto;


import java.util.Date;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jonathan
 */
public class Producto {
    int CodigoProducto;
    String NombreProducto;
    String DescripcionProducto;
    String Proveedor;
    int provedor;
    Date Fecha;
    long FechaIngreso;
    int PrecioCompra;

   

    public Producto(int CodigoProducto, String NombreProducto, String DescripcionProducto, String Proveedor, int provedor, Date Fecha, long FechaIngreso, int PrecioCompra) {
        this.CodigoProducto = CodigoProducto;
        this.NombreProducto = NombreProducto;
        this.DescripcionProducto = DescripcionProducto;
        this.Proveedor = Proveedor;
        this.provedor = provedor;
        this.Fecha = Fecha;
        this.FechaIngreso = FechaIngreso;
        this.PrecioCompra = PrecioCompra;
    }
     public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    

    
    

    public Producto() {
    }

    
    public int getProvedor() {
        return provedor;
    }

    public void setProvedor(int provedor) {
        this.provedor = provedor;
    }

    public int getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(int CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    public void setDescripcionProducto(String DescripcionProducto) {
        this.DescripcionProducto = DescripcionProducto;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public long getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(long FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public int getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(int PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }
    
    
    
            
}
