package fr.imt.annuaireWeb.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.imt.annuaireWeb.data.Person;
import fr.imt.annuaireWeb.itf.DictionnaryItf;


@RestController
public class RestDictionnaryController {
	@Autowired
	DictionnaryItf di;

	@GetMapping("/annuaire/api/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> getOne(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(di.getFromId(id));
	}
	
	@GetMapping("/annuaire/api")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(di.getAll());
	}

	@DeleteMapping("/annuaire/api/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> removeOne(@PathVariable int id) {
		if (di.getFromId(id) == null) {
			return new ResponseEntity<>("Pas de personne à supprimer avec cet ID", HttpStatus.NOT_FOUND);
		}
		di.deleteFromId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PostMapping("/annuaire/api")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> apiAdd(@RequestBody Person p) {
		if(di.getFromId(p.getId()) != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Personne déjà existante");	
		}
		di.addPerson(p);
		return ResponseEntity.status(HttpStatus.CREATED).body("Personne ajoutée");
	}
	
	@PutMapping("/annuaire/api")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> ApiModif(@RequestBody Person p) {
		if(di.getFromId(p.getId()) != null) {
			di.addPerson(p);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();	
		}
		return new ResponseEntity<>("Pas de personne à modifier avec cet ID", HttpStatus.NOT_FOUND);
	}
}
