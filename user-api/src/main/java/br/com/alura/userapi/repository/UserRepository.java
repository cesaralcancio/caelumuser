package br.com.alura.userapi.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.userapi.domain.User;

public interface UserRepository extends CrudRepository<User, UUID> {

	
	
}
