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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.producto.Producto;
import modelo.producto.ProductoDAO;
import vista.AgregarCarritoo;
import vista.Pagar;
import vista.Principal;
import vista.Productos;

/**
 *
 * @author jonathan
 */
public class ControladorProducto implements ActionListener, MouseListener {

    ProductoDAO dao = new ProductoDAO();
    Producto p = new Producto();
    Productos Vista = new Productos();

    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorProducto(Productos v) {
        this.Vista = v;
      
        this.Vista.AgregarProducto.addActionListener(this);
        this.Vista.TablaProducto.addMouseListener(this);
        this.Vista.btnActualizar.addMouseListener(this);
        this.Vista.btnEliminar.addActionListener(this);
        this.Vista.Return.addActionListener(this);
    }

    public ControladorProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if(e.getSource()==Vista.Proveedor){

        //  System.out.println("LLegue aqui");
        //dao.iguales(Vista.ProveedorProducto.getSelectedItem().toString());
        //}
        if (e.getSource() == Vista) {
            System.out.println("Presionado");
            try {
                ListarProducto(Vista.TablaProducto);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        if (e.getSource() == Vista.AgregarProducto) {
            p.setNombreProducto(Vista.NombreProducto.getText());
            p.setDescripcionProducto(Vista.Descripcion.getText());
            p.setProveedor(Vista.ProveedorProducto.getSelectedItem().toString());
            Date date = Vista.FechaIngreso.getDate();
            long d = date.getTime();

            p.setFechaIngreso(d);
            System.out.println("Esta es la fecha: " + d);
            System.out.println(Vista.FechaIngreso.getDate());
            p.setPrecioCompra(Integer.parseInt(Vista.PrecioCompra.getText()));
            try {
                if (dao.Agregar(p)) {
                    JOptionPane.showMessageDialog(null, "Producto Agregado");
                    ListarProducto(Vista.TablaProducto);
                    LimpiarCampos();LimpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo Agregar el Producto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == Vista.btnEliminar) {
            System.out.println("Estuve aqui");
            int fila = Vista.TablaProducto.getSelectedRow();
            int Codigo = Integer.parseInt(Vista.TablaProducto.getValueAt(fila, 0).toString());
            dao.Eliminar(Codigo);
            try {
                ListarProducto(Vista.TablaProducto);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
                    LimpiarCampos();      }
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
                    Vista.setVisible(false);
        }

    }

    public void ListarProducto(JTable tabla) throws SQLException {
        LimpiarConsultas(Vista.TablaProducto);
        modelo = (DefaultTableModel) tabla.getModel();
        List<Producto> Lista = dao.Listar();
        Object[] object = new Object[6];
        proveedores();
        for (int i = 0; i < Lista.size(); i++) {
            object[0] = Lista.get(i).getCodigoProducto();
            object[1] = Lista.get(i).getNombreProducto();
            object[2] = Lista.get(i).getDescripcionProducto();
            object[3] = Lista.get(i).getProveedor();
            
            object[4] = Lista.get(i).getFecha();
            object[5] = Lista.get(i).getPrecioCompra();
            modelo.addRow(object);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == Vista.TablaProducto) {
            int fila = Vista.TablaProducto.getSelectedRow();
            Vista.NombreProducto.setText(Vista.TablaProducto.getValueAt(fila, 1).toString());
            Vista.Descripcion.setText(Vista.TablaProducto.getValueAt(fila, 2).toString());
            Date fecha;
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            Vista.ProveedorProducto.setSelectedItem(Vista.TablaProducto.getValueAt(fila, 3));
            try {
                fecha = formato.parse(Vista.TablaProducto.getValueAt(fila, 4).toString());
                Vista.FechaIngreso.setDate(fecha);

            } catch (ParseException ex) {
                Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
            Vista.PrecioCompra.setText(Vista.TablaProducto.getValueAt(fila, 5).toString());

            System.out.println("Estoy en Tabla");
        }
        if (me.getSource() == Vista.btnActualizar) {
            int fila = Vista.TablaProducto.getSelectedRow();
            int Codigo = Integer.parseInt(Vista.TablaProducto.getValueAt(fila, 0).toString());
            p.setCodigoProducto(Codigo);
            p.setNombreProducto(Vista.NombreProducto.getText());
            p.setDescripcionProducto(Vista.Descripcion.getText());
            p.setProveedor(Vista.ProveedorProducto.getSelectedItem().toString());
            Date date = Vista.FechaIngreso.getDate();
            long d = date.getTime();

            p.setFechaIngreso(d);

            p.setPrecioCompra(Integer.parseInt(Vista.PrecioCompra.getText()));
            try {
                if (dao.Actualizar(p)) {
                    JOptionPane.showMessageDialog(null, "Producto Agregado");
                    ListarProducto(Vista.TablaProducto);
                    LimpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo Agregar el Producto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
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

    public void LimpiarConsultas(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        System.out.println("s " + tabla.getRowCount());

        int tamaño = modelo.getRowCount();
        if (tamaño > 0) {
            for (int j = 0; j < tamaño; j++) {
                System.out.println("pasé " + j);

                modelo.removeRow(0);

            }
            Vista.ProveedorProducto.removeAllItems();
        }

    }

    public void LimpiarCampos() {
        Vista.NombreProducto.setText("");
        Vista.Descripcion.setText("");
        Vista.ProveedorProducto.setSelectedItem("");
        Vista.PrecioCompra.setText("000");
   
   }
    public void proveedores(){
        for (int i = 0; i < dao.Proveedor().size(); i++) {
            Vista.ProveedorProducto.addItem(dao.Proveedor().get(i));
        }
    }
}
