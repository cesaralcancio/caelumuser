package br.com.alura.userapi.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {
	
	@Value("${services.url.forum}")
	String forumIp;
	
	@Value("${services.url.infra}")
	String infraIp;
	
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="printSomethingFallback")
	public String consultarForum(UUID uuidUser) {
		String uri = "http://" + forumIp + ":8080/api/questions";
		System.out.println("URI: " + uri);
		
		String output = restTemplate.getForObject(uri, String.class);
		System.out.println(output);
		return output;
	}
	
	@HystrixCommand(fallbackMethod="printSomethingFallback")
	public void printSomething() {
		//throw new RuntimeException();
		System.out.println("Deu bom");
	}
	
	public String printSomethingFallback(UUID uuidUser) {
		System.out.println("Deu ruim");
		return "Deu ruim";
	}
	
	public String printSomethingFallback() {
		System.out.println("Deu ruim");
		return "Deu ruim";
	}
	
//	@FeignClient("name")
//	static interface NameService {
//		
//	}
	
	//192.168.0.163:8080/api/questions/
}
