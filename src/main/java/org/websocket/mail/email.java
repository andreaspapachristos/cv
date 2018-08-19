/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websocket.mail;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;
import static jdk.nashorn.internal.objects.NativeRegExpExecResult.length;
/**
 *
 * @author maria
 */
@ServerEndpoint("/email")
public class email {
        static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
        private String host;
        private String txt;
    @OnMessage
    public void onMessage(String message)throws AddressException, MessagingException {
                int iend= message.indexOf("~");
                if (iend !=-1){
                    host= "admin@he121s.com";
                    int length= (message.substring(0,iend)).length();
                   // System.out.println(length);
                    txt= message.substring(0, iend)+"<br>" + message.substring(length) ;
                    System.out.println(txt);
                }else{
                    host=message;
                    txt="This is a confirmation email. " + "<br><br> Regards, <br>he121s Admin";
                }
                    
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(host));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("*****));
		generateMailMessage.setSubject("thank you for sumbmiting");
		//String emailBody = "This is a confirmation email. " + "<br><br> Regards, <br>He121s Admin";
		generateMailMessage.setContent(txt, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "******", "*****");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
               // close();
    }
@OnClose
public void close(){
    System.out.println("connection closed");
}    


}



        
        
    
    

