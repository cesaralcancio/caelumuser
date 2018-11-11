package br.com.alura.userapi.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	public String consultarForum(UUID uuidUser) {
		String uri = "http://localhost:8080/users/";
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
	
	//192.168.0.163:8080/api/questions/
}
