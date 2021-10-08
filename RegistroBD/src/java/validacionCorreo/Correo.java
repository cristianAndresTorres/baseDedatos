/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validacionCorreo;

import modelo.Usuario;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author 57301
 */
public class Correo {
    //Atributos
    private static boolean estado;
    
    //Realizad la conexión y envia el correo
    public static boolean enviarCorreo(Usuario miUsuario){   
        Correo.estado = false;
        try {
            String correo = "cc1999torres@gmail.com";
            String contra = "muqkycdodydvedzh";
            String correoDestino = miUsuario.getCorreo();
            String cuerpo_1 = "Cordial saludo, "+miUsuario.getNombre()+" "+miUsuario.getApellido() + ".\n";
            cuerpo_1+="Enlace de confirmación :\n";
            
            String cuerpo = cuerpo_1+"http://localhost:8090/RegistroBD/validacion.jsp?";
            cuerpo +="nom="+miUsuario.getNombre()+"&ap="+miUsuario.getApellido()+"&usu="+miUsuario.getAlias()+
                    "&correo="+miUsuario.getCorreo();
            
            
            Properties p = new Properties();
            

            //Se envian las propiedades
            //Hosting->Dominio desde el que se envia
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", correo);
            p.setProperty("mail.smtp.auth", "true");

          //crear sesion
            Session s =Session.getDefaultInstance(p);

            //Construir el mensaje
            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(correo));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
            mensaje.setSubject("Registro aplicativo");
            //mensaje.setText("http://localhost:8090/RegistroBD/registroValidacion.jsp?&correo=cratorresc@gmail.com");
            mensaje.setText(cuerpo);
                    
            Transport t = s.getTransport("smtp");
            t.connect(correo, contra);
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            estado = true;
        } catch (AddressException e) {
            estado = false;
            System.out.println("Correo-ERROR");
        }catch(MessagingException e){
            estado = false;
            System.out.println("Correo-ERROR");
        }
            
        return estado;
    }
    
}
