package br.com.alura.userapi.service;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {

	public String consultarForum(UUID uuidUser) {
		String uri = "http://192.168.1.13:8080/api/questions";
		RestTemplate restTemplate = new RestTemplate();
		
		String output = restTemplate.getForObject(uri, String.class);
		System.out.println(output);
		return output;
	}
	
	@HystrixCommand(fallbackMethod="printSomethingFallback")
	public void printSomething() {
		throw new RuntimeException();
		//System.out.println("Deu bom");
	}
	
	public void printSomethingFallback() {
		System.out.println("Deu ruim");
	}
	
	@FeignClient("name")
	static interface NameService {
		
	}
	
	//192.168.0.163:8080/api/questions/
}
