package com.pescaria.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.pescaria.course.entities.Order;
import com.pescaria.course.entities.User;
import com.pescaria.course.repositories.OrderRepository;
import com.pescaria.course.services.exceptions.DatabaseException;
import com.pescaria.course.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	@Autowired
	private UserService userService;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Order insert(Order obj) {
		User client = userService.findById(obj.getClient().getId());
		obj.setClient(client);
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Order update(Long id, Order obj) {
		Order entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Order entity, Order obj) {
		entity.setStatus(obj.getStatus());
		entity.setMoment(obj.getMoment());
	}
}
