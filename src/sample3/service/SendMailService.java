package sample3.service;

import java.util.Map;

public interface SendMailService {
	
	void sendMail(String to, String templateName, Map<String,String> contextData);

}
