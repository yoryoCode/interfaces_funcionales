package sample3.utils;

import java.util.Map;

@FunctionalInterface
public interface BuildEmailBody {
	
	String buildEmailBody(Map<String, String> contextData);
	
}
