package fr.esgi.fx.avis.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import fr.esgi.fx.avis.business.Editeur;
import fr.esgi.fx.avis.business.Genre;
import fr.esgi.fx.avis.business.Jeu;
import fr.esgi.fx.avis.repository.EditeurRepository;
import fr.esgi.fx.avis.repository.GenreRepository;
import fr.esgi.fx.avis.repository.JeuRepository;

@DataJpaTest(showSql = true, properties = {"spring.datasource.url=jdbc:h2:~/Documents/avis_test;AUTO_SERVER=TRUE"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql({"script.sql"})
class EditeurRepositoryTest {

	@Autowired
	EditeurRepository editeurRepository;
	
	@Autowired
	JeuRepository jeuRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	@BeforeEach
	void beforeEach() {
		editeurRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Teste l'ajout d'un éditeur en base")
	void testSave() {
		String nomEditeur = "test";
		Editeur editeur = new Editeur();
		editeur.setNom(nomEditeur);
		
		Editeur editeurEnregistre = editeurRepository.save(editeur);
		
		assertEquals(nomEditeur, editeurEnregistre.getNom());
		assertEquals(1L, editeurEnregistre.getId());
	}
	
    @Test
    void findByNomLike() {
    	String base = "abc";
		editeurRepository.saveAll(List.of(new Editeur(base), new Editeur(base + "2")));
		
    	List<Editeur> editeursRecuperes = editeurRepository.findByNomLike("%" + base + "%");
    	assertEquals(2, editeursRecuperes.size());
    }

    @Test
    void findFirstByNomLike() {
    	String base = "abc";
		editeurRepository.saveAll(List.of(new Editeur(base), new Editeur(base + "2")));
		
    	Editeur editeurRecupere = editeurRepository.findFirstByNomLike("%" + base + "%");
    	assertEquals(base, editeurRecupere.getNom());
    }

    @Test
    void findByNom() {
    	String base = "abc";
		editeurRepository.saveAll(List.of(new Editeur(base), new Editeur(base + "2")));
		
    	Editeur editeurRecupere = editeurRepository.findByNom(base);
    	assertEquals(base, editeurRecupere.getNom());
    }

    @Test
    void findDistinctByJeuGenreNomStartingWith() {
    	   Editeur editeur = new Editeur();
           editeur.setNom("test");
           editeurRepository.save(editeur);
           Jeu jeu1 = new Jeu();
           Genre genre = new Genre("genre");
           genreRepository.save(genre);
           jeu1.setEditeur(editeur);
           jeu1.setGenre(genre);
           jeu1.setNom("toto");
           jeuRepository.save(jeu1);

           Editeur editeur2 = new Editeur();
           editeur2.setNom("test2");
           editeurRepository.save(editeur2);
           Jeu jeu2 = new Jeu();
           jeu2.setEditeur(editeur2);
           jeu2.setGenre(genre);
           jeu2.setNom("tata");
           jeuRepository.save(jeu2);

           List<Editeur> editeurList = editeurRepository.findDistinctByJeuGenreNomStartingWith("gen");

           assertEquals(2, editeurList.size());
     
    }

//    @Test
//    void findByNomStartingWithB() {
//    }

    // TODO
   // @Test
    void findEditorsWithoutGames() {
    	String nomEditeur1 = "abc";
    	String nomEditeur2 = "def";
		editeurRepository.saveAll(List.of(new Editeur(nomEditeur1), new Editeur(nomEditeur2)));
    	Jeu jeu = new Jeu("jeu");
    	jeu.setEditeur(editeurRepository.findAll().get(0));
    	jeuRepository.save(jeu);
    	
    	List<Editeur> editeursRecuperes = editeurRepository.findEditorsWithoutGames();
    	assertEquals(1, editeursRecuperes.size());
    	assertEquals(nomEditeur2, editeursRecuperes.get(0).getNom());
    	assertTrue(editeursRecuperes.get(0).getJeux().isEmpty());
    }

    //@Test
    void findEditorsWithGames() {
    	String nomEditeur1 = "abc";
    	String nomEditeur2 = "def";
		editeurRepository.saveAll(List.of(new Editeur(nomEditeur1), new Editeur(nomEditeur2)));
    	Jeu jeu = new Jeu("jeu");
    	jeu.setEditeur(editeurRepository.findAll().get(0));
    	jeuRepository.save(jeu);
    	
    	List<Editeur> editeursRecuperes = editeurRepository.findEditorsWithGames();
    	assertEquals(1, editeursRecuperes.size());
    	assertEquals(nomEditeur1, editeursRecuperes.get(0).getNom());
    	assertFalse(editeursRecuperes.get(0).getJeux().isEmpty());
    }

//    @Test
//    void findFirstByNom() {
//    }
//
//    @Test
//    void findFirst2ByNomStartingWith() {
//    }
//
//    @Test
//    void findFirst2ByNomStartingWithOrderByNom() {
//    }
//
//    @Test
//    void findByNomStartsWithIgnoreCase() {
//    }
//
//    @Test
//    void countByNomEndsWithIgnoreCase() {
//    }
}
