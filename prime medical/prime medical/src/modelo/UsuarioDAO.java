/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import vista.olvidocontraseña;

/**
 *
 * @author Jonathan
 */
public class UsuarioDAO {
    
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List Listar(){
        List<usuario>datos=new ArrayList<>();
        String sql="select * from USUARIOS";
        
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
        
            while(rs.next()){
                usuario p = new usuario();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setCorreo(rs.getString(4));
                p.setNumero(rs.getLong(5));
                p.setContraseña(rs.getString(6));
                datos.add(p);
                
            }
            System.out.println("doneeeee");
        }catch(SQLException e){
            
            System.out.println("fail");
        }
return datos;
    }
    public boolean añadirUsuario(usuario u) throws SQLException{
        String sql ="insert into  (NombreUsuario, ApellidoUsuario, Correo, Numero, Contra) values (?,?,?,?,?)";
        
        con=conectar.getConnection();
        ps=con.prepareStatement(sql);
        
        try{
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getCorreo());
            ps.setLong(4, u.getNumero());
            ps.setString(5, u.getContraseña());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        return false;
        }
        
    }
    public boolean validarUsuario(String user, String password){
        System.out.println("entre aqui" + user);
         List<usuario> Lista =Listar();
        for (int i = 0; i < Lista.size(); i++) {
            if(user.equals(Lista.get(i).getCorreo())&& password.equals(Lista.get(i).getContraseña())){
                
                return true;
            }
            System.out.println(Lista.get(i).getCorreo());
        }
        return false;
    }
   public boolean validarNombres(String Name, String LastName){
         List<usuario> Lista =Listar();
        for (int i = 0; i < Lista.size(); i++) {
            if(Name.equals(Lista.get(i).getNombre())&& LastName.equals(Lista.get(i).getApellido())){
                try {
                    enviarCorreo(Lista.get(i).getCorreo(),Lista.get(i).getNombre(),Lista.get(i).getId());
                } catch (MessagingException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }
            //System.out.println(Lista.get(i).getCorreo());
        }
        return false;
       
   }
   public boolean validarNumero(long Number){
       List<usuario> Lista =Listar();
       for (int i = 0; i < Lista.size(); i++) {
            if(Lista.get(i).getNumero()==Number){
                try {
                    enviarCorreo(Lista.get(i).getCorreo(),Lista.get(i).getNombre(),Lista.get(i).getId());
                } catch (MessagingException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }
        }
        return false;
       
       
   }public void enviarCorreo(String destino,String Nombre, int id) throws MessagingException{
        try {
            String correo = "ProyectRecover@outlook.com";
            String contraseña= "primemedicalsas77";
            String url = "https://proyectmarllo.000webhostapp.com/appphp/traerInformacion.php?id=";
            String carta = "Hola " + Nombre + "  para recuperar la contraseña ingresa a la siguiente dirección "
                    + "\n " + url+id;
            
            Properties pro = new Properties ();
            pro.put("mail.smtp.host","smtp.office365.com");
            pro.setProperty("mail.smtp.starttls.enable","true");
            pro.put("mail.smtp.ssl.trust","smtp.office365.com");
            pro.setProperty("mail.smtp.port","587");
            pro.setProperty("mail.smtp.user",correo);
            pro.setProperty("mail.smtp.password",contraseña);
            pro.setProperty("mail.smtp.auth","true");
            
            Session s = Session.getDefaultInstance(pro);
            MimeMessage mensaje= new MimeMessage (s);
            mensaje.setFrom(new InternetAddress(correo));
            mensaje.addRecipient(Message.RecipientType.TO,new InternetAddress(destino));
            mensaje.setSubject("Recuperar contraseña");
            mensaje.setText(carta);
            
            Transport t = s.getTransport("smtp");
            t.connect(correo,contraseña);
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            
            JOptionPane.showMessageDialog(null,"Mensaje enviado");
            
        } catch (AddressException ex) {
            Logger.getLogger(olvidocontraseña.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
   
    
    
}
