/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.provedor;

/**
 *
 * @author jonathan
 */
public class Proveedores {
   private int CodigoProveedor;
   private String NombreProveedor;
   private String Descripcion;
   private Long Numero;

    public Proveedores() {
    }

    public Proveedores(int CodigoProveedor, String NombreProveedor, String Descripcion, Long Numero) {
        this.CodigoProveedor = CodigoProveedor;
        this.NombreProveedor = NombreProveedor;
        this.Descripcion = Descripcion;
        this.Numero = Numero;
    }

    public Long getNumero() {
        return Numero;
    }

    public void setNumero(Long Numero) {
        this.Numero = Numero;
    }

    public int getCodigoProveedor() {
        return CodigoProveedor;
    }

    public void setCodigoProveedor(int CodigoProveedor) {
        this.CodigoProveedor = CodigoProveedor;
    }

    public String getNombreProveedor() {
        return NombreProveedor;
    }

    public void setNombreProveedor(String NombreProveedor) {
        this.NombreProveedor = NombreProveedor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
   
    
}
