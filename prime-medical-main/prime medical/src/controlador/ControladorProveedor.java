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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.provedor.ProvedoresDAO;
import modelo.provedor.Proveedores;
import vista.AgregarCarritoo;
import vista.Pagar;
import vista.Principal;
import vista.Provedor;

/**
 *
 * @author jonathan
 */
public class ControladorProveedor implements ActionListener, MouseListener {

    ProvedoresDAO dao = new ProvedoresDAO();
    Proveedores p = new Proveedores();
    Provedor Vista = new Provedor();

    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorProveedor(Provedor v) {
        this.Vista = v;
        this.Vista.btnListarProveedor.addActionListener(this);
        this.Vista.AñadirProveedor.addActionListener(this);
        this.Vista.tableProveedor.addMouseListener(this);
        this.Vista.btnActualizar.addMouseListener(this);
        this.Vista.btnEliminar.addMouseListener(this);
        this.Vista.Return.addActionListener(this);

    }

    public ControladorProveedor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Vista.btnListarProveedor) {
            
            System.out.println("Presionado");
            LimpiarConsultas(Vista.tableProveedor);
            ListarProveedor(Vista.tableProveedor);

        }
        if (e.getSource() == Vista.AñadirProveedor) {

            p.setNombreProveedor(Vista.NombreProveedor.getText());
            p.setDescripcion(Vista.DescripcionProveedor.getText());
            p.setNumero(Long.parseLong(Vista.NumeroProveedor.getText()));
            if (dao.Agregar(p)) {
                
                JOptionPane.showMessageDialog(null, "Producto Agregado");
                LimpiarCampos();
                    ListarProveedor(Vista.tableProveedor);
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar");
            }
        }
        if(e.getSource().equals(Vista.Return)){
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
    

    public void ListarProveedor(JTable tabla) {
        LimpiarConsultas(Vista.tableProveedor);
        modelo = (DefaultTableModel) tabla.getModel();
        List<Proveedores> Lista = dao.Listar();
        Object[] object = new Object[4];
        for (int i = 0; i < Lista.size(); i++) {
            object[0] = Lista.get(i).getCodigoProveedor();
            object[1] = Lista.get(i).getNombreProveedor();
            object[2] = Lista.get(i).getDescripcion();
            object[3] = Lista.get(i).getNumero();
            modelo.addRow(object);
        }

    }
    public void LimpiarConsultas(JTable tabla){
    modelo = (DefaultTableModel) tabla.getModel();
    System.out.println("s "+ tabla.getRowCount());
    
    int tamaño = modelo.getRowCount();
    if( tamaño>0){
        for (int j = 0; j < tamaño; j++) {
            System.out.println("pasé " + j);
            
            modelo.removeRow(0);
            
        }   } 
    
}
    public void LimpiarCampos(){
        Vista.NombreProveedor.setText("");
        Vista.NumeroProveedor.setText("");
        Vista.DescripcionProveedor.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == Vista.tableProveedor) {

            int fila = Vista.tableProveedor.getSelectedRow();
            int Codigo = Integer.parseInt(Vista.tableProveedor.getValueAt(fila, 0).toString());
            Vista.NombreProveedor.setText(Vista.tableProveedor.getValueAt(fila, 1).toString());
            Vista.DescripcionProveedor.setText(Vista.tableProveedor.getValueAt(fila, 2).toString());
            Vista.NumeroProveedor.setText(Vista.tableProveedor.getValueAt(fila, 3).toString());
        }
        if (me.getSource() == Vista.btnActualizar) {

            int fila = Vista.tableProveedor.getSelectedRow();
            int Codigo = Integer.parseInt(Vista.tableProveedor.getValueAt(fila, 0).toString());
            p.setCodigoProveedor(Codigo);
            p.setNombreProveedor(Vista.NombreProveedor.getText());
            p.setDescripcion(Vista.DescripcionProveedor.getText());
            p.setNumero(Long.parseLong(Vista.NumeroProveedor.getText()));

            try {
                if (dao.Actualizar(p)) {
                    JOptionPane.showMessageDialog(Vista, "El Proveedor se ha actualizado satisfactoriamente");
                    
                    LimpiarCampos();
                    ListarProveedor(Vista.tableProveedor);
                    
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(Vista, "El Proveedor NO se ha actualizado");
            }
        }
        if (me.getSource() == Vista.btnEliminar) {
            int fila = Vista.tableProveedor.getSelectedRow();
            int Codigo = Integer.parseInt(Vista.tableProveedor.getValueAt(fila, 0).toString());

            dao.Eliminar(Codigo);
            LimpiarCampos();
                    ListarProveedor(Vista.tableProveedor);

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

}
