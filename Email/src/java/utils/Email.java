/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author asus
 */
public class Email {
    private static final String fromEmail = "magicmath2k5@gmail.com";
     private static final String mk = "hbidlqbywjietaic";
    
    public static boolean sendRegister(String toEmail, String fullName, String userID){
        
        try {
            Properties pros = new Properties();
            pros.put("mail.smtp.host","smtp.gmail.com" );
            pros.put("mail.smtp.port", "587");
            pros.put("mail.smtp.auth", "true");
            pros.put("mail.smtp.starttls.enable","true");
            
            Session session = Session.getInstance(pros, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, mk);
                }
            });
            
            Message mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail)  );
            
            mess.setSubject("Welcome to Our Website - Registration Successful");
            
            
            String htmlContent = createHtmlRegister(fullName, userID);
            
            mess.setContent(htmlContent,"text/html; charset=utf-8");
            
            Transport.send(mess);
            return true;

        } catch (AddressException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
        return false;
    
    
    }
    public static String createHtmlRegister(String fullName, String userID){
        
        
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Registration Successful</title>\n"
                + "    <style>\n"
                + "        body {\n"
                + "            font-family: Arial, sans-serif;\n"
                + "            line-height: 1.6;\n"
                + "            color: #333;\n"
                + "            margin: 0;\n"
                + "            padding: 0;\n"
                + "        }\n"
                + "        .container {\n"
                + "            max-width: 600px;\n"
                + "            margin: 0 auto;\n"
                + "            padding: 20px;\n"
                + "            background-color: #f9f9f9;\n"
                + "        }\n"
                + "        .header {\n"
                + "            background-color: #4a90e2;\n"
                + "            color: white;\n"
                + "            padding: 20px;\n"
                + "            text-align: center;\n"
                + "        }\n"
                + "        .content {\n"
                + "            padding: 20px;\n"
                + "            background-color: white;\n"
                + "            border-radius: 5px;\n"
                + "        }\n"
                + "        .button {\n"
                + "            display: inline-block;\n"
                + "            padding: 10px 20px;\n"
                + "            background-color: #4a90e2;\n"
                + "            color: white;\n"
                + "            text-decoration: none;\n"
                + "            border-radius: 5px;\n"
                + "            margin: 20px 0;\n"
                + "        }\n"
                + "        .footer {\n"
                + "            text-align: center;\n"
                + "            margin-top: 20px;\n"
                + "            font-size: 12px;\n"
                + "            color: #666;\n"
                + "        }\n"
                + "    </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <div class=\"container\">\n"
                + "        <div class=\"header\">\n"
                + "            <h1>Welcome to Our Website!</h1>\n"
                + "        </div>\n"
                + "        <div class=\"content\">\n"
                + "            <h2>Hello, " + fullName + "!</h2>\n"
                + "            <p>Thank you for registering with our website. Your account has been successfully created.</p>\n"
                + "            <p><strong>Your login information:</strong></p>\n"
                + "            <p>Username: <strong>" + userID + "</strong></p>\n"
                + "            <p>You can now login to your account and start exploring our services.</p>\n"
                + "            <a href=\"http://yourwebsite.com/login\" class=\"button\">Login to Your Account</a>\n"
                + "            <p>If you have any questions or need assistance, please don't hesitate to contact our support team.</p>\n"
                + "            <p>Best regards,<br>The Team</p>\n"
                + "        </div>\n"
                + "        <div class=\"footer\">\n"
                + "            <p>This is an automated message, please do not reply to this email.</p>\n"
                + "            <p>&copy; 2025 Your Company. All rights reserved.</p>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</body>\n"
                + "</html>";
        
    }
    
    
    
    
    
    
}
