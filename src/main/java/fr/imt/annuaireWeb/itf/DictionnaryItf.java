package fr.imt.annuaireWeb.itf;

import java.util.Collection;
import java.util.List;
import fr.imt.annuaireWeb.data.Person;


public interface DictionnaryItf {

	public Collection<Person> getAll();
	public Person getFromId(int id);
	public List<Person> getFromName(String name);
	public boolean deleteFromId(int id);
	public void addPerson(Person p);

}
