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
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
