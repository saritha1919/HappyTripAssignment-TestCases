package testlisteners;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	
	public static void send(String from, String tos[], String subject,
		      String text) throws MessagingException {
		    // Get the session object
		    Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp-mail.outlook.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.starttls.enable","true");
	        props.put("mail.smtp.auth", "true");
		    Session session = Session.getDefaultInstance(props,
		        new javax.mail.Authenticator() {
		          protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(
		            "saritha.modiam@pratian.com",
		            "Sarichitti@1919");// change accordingly
		          }
		        });
		    // compose message
		    try {
		      MimeMessage message = new MimeMessage(session);
		      message.setFrom(new InternetAddress(from));// change accordingly
		      for (String to : tos) {
		        message.addRecipient(Message.RecipientType.TO,
		            new InternetAddress(to));
		      }
		      /*
		       * for (String cc : ccs)
		       * message.addRecipient(Message.RecipientType.CC,new
		       * InternetAddress(cc));
		       */
		      message.setSubject(subject);
		      // Option 1: To send normal text message
		      // message.setText(text);
		      // Option 2: Send the actual HTML message, as big as you like
		      // message.setContent("<h1>This is actual message</h1></br></hr>" +
		      // text, "text/html");
		      // Set the attachment path
		      //String filename = "C:/Users/saritha.reddy/eclipse-workspace/testng/src/test/resources/Screenshots/output.pdf";
		      String filename = ExtentManager.getReportLocation();
		      System.out.println("report location"+ExtentManager.getReportLocation());
		      BodyPart objMessageBodyPart = new MimeBodyPart();
		      // Option 3: Send text along with attachment
		      //objMessageBodyPart.setContent(
		        //  "<h1>Mail from Selenium Project!</h1></br> Total Test case count: "+(ListenerTest.getPasscount()+ListenerTest.getFailcount())+"</br>" +"Passed Test case count: "+ListenerTest.getPasscount()+"</br>"+"Failed Test case count: "+ListenerTest.getFailcount()+"</br>" +"Skipped Test Cases count: "+ListenerTest.getPasscount()+"</br></br>"+text, "text/html");
		      objMessageBodyPart.setContent(
			          "<h1>Mail from Selenium Project!</h1></br> Total Test case count: "+(TestListener.getPasscount()+TestListener.getFailcount())+"</br>" +"Passed Test case count: "+TestListener.getPasscount()+"</br>"+"Failed Test case count: "+TestListener.getFailcount()+"</br>" +"Skipped Test Cases count: "+TestListener.getSkipcount()+"</br></br>"+text, "text/html");
			      
		      
		      Multipart multipart = new MimeMultipart();
		      multipart.addBodyPart(objMessageBodyPart);
		      objMessageBodyPart = new MimeBodyPart();
		      DataSource source = new FileDataSource(filename);
		      objMessageBodyPart.setDataHandler(new DataHandler(source));
		      objMessageBodyPart.setFileName("Screenshots.html");
		      multipart.addBodyPart(objMessageBodyPart);
		      message.setContent(multipart);
		      // send message
		      Transport.send(message);
		      System.out.println("message sent successfully");
		    } catch (MessagingException e) {
		      throw new RuntimeException(e);
		    }
		  }// End of SEND method


}
