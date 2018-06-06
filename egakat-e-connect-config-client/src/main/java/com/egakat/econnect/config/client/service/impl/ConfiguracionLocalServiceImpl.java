package com.egakat.econnect.config.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.config.client.components.ConfigRestProperties;
import com.egakat.econnect.config.client.service.api.ConfiguracionLocalService;
import com.egakat.econnect.config.constants.RestConstants;
import com.egakat.econnect.config.dto.ConfiguracionDto;

@Service
public class ConfiguracionLocalServiceImpl extends LocalQueryServiceImpl<ConfiguracionDto, Long>
		implements ConfiguracionLocalService {

	@Autowired
	private ConfigRestProperties properties;

	protected ConfigRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.configuracion;
	}

	@Override
	protected Class<ConfiguracionDto> getResponseType() {
		return ConfiguracionDto.class;
	}

	@Override
	protected Class<ConfiguracionDto[]> getArrayReponseType() {
		return ConfiguracionDto[].class;
	}
}
