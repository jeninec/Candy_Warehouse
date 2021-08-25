package com.revature.repositories;



import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.revature.models.Person;


@Repository
public interface PersonRepo extends CrudRepository<Person, Integer>{

	Person findDistinctByLastnameAndFirstname(String lastName, String firstName);
	List<Person> findByTitle(String title);
	Person findDistinctByEmail(String email);
	
}
