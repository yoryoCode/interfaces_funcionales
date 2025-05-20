package sample3;

import java.util.HashMap;

import sample3.service.SendMailService;
import sample3.service.impl.SendMailServiceFunctionInterfaceImpl;

public class LaunchApp {
	
	public static void main(String[] args) {
		
		SendMailService mailService = new SendMailServiceFunctionInterfaceImpl();
		
		var contextDataWinner = new HashMap<String, String>();
		contextDataWinner.put("userName", "Jorge G");
		contextDataWinner.put("prize", "PlayStation 5");
		mailService.sendMail("roger@bba.com", "WINNER_MAIL", contextDataWinner);
		
		var contextDataFAQ = new HashMap<String, String>();
		contextDataFAQ.put("userName", "Jorge G");
		contextDataFAQ.put("message", "Nos pondremos en contacto contigo via chat para revisar el tema");
		mailService.sendMail("roger@bba.com", "FAQ_MAIL", contextDataFAQ);
		
	}
	
}
