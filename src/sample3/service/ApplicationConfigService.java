package sample3.service;

import sample3.dto.ApplicationConfigDTO;

public interface ApplicationConfigService {
	public ApplicationConfigDTO getApplicationConfig(String key);
}
