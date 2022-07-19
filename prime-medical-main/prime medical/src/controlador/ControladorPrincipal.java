/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.inventario.Inventario;
import modelo.inventario.InventarioDAO;
import vista.AgregarCarritoo;
import vista.Pagar;
import vista.Principal;
import vista.Productos;
import vista.Provedor;
import vista.inventario;

/**
 *
 * @author jonathan
 */
public class ControladorPrincipal implements ActionListener, KeyListener {

    Principal Vista = new Principal();
    AgregarCarritoo VistaA = new AgregarCarritoo();
    Pagar VistaB = new Pagar();
    InventarioDAO dao = new InventarioDAO();
    public List<Inventario> lista = traerLista();
    DefaultTableModel modelo = new DefaultTableModel();
    public int code = Integer.MIN_VALUE;
    public int Total = Integer.MIN_VALUE;

    public ControladorPrincipal(Principal v, AgregarCarritoo view, Pagar pa) {
        this.Vista = v;
       
        this.VistaA = view;
        this.VistaA.Codigo.addKeyListener(this);
        this.VistaA.cantidad.addKeyListener(this);
        this.VistaA.Agregar.addActionListener(this);
        this.VistaA.delete.addActionListener(this);
        this.VistaA.cobrar.addActionListener(this);
        this.VistaB = pa;
        this.VistaB.pagar.addActionListener(this);
        this.VistaB.pago.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(Vista)) {
            Provedor r = new Provedor();
            ControladorProveedor c = new ControladorProveedor(r);
            c.ListarProveedor(c.Vista.tableProveedor);

            r.setVisible(true);
            r.setLocationRelativeTo(null);
            Vista.hide();
        }
        if (ae.getSource().equals(Vista)) {
            inventario i = new inventario();
            ControladorInventario ci = new ControladorInventario(i);
            ci.ListarInventario(ci.Vista.TablaInventario);
            i.setVisible(true);
            i.setLocationRelativeTo(null);

        }
        if (ae.getSource().equals(Vista)) {
            Productos p = new Productos();
            ControladorProducto cp = new ControladorProducto(p);
            try {
                cp.ListarProducto(cp.Vista.TablaProducto);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            p.setVisible(true);
            p.setLocationRelativeTo(null);
            Vista.hide();
        }
        if (ae.getSource().equals(VistaA.Agregar)) {
            Añadir(Vista.Table);
            sumarTotal();
        }
        if (ae.getSource().equals(VistaA.delete)) {
            eliminar();
        }
        if (ae.getSource().equals(VistaA.cobrar)) {

            VistaB.setSize(600, 96);
            VistaB.setLocation(0, 0);
            Vista.background.removeAll();
            Vista.background.add(VistaB, BorderLayout.CENTER);
            Vista.background.revalidate();
            Vista.background.repaint();

        }
        if (ae.getSource().equals(VistaB.pagar)) {
            descontarCantidad();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource().equals(VistaA.Codigo)) {
            System.out.println("yeah i'm here men... ");

         
            VistaA.anunciar.setText("Hola bb");
            if (validarCodigo()) {
                VistaA.anunciar.setText("OK");
            }

        }
        if (ke.getSource().equals(VistaA.cantidad)) {
            if (validarCantidad()) {
                VistaA.anunciar.setText("ok");
            }
        }
        if (ke.getSource().equals(VistaB.pago)) {
            int result = Integer.parseInt(VistaB.pago.getText()) - Total;
                VistaB.devolver.setText(String.valueOf(result));
            
            if (result < 0) {
                VistaB.anunciar.setText("El monto no es suficiente");
            
            }else{
                    VistaB.anunciar.setText("Correcto");
            
            }
        }
    }

    //Metodos para La vista AÑADIR CARRITO
    public static List traerLista() {
        InventarioDAO dao = new InventarioDAO();
        List<Inventario> Lista = dao.Listar();
        return Lista;
    }

    public boolean validarCodigo() {
        try {
            int cod = Integer.parseInt(VistaA.Codigo.getText());
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getCodigoInventario() == cod) {
                    code = i;
                    return true;
                }
            }
            VistaA.anunciar.setText("El codigo NO existe");
            return false;

        } catch (NumberFormatException e) {
            VistaA.anunciar.setText("El campo NO es un numero1!");
            return false;
        }
    }

    public boolean validarCantidad() {
        try {
            int can = Integer.parseInt(VistaA.cantidad.getText());

            System.out.println(lista.get(code).getCantidad());
            if ((lista.get(code).getCantidad() - can) >= 0) {
                return true;
            }

            VistaA.anunciar.setText("Se ha excedido la cantidad existe!");
            return false;
        } catch (NumberFormatException e) {
            VistaA.anunciar.setText("El campo NO es un numero2!");
            return false;
        }
    }

    public void Añadir(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        Object[] object = new Object[5];

        object[0] = lista.get(code).getCodigoInventario();
        object[1] = lista.get(code).getNombre();
        object[2] = lista.get(code).getPrecioVenta();
        object[3] = VistaA.cantidad.getText();
        int c = Integer.parseInt(VistaA.cantidad.getText());
        object[4] = (lista.get(code).getPrecioVenta() * c);
        modelo.addRow(object);
        LimpiarCamposA();
    }

    public void LimpiarCamposA() {
        VistaA.Codigo.setText("");
        VistaA.cantidad.setText("");

    }
    public void LimpiarCamposB(){
        VistaB.pago.setText("");
        VistaB.total.setText("");
        Vista.Table.removeAll();
        int tamaño=Vista.Table.getRowCount();
        for (int i = 0; i < tamaño; i++) {
            modelo.removeRow(0);
        }
    }

    public void eliminar() {
        System.out.println("hola " + Vista.Table.getSelectedRow());
        modelo.removeRow(Vista.Table.getSelectedRow());
    }
    //TERMINAN LOS METODOS PARA LA VISTA AÑADOR CARRITO


    //METODOS PARA PAGAR
    public void sumarTotal() {
        int total = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            int num = Integer.parseInt(modelo.getValueAt(i, 4).toString());
            total += num;

        }
        Total = total;
        VistaB.total.setText(String.valueOf(total));

    }

    public void descontarCantidad() {
        for (int i = 0; i < Vista.Table.getRowCount(); i++) {
            int can = Integer.parseInt(modelo.getValueAt(i, 3).toString());

            int cod = Integer.parseInt(modelo.getValueAt(i, 0).toString());
            for (int j = 0; j < lista.size(); j++) {
                if (cod == lista.get(j).getCodigoInventario()) {
                    can = lista.get(j).getCantidad() - can;
                    System.out.println(can + "s");
                    if (can >= 0) {

                        if (dao.descontarCantidad(can, cod)) {
                            JOptionPane.showMessageDialog(null, "Compra Realizada");
                            VistaA.setSize(600, 96);
                    VistaA.setLocation(0, 0);

                    Vista.background.removeAll();
                    Vista.background.add(VistaA, BorderLayout.CENTER);
                    Vista.revalidate();
                    Vista.repaint();
                        LimpiarCamposB();
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "ha ocurrido un error en el pago");
                        }
                    } 
                }
            }
        }
    }

}
