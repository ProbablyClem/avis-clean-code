package fr.esgi.fx.avis.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.esgi.fx.avis.business.Editeur;
import fr.esgi.fx.avis.service.EditeurService;

@SpringBootTest
class EditeurServiceIT {

	@Autowired
	EditeurService editeurService;
	
	String nomEditeur = "test";
	
	@BeforeEach
	void setup() {
		editeurService.supprimerEditeurs();
	}
	
	@Test
	void testAjouterEditeur() {
		Editeur editeurEnregistre = editeurService.ajouterEditeur(new Editeur(nomEditeur));
		assertEquals(nomEditeur, editeurEnregistre.getNom());
	}
	
	@Test
	void testRecupererEditeurs() {
		Editeur editeur = editeurService.ajouterEditeur(new Editeur(nomEditeur));
		List<Editeur> editeursRecuperes = editeurService.recupererEditeurs();
		assertFalse(editeursRecuperes.isEmpty());
		assertEquals(editeur.getNom(), editeursRecuperes.get(0).getNom());
	}
	
	@Test
	void testRecupererEditeur() {
		Editeur editeur = editeurService.ajouterEditeur(new Editeur(nomEditeur));
		Editeur editeurRecupere = editeurService.recupererEditeur(1L);
		assertEquals(editeur.getNom(), editeurRecupere.getNom());
	}
	
	@Test
	void testSupprimerEditeur() {
		editeurService.supprimerEditeur(1L);
	}
}