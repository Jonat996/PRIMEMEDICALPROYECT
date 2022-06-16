/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Controlador;
import controlador.ControladorUsuario;
import javax.swing.JOptionPane;
import modelo.UsuarioDAO;
import modelo.usuario;

/**
 *
 * @author esteb
 */
public class Registro extends javax.swing.JFrame {

    /**
     * Creates new form registro
     */
    public Registro() {
        initComponents();
        
    }
    public void validar (){
    if(txtnombre.getText().isEmpty()){
    lsnombre.setText("Campo Requerido");
     }else{
    lsnombre.setText("");
     }
    if(txtapellido.getText().isEmpty()){
    lsapellido.setText("Campo Requerido");
     }else {
    lsapellido.setText ("");
     }
    if(txtcorreo.getText().isEmpty()){
    lscorreo.setText("Campo Requerido");
     }else {
    lscorreo.setText ("");
     }
    if(txtnumero.getText().isEmpty()){
    lsnumero.setText("Campo Requerido");
     }else {
    lsnumero.setText ("");
     }
    if(txtPassword.getText().isEmpty()){
    lscontraseña.setText("Campo Requerido");
     }else {
    lscontraseña.setText("");
     }
    if(txtnombre.getText().isEmpty() || txtapellido.getText().isEmpty()|| txtcorreo.getText().isEmpty()
            || txtnumero.getText().isEmpty()|| txtPassword.getText().isEmpty()){
    Registrar.setEnabled(false);
    }else{
     Registrar.setEnabled(true);
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        returnButtom = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        txtnumero = new javax.swing.JTextField();
        Registrar = new javax.swing.JButton();
        lsnombre = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        lsapellido = new javax.swing.JLabel();
        lscorreo = new javax.swing.JLabel();
        lsnumero = new javax.swing.JLabel();
        warning = new javax.swing.JLabel();
        lscontraseña = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Registrar1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        Iniciar = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        returnButtom.setText("Cancelar");
        returnButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtomActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/prime.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, 185));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PRIME MEDICAL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 152, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Apellido:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Correo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Numero:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Contraseña:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, -1, -1));

        txtnombre.setBorder(null);
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 180, 30));

        txtapellido.setBorder(null);
        txtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoActionPerformed(evt);
            }
        });
        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtapellidoKeyReleased(evt);
            }
        });
        getContentPane().add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 180, 30));

        txtcorreo.setBorder(null);
        txtcorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcorreoKeyReleased(evt);
            }
        });
        getContentPane().add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 430, 30));

        txtnumero.setBorder(null);
        txtnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroActionPerformed(evt);
            }
        });
        txtnumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnumeroKeyReleased(evt);
            }
        });
        getContentPane().add(txtnumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 190, 30));

        Registrar.setBackground(new java.awt.Color(40, 50, 253));
        Registrar.setForeground(new java.awt.Color(255, 255, 255));
        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 90, 30));
        getContentPane().add(lsnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, 110, -1));

        txtPassword.setText("jPasswordField1");
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 210, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/Cool Sky.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 520));
        getContentPane().add(lsapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 110, -1));
        getContentPane().add(lscorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 240, 110, -1));
        getContentPane().add(lsnumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 300, 110, -1));

        warning.setForeground(new java.awt.Color(204, 0, 0));
        warning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        warning.setText(".");
        getContentPane().add(warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 260, 30));
        getContentPane().add(lscontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, 110, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 430, 30));

        Registrar1.setBackground(new java.awt.Color(40, 50, 253));
        Registrar1.setForeground(new java.awt.Color(255, 255, 255));
        Registrar1.setText("Registrar");
        Registrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(Registrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 90, 30));

        jLabel10.setText("¿Ya Tienes una Cuenta?");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, -1, -1));

        Iniciar.setForeground(new java.awt.Color(0, 0, 204));
        Iniciar.setText("Inicia Sesión");
        getContentPane().add(Iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/Blue Raspberry.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 500, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        //Login g = new Login();
        //g.setVisible(true);
       // g.setLocationRelativeTo(g);
        //this.setVisible(false);
       

    //JOptionPane.showMessageDialog(null, "Registro exitoso");
    }//GEN-LAST:event_RegistrarActionPerformed

    private void returnButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtomActionPerformed
  
    }//GEN-LAST:event_returnButtomActionPerformed

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        
    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtapellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyReleased
        //validar ();
    }//GEN-LAST:event_txtapellidoKeyReleased

    private void txtcorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcorreoKeyReleased
      // validar();
    }//GEN-LAST:event_txtcorreoKeyReleased

    private void txtnumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroKeyReleased
        //validar();
    }//GEN-LAST:event_txtnumeroKeyReleased

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoActionPerformed

    private void txtnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void Registrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Registrar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 
        //ControladorPrincipal c = new ControladorPrincipal(v);
        
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Iniciar;
    public javax.swing.JButton Registrar;
    public javax.swing.JButton Registrar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lsapellido;
    private javax.swing.JLabel lscontraseña;
    private javax.swing.JLabel lscorreo;
    private javax.swing.JLabel lsnombre;
    private javax.swing.JLabel lsnumero;
    public javax.swing.JButton returnButtom;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtapellido;
    public javax.swing.JTextField txtcorreo;
    public javax.swing.JTextField txtnombre;
    public javax.swing.JTextField txtnumero;
    public javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
}
