package sample3.service.impl;

import sample3.dao.ApplicationConfigDao;
import sample3.dto.ApplicationConfigDTO;
import sample3.entity.ApplicationConfigEntity;
import sample3.service.ApplicationConfigService;

public class ApplicationConfigServiceImpl implements ApplicationConfigService{
	
	private ApplicationConfigDao dao = new ApplicationConfigDao();
	
	@Override
	public ApplicationConfigDTO getApplicationConfig(String key) {
		ApplicationConfigEntity entity = dao.getConfigVariable(key);
		ApplicationConfigDTO dto = new ApplicationConfigDTO(entity.getKey(), entity.getValue());
		return dto;
	}

}
