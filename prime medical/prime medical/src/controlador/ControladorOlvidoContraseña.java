/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.UsuarioDAO;
import vista.Login;
import vista.olvidocontraseña;

/**
 *
 * @author jonathan
 */
public class ControladorOlvidoContraseña implements ActionListener{
    
    olvidocontraseña Vista = new olvidocontraseña();
    UsuarioDAO dao = new UsuarioDAO();
    public ControladorOlvidoContraseña(olvidocontraseña v) {
    this.Vista=v;
    this.Vista.btnIniciarSesion.addActionListener(this);
    this.Vista.btnEnviar.addActionListener(this);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(Vista.btnIniciarSesion)){
            Login l = new Login();
            ControladorLogin cl = new ControladorLogin(l);
            l.setVisible(true);
            l.setLocationRelativeTo(null);
            Vista.setVisible(false);
        }
        if(ae.getSource().equals(Vista.btnEnviar)){
            
                
            if(validarNombres()){
                if(dao.validarNombres(Vista.txtNombre.getText(), Vista.txtApellido.getText())){
                JOptionPane.showMessageDialog(null, "Se ha enviado el siguiente paso a tu correo");
                }else{
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error!");
                
                }
            }else if(validarNumero()){
                
                if(dao.validarNumero(Long.parseLong(Vista.txtNumero.getText()))){
                JOptionPane.showMessageDialog(null, "Se ha enviado el siguiente paso a tu correo");    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error!");
                
                }
            }
            else{
                    Vista.Anunciar.setText("Los Campos estan vacíos!!");
                
                
            }
            
        
        }
    }
    public boolean validarNombres(){
        return !"Nombre".equals(Vista.txtNombre.getText())&&!"Apellido".equals(Vista.txtApellido.getText());
    };
    public boolean validarNumero(){
        if(!Vista.txtNumero.getText().equals("")){
            
            try{
                Long.parseLong(Vista.txtNumero.getText());
                return true;
            }catch (NumberFormatException e){
                Vista.Anunciar.setText("El valor ingresado NO es un número");
            return false;
            }
        }return false;
    }
    
    
    
}
