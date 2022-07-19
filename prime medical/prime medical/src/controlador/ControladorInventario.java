/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import vista.inventario;

/**
 *
 * @author jonathan
 */
public class ControladorInventario implements ActionListener, MouseListener {

    InventarioDAO dao = new InventarioDAO();
    Inventario i = new Inventario();
    inventario Vista = new inventario();

    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorInventario(inventario v) {
        this.Vista = v;
      
        this.Vista.btnAgregar.addActionListener(this);
        this.Vista.TablaInventario.addMouseListener(this);
        this.Vista.btnEliminar.addMouseListener(this);
        this.Vista.btnActualizar.addMouseListener(this);
        this.Vista.Return.addActionListener(this);
    }

    public ControladorInventario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //Este codigo Viene de las acciones que se realicen en los botones CUALQUIER TIPO DE ACCION puede ser CLICK o un ENTER
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(Vista)) {

            try {

                ListarInventario(Vista.TablaInventario);

            } catch (Exception err) {
                System.out.println(err);
            }

        }
        if (e.getSource().equals(Vista.btnAgregar)) {
            i.setNombre(Vista.Nombre.getSelectedItem().toString());
            i.setCantidad(Integer.parseInt(Vista.Cantidad.getText()));

            i.setPrecioVenta(Integer.parseInt(Vista.PrecioVenta.getText()));

            try {
                if (dao.Agregar(i)) {
                    JOptionPane.showConfirmDialog(null, "Envio de datos Correcto");
                    ListarInventario(Vista.TablaInventario);
                    Limpiar();

                } else {
                    JOptionPane.showConfirmDialog(null, "Envio de datos Incorrecto");

                }

            } catch (SQLException ex) {
                Logger.getLogger(ControladorInventario.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        if (e.getSource().equals(Vista.Return)) {
            Principal v = new Principal();
            AgregarCarritoo ag = new AgregarCarritoo();
            Pagar pa = new Pagar();
            ControladorPrincipal cp = new ControladorPrincipal(v, ag, pa);
            v.setVisible(true);
            v.setLocationRelativeTo(null);

            ag.setSize(600, 96);
            ag.setLocation(0, 0);

            v.background.removeAll();
            v.background.add(ag, BorderLayout.CENTER);
            v.revalidate();
            v.repaint();

            Vista.hide();

        }

    }

    //Este codigo se encarga de limpiar la tabla de consoltas
    public void LimpiarConsultas(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        System.out.println("s " + tabla.getRowCount());

        int tamaño = modelo.getRowCount();
        if (tamaño > 0) {
            for (int j = 0; j < tamaño; j++) {
                System.out.println("pasé " + j);

                modelo.removeRow(0);
                Vista.Nombre.removeAllItems();

            }
        }

    }

//Este codigo se encarga de Pintar la tabla
    public void ListarInventario(JTable tabla) {
        LimpiarConsultas(Vista.TablaInventario);
        modelo = (DefaultTableModel) tabla.getModel();

        List<Inventario> Lista = dao.Listar();
        Object[] object = new Object[4];

        listarNombres();
        for (int i = 0; i < Lista.size(); i++) {

            object[0] = Lista.get(i).getCodigoInventario();

            object[1] = Lista.get(i).getNombre();
            object[2] = Lista.get(i).getCantidad();
            object[3] = Lista.get(i).getPrecioVenta();

            modelo.addRow(object);

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    //Aqui capturamos cuando el usuario presiona el boton 
    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getSource() == Vista.TablaInventario) {
            System.out.println("Llegue aqui");
            int fila = Vista.TablaInventario.getSelectedRow();

            int Codigo = Integer.parseInt(Vista.TablaInventario.getValueAt(fila, 0).toString());

            Vista.Nombre.setSelectedItem(Vista.TablaInventario.getValueAt(fila, 1));
            Vista.Cantidad.setText(Vista.TablaInventario.getValueAt(fila, 2).toString());
            Vista.PrecioVenta.setText(Vista.TablaInventario.getValueAt(fila, 3).toString());
            JOptionPane.showMessageDialog(null, "Producto Seleccionado " + Codigo);
        }

        if (e.getSource().equals(Vista.btnEliminar)) {
            //JOptionPane.showMessageDialog(null, "Hice esto" + Vista.TablaInventario.getValueAt(5, 2));

            int fila = Vista.TablaInventario.getSelectedRow();

            Object prueba = Vista.TablaInventario.getValueAt(fila, 0);
            System.out.println(prueba);
            dao.Eliminar(Integer.parseInt(prueba.toString()));
            ListarInventario(Vista.TablaInventario);
            Limpiar();
        }
        if (e.getSource().equals(Vista.btnActualizar)) {
            JOptionPane.showMessageDialog(null, "Hice estooooo");
            System.out.println("Estoy en actualizar");
            int fila = Vista.TablaInventario.getSelectedRow();
            int colum = Vista.TablaInventario.getSelectedColumn();

            //Llevar campos de la tabla a cuatros de texto
            int Codigo = Integer.parseInt(Vista.TablaInventario.getValueAt(fila, 0).toString());

            i.setCodigoInventario(Codigo);
            i.setNombre(Vista.Nombre.getSelectedItem().toString());
            i.setCantidad(Integer.parseInt(Vista.Cantidad.getText()));

            i.setPrecioVenta(Integer.parseInt(Vista.PrecioVenta.getText()));

            try {
                if (dao.Actualizar(i)) {
                    ListarInventario(Vista.TablaInventario);
                    Limpiar();
                 JOptionPane.showMessageDialog(null, "Envio de datos correcto");
                } else {
                 JOptionPane.showMessageDialog(null, "Envio de datos incorrecto");
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorInventario.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    // aqui dejamos los valores que escribió y seleccionó el usuario vacios
    public void Limpiar() {
        Vista.Nombre.setSelectedItem("");
        Vista.Cantidad.setText("");
        Vista.PrecioVenta.setText("");

    }

    public void listarNombres() {
        for (int i = 0; i < dao.Nombres().size(); i++) {
            Vista.Nombre.addItem(dao.Nombres().get(i).toString());
        }
    }

}
