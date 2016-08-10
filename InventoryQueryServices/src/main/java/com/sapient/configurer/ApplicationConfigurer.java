package com.sapient.configurer;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("file:${app.home}/application.properties")
@ComponentScan(basePackages={"com.sapient.*"})
@EnableWebMvc
public class ApplicationConfigurer extends WebMvcConfigurerAdapter {

	/*@Value("{session.api.url}")
	private String sessionIdUrl;

	@Bean
	public String sessionTokenBean() {
		return sessionIdUrl;
	}*/

	
	@Autowired
	private Environment env;
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    	
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    	//String activeProfile = System.getProperty("spring.profiles.active");
    	//String applicationConfigLocation = System.getProperty("application.config.location");
    	
    	//Resource res = new FileSystemResource(applicationConfigLocation + File.separator +	"application"+ env_separator +activeProfile+".properties");
    	//configurer.setLocation(res);
    	
    	return configurer;
    }
	

}