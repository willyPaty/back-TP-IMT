package fr.imt.annuaireWeb.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import fr.imt.annuaireWeb.data.Person;
import fr.imt.annuaireWeb.itf.DictionnaryItf;


@Controller
public class DictionnaryController {

	@Autowired
	DictionnaryItf ds;

	@GetMapping("/annuaire/recherche")
	@CrossOrigin(origins = "*")
	public String recherche(Model model,
			@RequestParam(name = "name", required = false, defaultValue = "*") String name) {
		if (name.equals("*"))
			model.addAttribute("entries", ds.getAll());
		else
			model.addAttribute("entries", ds.getFromName(name));
		return "annuaire/recherche";
	}

	@GetMapping("/annuaire/ajouter")
	@CrossOrigin(origins = "*")
	public String ajouterEntree() {
		return "annuaire/ajouter";
	}

	@PostMapping("/annuaire/ajouter")
	@CrossOrigin(origins = "*")
	public String ajout(Model model, Person person) {//en enlevant le @RequetParam, Spring fait le mapping de mon objet
		ds.addPerson(person);
		model.addAttribute("entries", ds.getAll());
		return "redirect:/annuaire/recherche";//chemin abslou URL
	}
	/*
	public String add 
		( @RequestParam String name, 
		  @RequestParam String surname, 
		  @RequestParam String phone, 
		  @RequestParam String city) {
		Person p = new Person (12,name, surname, phone, city);
		ds.addPerson(p);
		return "redirect:/annuaire/recherche";
	}*/

	@GetMapping("/annuaire/supprimer/{id}")
	@CrossOrigin(origins = "*")
	public String supprime(Model model, @PathVariable  int id) {
		ds.deleteFromId(id);
		return "redirect:/annuaire/recherche";
	}
	@GetMapping("/annuaire/modifier/{id}")
	@CrossOrigin(origins = "*")
	public String modifierEntree(Model model, @PathVariable int id) {
		model.addAttribute("entry", ds.getFromId(id));
		return "annuaire/modifier";
	}
	/*@GetMapping("/annuaire/modifier/{id}")
	public String Modifier(Model model, @PathVariable(required = true) int id) {
		model.addAttribute("entry",ds.getFromId(id));
		return "annuaire/formulaire";
	}*/
	@PostMapping("/annuaire/modifier/{id}")
	@CrossOrigin(origins = "*")
	public String ModifyById(Model model, @PathVariable(required = true) int id,
		@RequestParam(name = "name", required = false) String name, 
		@RequestParam(name = "surname", required = false) String surname,
		@RequestParam(name = "phone", required = false) String phone,
		@RequestParam(name = "city", required = false) String city) {
		ds.addPerson(new Person(id,name,surname,phone,city));
		return "redirect:/annuaire/recherche";
	}
}
