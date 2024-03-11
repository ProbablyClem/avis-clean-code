package fr.esgi.fx.avis.controller.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.esgi.fx.avis.entity.EditeurEntity;
import fr.esgi.fx.avis.service.EditeurService;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EditeurRestControllerTest {

	// cet objet imite ce que fait Postwoman, Postman, Insomnia, Swagger ou le front
	// Angular
	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper; // cet objet va sérialiser des objets métier

	@Autowired
	EditeurService editeurService;

	String nom = "Valve";

	@BeforeEach
	void setup() {
		// editeurService.supprimerEditeurs();
	}

	@Test
	@Order(1)
	@WithMockUser(roles = "ADMIN")
	void testPostEditeur() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/editeurs/{nom}", nom);

		mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value(nom))
				// On vérifie que le code retour est bien 201 (CREATED)
				.andExpect(status().isCreated())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	void testPostEditeurTwiceShouldReturnConflict() throws Exception {
		editeurService.ajouterEditeur(new EditeurEntity(nom));

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/editeurs/{nom}", nom);

		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isConflict())
				.andDo(MockMvcResultHandlers.print()).andReturn();

		assertEquals(result.getResolvedException().getMessage(), "Cet éditeur est déjà présent");
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	void testGetEditeur() throws Exception {
		EditeurEntity editeurSauvegarde = editeurService.ajouterEditeur(new EditeurEntity(nom));

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/editeurs/{id}",
				editeurSauvegarde.getId());

		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(editeurSauvegarde.getId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value(nom))
				.andDo(MockMvcResultHandlers.print());
	}
}
