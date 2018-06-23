package pl.edu.prz.kia.universityproject.service;

import org.springframework.stereotype.Service;

import pl.edu.prz.kia.universityproject.model.User;

import java.util.Objects;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@Service("emailService")
public class EmailService
{

    public void SendActivationEmail(User user) {
        // Recipient's email ID needs to be mentioned.

        String to = user.getEmail();
        String from = "bd.io.activation@gmail.com";

        // Sender's email ID needs to be mentioned
        final String username = from;//change accordingly
        final String password = "w0rdpassinG?";//change accordingly


        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            
            Long temp = user.getId();
            String ajdi = Objects.toString(temp);

            // Set Subject: header field
            message.setSubject("Aktywacja Twojego konta, " + user.getName());

            // Now set the actual message
            message.setText("Aby aktywować konto kliknij w poniższy link \n" +
                    "https://spring-mvc-university-project.herokuapp.com/activation/"+ajdi);

            // Send message
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}