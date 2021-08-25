package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Person;
import com.revature.repositories.PersonRepo;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepo pr;
	
	@Override
	public Person addPerson(Person p) {
		return pr.save(p);
	}

	@Override
	public Person getPerson(int id) {
		try {
			return pr.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Person> getAllPersons() {
		return (List<Person>) pr.findAll();
	}

	@Override
	public Person updatePerson(Person change) {
		return pr.save(change);
	}

	@Override
	public boolean deletePerson(int id) {
		try { 
			pr.deleteById(id);
			return true;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return false;	
		}
	}

	@Override
	public Person getPersonByName(String lastName, String firstName) {
		try {
			return pr.findDistinctByLastnameAndFirstname(lastName, firstName);
		} catch (Exception e) {
			return new Person();
		}
	}

	@Override
	public Person getPersonByEmail(String email) {
		try {
			return pr.findDistinctByEmail(email);
		} catch (Exception e) {
			return new Person();
		}
	}

	@Override
	public List<Person> getPersonsByTitle(String title) {
			return (List<Person>) pr.findByTitle(title);
	}

}
