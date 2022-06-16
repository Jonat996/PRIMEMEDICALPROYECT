/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.UsuarioDAO;
import modelo.usuario;
import vista.Inicio;
import vista.Login;
import vista.Principal;
import vista.Registro;

/**
 *
 * @author jonathan
 * 
 */

public class ControladorUsuario implements ActionListener, MouseListener{

    usuario u = new usuario();
    UsuarioDAO dao = new UsuarioDAO();
    Registro vista= new Registro();
    Login Vistal=new Login();

    public ControladorUsuario(Registro v) {
    this.vista=v;
    this.vista.Registrar.addActionListener(this);
    this.vista.returnButtom.addActionListener(this);
    this.vista.Iniciar.addMouseListener(this);
    }

    public ControladorUsuario(Login r) {
    this.Vistal=r;
   // this.Vistal.btnIngresar.addActionListener(this);
    }
   
    public boolean validar(){
         if(vista.txtnombre.getText().isEmpty()){
    vista.warning.setText("Nombre Requerido");
    
         return false;
         }else if(vista.txtapellido.getText().isEmpty()){
    vista.warning.setText("Apellido Requerido");
    return false;
     }else if(vista.txtcorreo.getText().isEmpty()){
    vista.warning.setText("Correo Requerido"); 
    return false;}else if(vista.txtnumero.getText().isEmpty()){
    
        vista.warning.setText("Número Requerido");
        
        
    return false;
    }if(!esNumero()){
        vista.warning.setText("Por Favor Ingrese un Número Valido");
        
        return false;
    }
         
        
    if(vista.txtPassword.getText().isEmpty()){
    vista.warning.setText("Contraseña Requerida");
    return false;
    }else {
    vista.warning.setText(""); 
    return true;
    }
    };
    public boolean esNumero(){
        try{
        Integer.parseInt(vista.txtnumero.getText());
            System.out.println("Es un número");
            return true;
    }catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, e);
        return false;
    }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==vista.Registrar){
        if(validar()){
            
        u.setNombre(vista.txtnombre.getText());
        u.setApellido(vista.txtapellido.getText());
        u.setCorreo(vista.txtcorreo.getText());
        u.setNumero(Long.parseLong(vista.txtnumero.getText()));
        u.setContraseña((vista.txtPassword.getText()));
        
        try {
            
            if(dao.añadirUsuario(u)){
            JOptionPane.showMessageDialog(null, "Usuario registrado con exito!");     
            Login l = new Login();
            ControladorLogin cl= new ControladorLogin(l);
            vista.hide();
            l.setVisible(true);
            l.setLocationRelativeTo(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        //else{
          //  vista.warning.setText("Algo está mal...");
        //}
        
    }
    if(ae.getSource().equals(vista.returnButtom)){
        Inicio ic = new Inicio ();
        ControladorInicio ci = new ControladorInicio(ic);
  ic.setVisible (true);
  ic.setLocationRelativeTo(null);
  vista.setVisible(false);
    }
    if(ae.getSource()==Vistal.btnIngresar){
        String user=Vistal.userText.getText();
        String password=Vistal.passText.getText();
        
        if(dao.validarUsuario(user, password)){
            JOptionPane.showMessageDialog(null, "El usuario es correcto (y");
            Principal o = new Principal (); 
o.setVisible (true);
o.setLocationRelativeTo(null);
    Vistal.setVisible(false);
        }else{
             JOptionPane.showMessageDialog(null, "El usuario es incorrecto");
           
        }
        
    }
    
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if(me.getSource().equals(vista.Iniciar)){
            Login l = new Login();
            ControladorLogin cl= new ControladorLogin(l);
            vista.hide();
            l.setVisible(true);
            l.setLocationRelativeTo(null);
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
    
    public void ingresar(String user, String pass){
        
    }
    
    
}
