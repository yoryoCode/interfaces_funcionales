package sample3.dao;

import java.util.HashMap;
import java.util.Map;

import sample3.entity.ApplicationConfigEntity;

public class ApplicationConfigDao {

  private static Map<String, String> contextVariables = new HashMap<String, String>();
	
	static {
		contextVariables.put("MAIL_FROM", "myapplication-manager@bba.com");
	}

  public ApplicationConfigEntity getConfigVariable(String key) {
		ApplicationConfigEntity entity = new ApplicationConfigEntity();
		String value = contextVariables.get(key);
		entity.setKey(key);
		entity.setValue(value);		
		return entity;
	}

}
