package sample3.utils;

import sample3.dto.MailDTO;

public class SendMail {
     
  public static void sendEmail(MailDTO mailDTO){    
	  
	//TODO logica para enviar correo
	System.out.println("se envío correo electronico a " + mailDTO.to());
    	
	
  }
  
}
