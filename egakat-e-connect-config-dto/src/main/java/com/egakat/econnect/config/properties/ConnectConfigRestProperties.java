package com.egakat.econnect.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import com.egakat.core.web.client.properties.RestProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ConfigurationProperties(prefix = ConnectConfigRestProperties.CONFIGURATION_PROPERTIES)
@Getter
@Setter
@ToString
@Validated
public class ConnectConfigRestProperties implements RestProperties {

	static final String CONFIGURATION_PROPERTIES = "endpoint.econnect.config.rest";
	
	private String basePath;
	
}