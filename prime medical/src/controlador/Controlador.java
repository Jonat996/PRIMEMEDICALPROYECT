/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioDAO;
import modelo.usuario;
import vista.Inicio;
import vista.Login;
import vista.inventario;
import vista.olvidocontraseña;



/**
 *
 * @author Jonathan
 */

//Esta clase se encarga de escuchar todas las acciones echas por las vistas
public class Controlador implements ActionListener{
Inicio Vista = new Inicio();
    Login in = new Login();
    public Controlador(Inicio v){
    this.Vista=v;
    this.Vista.ingresar.addActionListener(this);
    
}
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(Vista.ingresar)){
        in.setVisible(true);
        in.setLocationRelativeTo(null);
        Vista.setVisible(false);
        
        }
    

       
    }
    

        //in.setVisible(true);
        //in.setLocationRelativeTo(null);
        //this.setVisible(false);
}
