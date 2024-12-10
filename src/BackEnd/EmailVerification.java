/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;


import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Random;
import javax.swing.JOptionPane;


/**
 *
 * @author lenovo
 */
public class EmailVerification {
    public static void sendEmail(String to, String subject, String content) {
        String from = "connecthub2005@gmail.com"; 
        String mypassword = "bjxogtwpiafvlkkh";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, mypassword);
            }
        });
        
         try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);
            JOptionPane.showMessageDialog(null,"Verification code was successfully sent to your email", "Verification", JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    public static String generateCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); 
        return String.valueOf(code);
    }
    
}
