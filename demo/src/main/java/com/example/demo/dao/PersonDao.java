package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import com.example.demo.model.Person1;

public interface PersonDao {

	int insertPerson(UUID id, Person1 person1);
	default int insertPerson(Person1 person1) {
		UUID id=UUID.randomUUID();
		return insertPerson(id, person1);
	}
	public List<Person1> selectAllPerson();
	
	Optional<Person1> sellectPersonById(UUID id);
	
	 int deletePersonById(UUID id);
	 
	 int updatePersonById(UUID id, Person1 person1);
}
