package fr.esgi.fx.avis.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.esgi.fx.avis.business.Editeur;
import fr.esgi.fx.avis.exception.EditeurDejaPresentException;
import fr.esgi.fx.avis.service.EditeurService;
import fr.esgi.fx.avis.util.ReponseApi;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/editeurs")
@AllArgsConstructor
@Validated
public class EditeurRestController {

	private final EditeurService editeurService;

	@PostMapping("/{nom}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Editeur postEditeur(@PathVariable String nom) {
		return editeurService.ajouterEditeur(new Editeur(nom));
	}
	
	// https://sonarsource.atlassian.net/browse/RSPEC-4684
	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Editeur postEditeur(@RequestBody Editeur editeur) {
		return editeurService.ajouterEditeur(editeur);
	}
	
	// Si qq1 se rend sur l'URL http://localhost:8080/editeurs
	// la méthode ci-dessous sera invoquée
	@GetMapping("")
	public List<Editeur> getEditeurs() {
		return editeurService.recupererEditeurs();
	}
	
	@GetMapping("/{id}")
	public Editeur getEditeur(@PathVariable Long id) {
		return editeurService.recupererEditeur(id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteEditeur(@PathVariable Long id) {
		return editeurService.supprimerEditeur(id);
	}
	
	@ExceptionHandler(EditeurDejaPresentException.class)
	@ResponseStatus(code=HttpStatus.CONFLICT)
	private ReponseApi<String> traiterEditeurDejaPresentException(Exception e) {
		return new ReponseApi<String>("", e.getMessage(), null);
	}
}
