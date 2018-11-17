package br.com.alura.userapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import br.com.alura.userapi.config.ApplicationCloudConfig;
import br.com.alura.userapi.service.UserService;

@SpringBootApplication
public class UserApiApplication {

	@Autowired
	ApplicationCloudConfig applicationCloudConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}
	
//	@Bean
//	public CommandLineRunner clr(UserService service){
//		return args -> {
//			service.printSomething();
//		};
//	}
	
	@Bean
	public CommandLineRunner clr(UserService service) {
		return args -> {
			System.out.println(applicationCloudConfig.getName());
		};
	}
}
