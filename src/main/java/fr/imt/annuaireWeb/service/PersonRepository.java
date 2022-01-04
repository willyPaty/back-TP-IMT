package fr.imt.annuaireWeb.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.imt.annuaireWeb.data.Person;



public interface PersonRepository extends CrudRepository<Person, Integer>{

	//add, put et del herite de crud
	List<Person> findByName(String lastName);
	Person findById(int id);
	List<Person> findAll();

}
