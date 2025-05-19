package sample3.service.impl;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import sample3.dto.ApplicationConfigDTO;
import sample3.dto.MailDTO;
import sample3.service.ApplicationConfigService;
import sample3.service.SendMailService;
import sample3.utils.ApplicationConstants;
import sample3.utils.BuildEmailBody;
import sample3.utils.SendMail;

public class SendMailServiceMyInterfaceImpl implements SendMailService{
	
	private ApplicationConfigService applicationConfigService = new ApplicationConfigServiceImpl();

	@Override
	public void sendMail(String to, String templateName, Map<String, String> contextData) {
		
		ApplicationConfigDTO sender = applicationConfigService.getApplicationConfig("MAIL_FROM");
				
		MailDTO mailDTO = switch(templateName) {
			case "WINNER_MAIL" -> buildMailWinner(sender.value(), to, contextData);
			case "FAQ_MAIL" -> buildMailfAQ( sender.value(), to, contextData);
			default -> null;
		};
		
		System.out.println("\n cuerpo del correo: \n " + mailDTO.body() + "\n");		
		
		SendMail.sendEmail(mailDTO);	
				
	}
	
	private MailDTO buildMailWinner(String from, String to, Map<String, String> contextData) {
		BuildEmailBody mailBody = map -> composeWinnerMailFormatter(map.get("userName"), map.get("prize"));
		String subject = ApplicationConstants.SUBJECT_WINNER_MAIL;
		String body = mailBody.buildEmailBody(contextData);
		return new MailDTO(from, to, subject, body);
	}
	
	private MailDTO buildMailfAQ(String from, String to, Map<String, String> contextData) {
		BuildEmailBody mailBody = map -> composeFAQMailFormatter(map.get("userName"), map.get("message"));
		String subject = ApplicationConstants.SUBJECT_FAQ_MAIL;
		String body =  mailBody.buildEmailBody(contextData);
		return new MailDTO(from, to, subject, body);
	}
	
	private String composeWinnerMailFormatter(String name, String prize) {
		return MessageFormat.format("Gracias {0}, te has ganado {1}",
				name, prize);
	}	
	
	private String composeFAQMailFormatter(String name, String message) {
		return MessageFormat.format("Qué tal {0}, en base a tus inquietudes recibidas tenemos los siguientes comentarios al respecto : \n {1}",
				name, message);
	}	
	

}
