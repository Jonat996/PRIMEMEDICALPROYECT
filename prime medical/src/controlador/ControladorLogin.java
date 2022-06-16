/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.UsuarioDAO;
import vista.AgregarCarritoo;
import vista.Inicio;
import vista.Login;
import vista.Pagar;
import vista.Principal;
import vista.olvidocontraseña;

/**
 *
 * @author jonathan
 */
public class ControladorLogin implements ActionListener {

    Login Vista = new Login();
    UsuarioDAO dao = new UsuarioDAO();

    public ControladorLogin(Login v) {
        this.Vista = v;
        this.Vista.btnIngresar.addActionListener(this);
        this.Vista.btnOlvidar.addActionListener(this);
        this.Vista.returnButtom.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(Vista.btnIngresar)) {
            if (comprobarCampos()) {
                String user = Vista.userText.getText();
                String password = Vista.passText.getText();
                //JOptionPane.showMessageDialog(null, "OK");
                if (dao.validarUsuario(user, password)) {

                    for (int i = 0; i < 5; i++) {

                        try {
                            // it will sleep the main thread for 1 sec
                            // ,each time the for loop runs
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        // printing the value of the variable
                        System.out.println(i);
                    }

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
                } else {
                    Vista.warning.setText("El Usuario es Incorrecto!");
                    Vista.warning.setForeground(Color.red);

                }
            }
        }
        if (ae.getSource().equals(Vista.returnButtom)) {
            Inicio i = new Inicio();
            ControladorInicio ci = new ControladorInicio(i);
            i.setVisible(true);
            i.setLocationRelativeTo(null);
            Vista.setVisible(false);
        }
        if (ae.getSource().equals(Vista.btnOlvidar)) {
            olvidocontraseña oc = new olvidocontraseña();
            ControladorOlvidoContraseña coc = new ControladorOlvidoContraseña(oc);
            oc.setVisible(true);
            oc.setLocationRelativeTo(null);
            Vista.setVisible(false);
        }
    }

    public boolean comprobarCampos() {
        if (!Vista.passText.getText().equals("") && !Vista.userText.getText().equals("")) {
            Vista.warning.setText("");
            Vista.warning.setForeground(Color.red);

            System.out.println(Vista.userText.getText());
            return true;
        } else {
            System.out.println("sisisisi" + Vista.passText.getText());
            //JOptionPane.showMessageDialog(null, "Los campos están vacios");

            if (Vista.passText.getText().equals("") && Vista.userText.getText().equals("")) {
                Vista.warning.setText("Los campos están vacios");
                Vista.warning.setForeground(Color.red);
            } else if (Vista.passText.getText().equals("")) {
                Vista.warning.setText("Por Favor Ingrese una Contraseña");
                Vista.warning.setForeground(Color.red);
            } else if (Vista.userText.getText().equals("")) {
                Vista.warning.setText("Por Favor Ingrese un Usuario");
                Vista.warning.setForeground(Color.red);
            } else {
                Vista.warning.setText("");
                Vista.warning.setForeground(Color.red);
            }
            return false;
        }

    }

}
