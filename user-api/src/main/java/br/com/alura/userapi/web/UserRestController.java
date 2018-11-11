package br.com.alura.userapi.web;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.userapi.domain.User;
import br.com.alura.userapi.repository.UserRepository;
import br.com.alura.userapi.service.UserService;

@RestController("/api")
public class UserRestController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService UserService;
	
	@GetMapping("/users/{id}")
	public @ResponseBody ResponseEntity<User> getUser(@PathVariable("id") UUID uuid){
		Optional<User> user = userRepository.findById(uuid);
		if (user.isPresent()) {
			User userDomain = user.get();
			return new ResponseEntity<User>(userDomain, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/users/")
	public @ResponseBody ResponseEntity<Iterable<User>> getUsers() {
		Iterable<User> iUsers = userRepository.findAll();
		return new ResponseEntity<Iterable<User>>(iUsers, HttpStatus.OK);
	}
	
	@GetMapping("/teste/")
	public @ResponseBody ResponseEntity<String> teste() {
		String s = UserService.consultarForum(null);
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	@PostMapping("/users/")
	public @ResponseBody ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
	}
}
