package com.example.demo.repository;


import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;



@Repository

public class UserRepository {
	
	private ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();
	
	AtomicInteger idGenerator = new AtomicInteger();
	
	public boolean save(User user) {
		boolean success = false;
		Integer id = idGenerator.incrementAndGet();
		
		return repository.put(id, user) == null;
		
	}
}
