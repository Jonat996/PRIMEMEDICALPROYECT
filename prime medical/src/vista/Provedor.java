/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ControladorProveedor;

/**
 *
 * @author jonathan
 */
public class Provedor extends javax.swing.JFrame { 

    /**
     * Creates new form Provedor
     */
    public Provedor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableProveedor = new javax.swing.JTable();
        btnListarProveedor = new javax.swing.JButton();
        AñadirProveedor = new javax.swing.JButton();
        NombreProveedor = new javax.swing.JTextField();
        NumeroProveedor = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        DescripcionProveedor = new javax.swing.JTextArea();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLogo = new javax.swing.JLabel();
        btnfondo = new javax.swing.JLabel();
        btnombreProveedor = new javax.swing.JLabel();
        btnNombre = new javax.swing.JLabel();
        Return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Descripcion", "Numero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableProveedor);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 590, 230));

        btnListarProveedor.setBackground(new java.awt.Color(40, 50, 253));
        btnListarProveedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnListarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnListarProveedor.setText("Consultar");
        btnListarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(btnListarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, 30));

        AñadirProveedor.setBackground(new java.awt.Color(40, 50, 253));
        AñadirProveedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AñadirProveedor.setForeground(new java.awt.Color(255, 255, 255));
        AñadirProveedor.setText("Añadir");
        getContentPane().add(AñadirProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 100, 30));

        NombreProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(NombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 84, -1));

        NumeroProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumeroProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(NumeroProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 84, -1));

        DescripcionProveedor.setColumns(20);
        DescripcionProveedor.setRows(5);
        jScrollPane2.setViewportView(DescripcionProveedor);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 300, 100));

        btnActualizar.setBackground(new java.awt.Color(40, 50, 253));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, -1, 30));

        btnEliminar.setBackground(new java.awt.Color(40, 50, 253));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(764, 250, 100, 30));

        btnLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/prime.png"))); // NOI18N
        getContentPane().add(btnLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 180));

        btnfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/Cool Sky.png"))); // NOI18N
        getContentPane().add(btnfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 440));

        btnombreProveedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnombreProveedor.setText("Nombre");
        getContentPane().add(btnombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, 20));

        btnNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNombre.setText("Numero");
        getContentPane().add(btnNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, 20));

        Return.setBackground(new java.awt.Color(40, 50, 253));
        Return.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Return.setForeground(new java.awt.Color(255, 255, 255));
        Return.setText("Return");
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });
        getContentPane().add(Return, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 90, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListarProveedorActionPerformed

    private void NombreProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreProveedorActionPerformed

    private void NumeroProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumeroProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumeroProveedorActionPerformed

    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReturnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Provedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Provedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Provedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Provedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Provedor r = new Provedor();
        ControladorProveedor c = new ControladorProveedor(r);
        r.setVisible(true);
        r.setLocationRelativeTo(r);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton AñadirProveedor;
    public javax.swing.JTextArea DescripcionProveedor;
    public javax.swing.JTextField NombreProveedor;
    public javax.swing.JTextField NumeroProveedor;
    public javax.swing.JButton Return;
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnListarProveedor;
    private javax.swing.JLabel btnLogo;
    private javax.swing.JLabel btnNombre;
    private javax.swing.JLabel btnfondo;
    private javax.swing.JLabel btnombreProveedor;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tableProveedor;
    // End of variables declaration//GEN-END:variables
}