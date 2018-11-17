package br.com.alura.userapi.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

	
@Configuration
@EnableAutoConfiguration
public class ApplicationCloudConfig {

//	  @Value("${config.name}")
	  String name = "World";

	  public String getName() {
		return name;
	}

}
