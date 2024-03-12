package fr.esgi.fx.avis.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;

import fr.esgi.fx.avis.gateway.EditeurDbGateway;
import fr.esgi.fx.avis.model.Editeur;

@SpringBootTest
public class EditeurUseCasesTest {

    @Autowired
    EditeurUseCases editeurUseCases;

    @MockBean
    EditeurDbGateway editeurDbGateway;

    String nom = "test";

    @Test
    void testAjouterEditeur() {
        Editeur editeur = new Editeur(nom, LocalDate.now());
        editeur.setId(1L);

        when(editeurDbGateway.saveEditeur(any(Editeur.class))).thenReturn(editeur);

        Editeur editeurEnregistre = editeurUseCases.createEditeur(nom);
        assertEquals(editeur.getNom(), editeurEnregistre.getNom());
        assertEquals(editeur.getId(), editeurEnregistre.getId());
    }
}
