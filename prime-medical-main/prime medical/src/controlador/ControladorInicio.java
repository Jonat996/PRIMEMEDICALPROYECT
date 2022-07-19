/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Inicio;
import vista.Login;
import vista.Principal;
import vista.Registro;

/**
 *
 * @author jonathan
 */
public class ControladorInicio implements ActionListener{
Inicio Vista = new Inicio();

    
    public ControladorInicio (Inicio v){
    this.Vista=v;
    this.Vista.ingresar.addActionListener(this);
    this.Vista.btnRegistrar.addActionListener(this);
}
    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource().equals(Vista.ingresar)){
        System.out.println("Estoy aqui");
        //Principal p = new Principal();
        //ControladorPrincipal cp = new ControladorPrincipal(p);
        //p.setVisible(true);
        //p.setLocationRelativeTo(p);
        Login l = new Login();
        ControladorLogin cl = new ControladorLogin(l);
        l.setVisible(true);
        l.setLocationRelativeTo(null);
        Vista.setVisible(false);
    }
    if(ae.getSource().equals(Vista.btnRegistrar)){
        Registro r = new Registro();
        ControladorUsuario cu = new ControladorUsuario(r);
        r.setVisible(true);
        r.setLocationRelativeTo(null);
        Vista.setVisible(false);
        
    }
    }
    
    
}
