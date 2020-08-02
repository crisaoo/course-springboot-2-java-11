package com.pescaria.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pescaria.course.entities.User;
import com.pescaria.course.repositories.UserRepository;

@Service	// Registrando como um componente de serviço(o userRepository não precisa, pois ele já herda de uma classe que tem essa annotation)
			// Isso é necessário quando utilizamos um autowired para injetar dependência dessa classe em outro lugar
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById (Long id) {
		return repository.findById(id).get();
	}
}
