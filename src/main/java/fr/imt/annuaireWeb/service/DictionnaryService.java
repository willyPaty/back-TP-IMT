package fr.imt.annuaireWeb.service;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.imt.annuaireWeb.data.Person;
import fr.imt.annuaireWeb.itf.DictionnaryItf;





@Service
public class DictionnaryService implements DictionnaryItf {

	@Autowired 
	PersonRepository pr;@Override
	public Collection<Person> getAll() {
		return pr.findAll();
	}

	@Override
	public Person getFromId(int id) {
		return pr.findById(id);
	}

	@Override
	public List<Person> getFromName(String name) {
		return pr.findByName(name);
	}

	@Override
	public boolean deleteFromId(int id) {
		if(pr.existsById(id)) {
			pr.deleteById(id);
			return true;
		}else {
			return false;
		}	
	}

	@Override
	public void addPerson(Person p) {
		pr.save(p);

	}

}


/*
	Map<Integer,Person> hm; // déclaration de la Map en hm

	public DictionnaryService() {
		super();
		hm = new HashMap<Integer,Person>(); // initialisation de HashMap avec les valeur (k,v)
		hm.put(1, new Person(1,"Who", "Doctor", "0606060606", "Lille"));
		hm.put(2, new Person(2,"Bond", "James", "0606060606", "Londres"));
		hm.put(3, new Person(3,"Macron", "Emmanuel", "0606060606", "Paris"));
		hm.put(4, new Person(4,"Macron", "Tom", "0606060606", "Guadeloupe"));
	}

	@Override
	public Collection<Person> getAll() {			// appel de la classe Collection pour utilisation de .values
		return (Collection<Person>) (hm.values()); // permet de pacourir la liste 
	}

	@Override
	public Person getFromId(int id) {
		return hm.get(id);
	}

	@Override
	public boolean deleteFromId(int id) {
		if(hm.remove(id) != null) return true;
		return false;
	}

	@Override
	public void addPerson(Person p) {
		hm.put(p.getId(), p);
	}

	@Override
	public List<Person> getFromName(String name) {
		return hm.values().stream().filter( e -> e.getName().equals(name)).collect(Collectors.toList());
	}

}*/

