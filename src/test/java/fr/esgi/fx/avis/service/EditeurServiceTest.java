// package fr.esgi.fx.avis.service;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;

// import fr.esgi.fx.avis.entity.EditeurEntity;
// import fr.esgi.fx.avis.repository.EditeurRepository;
// import fr.esgi.fx.avis.service.EditeurService;

// @SpringBootTest
// class EditeurServiceTest {

// @Autowired
// EditeurService editeurService;

// @MockBean
// EditeurRepository editeurRepository;

// String nom = "test";

// @Test
// void testAjouterEditeur() {
// EditeurEntity editeur = new EditeurEntity(nom);
// editeur.setId(1L);

// when(editeurRepository.save(any(EditeurEntity.class))).thenReturn(editeur);

// EditeurEntity editeurEnregistre = editeurService.ajouterEditeur(new
// EditeurEntity(nom));
// assertEquals(editeur, editeurEnregistre);
// assertEquals(editeur.getNom(), editeurEnregistre.getNom());
// assertEquals(editeur.getId(), editeurEnregistre.getId());
// }
// }
