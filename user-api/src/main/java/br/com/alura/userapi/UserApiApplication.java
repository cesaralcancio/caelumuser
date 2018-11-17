package br.com.alura.userapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import br.com.alura.userapi.config.ApplicationCloudConfig;
import br.com.alura.userapi.service.UserService;

@EnableEurekaClient //Service Discovery
@EnableHystrix // Liberar o /acturator/hystrix.stream
@SpringBootApplication //Tomcat Embedded
public class UserApiApplication {

	@Autowired
	ApplicationCloudConfig applicationCloudConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}
	
	@Bean
	@LoadBalanced //Load balance Client (Escolher automaaticamente a instancia do Eureka) - Armazena em memória/cache
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		System.out.println("Pegou um Rest Template");
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
