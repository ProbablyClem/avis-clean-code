package fr.esgi.fx.avis.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import fr.esgi.fx.avis.entity.EditeurEntity;

@DataJpaTest(showSql = true, properties = { "spring.datasource.url=jdbc:h2:~/Documents/avis_test;AUTO_SERVER=TRUE" })
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql({ "script.sql" })
class EditeurRepositoryTest {

	@Autowired
	EditeurRepository editeurRepository;

	@BeforeEach
	void beforeEach() {
		editeurRepository.deleteAll();
	}

	@Test
	@DisplayName("Teste l'ajout d'un éditeur en base")
	void testSave() {
		String nomEditeur = "test";
		EditeurEntity editeur = new EditeurEntity();
		editeur.setNom(nomEditeur);

		EditeurEntity editeurEnregistre = editeurRepository.save(editeur);

		assertEquals(nomEditeur, editeurEnregistre.getNom());
		assertEquals(1L, editeurEnregistre.getId());
	}

}
