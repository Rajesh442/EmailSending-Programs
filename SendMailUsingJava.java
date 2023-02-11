package SendMail;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

//for sending mail we need to add 2 jars in buildpath 
//they are javax.mail.jar and activation-1.1.1.jar 
//both jars in below mentiond link
//https://drive.google.com/file/d/1RjlsgkD6fZisMpEfgnNccrZvIuz9T3Al/view?usp=sharing
public class SendMailUsingJava {

	public static void main(String[] args) {
        // Receivers(Recipient) email ID needs to be mentioned.
        String to = "rajganesh9003@gmail.com";

        // Sender's email ID 
        String from = "rg.rajesh9003@gmail.com";

        // sending email through gmails smtp(Simple Mail Transfer Protocol)
        String host = "smtp.gmail.com";
        
        // for Getting system properties
        Properties properties = System.getProperties();

        // Setup mail server these are compulsory
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication(from, "faqynxnuahovjkvp");//("mail id" ,"password")

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // connecting sender mailId with internet
            message.setFrom(new InternetAddress(from));

            // connecting receivers mailId with internet
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject content
            message.setSubject("This is the Subject Line!");

            // actual message
            message.setText("This is actual message");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } 
        catch (MessagingException mex) 
        {
            mex.printStackTrace();
        }
	
	}
}
