package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person1;
@Service
public class PersonService {

	private final PersonDao personDao;
	@Autowired
	public PersonService(@Qualifier("fakeDao")PersonDao personDao) {
		this.personDao=personDao;
	}
	public int addPerson(Person1 person1) {
		return personDao.insertPerson(person1);
	}
	
	public List<Person1> getAllPerson(){
		return personDao.selectAllPerson();
	}
	public Optional<Person1> getPersonById(UUID id){
		return personDao.sellectPersonById(id);
	}
	
	public int deletePerson(UUID id) {
		return personDao.deletePersonById(id);
	}
	
	public int updatePerson(UUID id,Person1 person1) {
		
		return personDao.updatePersonById(id, person1);
	}
}
