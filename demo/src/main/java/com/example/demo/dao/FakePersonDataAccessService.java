package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person1;
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

	private static List<Person1> DB = new ArrayList<>();
	@Override
	public int insertPerson(UUID id, Person1 person1) {
		DB.add(new Person1(id, person1.getName()));
		return 1;
	}
	@Override
	public List<Person1> selectAllPerson() {
		return DB;
	}
	@Override
	public Optional<Person1> sellectPersonById(UUID id) {
		return DB.stream()
				.filter(person-> person.getId().equals(id))
				.findFirst();
	}
	@Override
	public int deletePersonById(UUID id) {
		Optional<Person1>  persionList=sellectPersonById(id);
		if(!persionList.isPresent()) {
			return 0;
		}
		DB.remove(persionList.get());
		return 1;
	}
	@Override     
	public int updatePersonById(UUID id, Person1 person1) {
		return sellectPersonById(id)
				.map(p -> {
					int indexOfPersonToDelete = DB.indexOf(p);
					if(indexOfPersonToDelete >=0) {
						DB.set(indexOfPersonToDelete, new Person1(id, person1.getName()));
						return 1;
					}
					return 0;
				})
				.orElse(0);
	}

}
