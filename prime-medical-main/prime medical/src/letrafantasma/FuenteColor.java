/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package letrafantasma;

import javax.swing.JTextField;

/**
 *
 * @author esteb
 */
public class FuenteColor {
    String plomo= "#818181";
    String negro= "#000000";
    
    public void mensaje (JTextField letra, String mensaje,int tamaño){
    
    
        if(tamaño==0){
        letra.setText(mensaje);
        letra.setForeground(java.awt.Color.decode(plomo));
        }
    }
    
    public void Click(JTextField letra, String mensaje){
    
        if(letra.getText().equals (mensaje)){
        letra.setText ("");
         letra.setForeground(java.awt.Color.decode(negro));
        }
    
    }
}
