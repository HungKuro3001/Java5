package com.poly.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ResourceConfig {
@Bean("messageSource")
public MessageSource getmessage() {
	ReloadableResourceBundleMessageSource ms = 
			new ReloadableResourceBundleMessageSource();
	ms.setBasename("classpath:message/tau");
	ms.setDefaultEncoding("utf-8");
	return ms;
}
}
