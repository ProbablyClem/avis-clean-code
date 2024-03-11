package fr.esgi.fx.avis.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import fr.esgi.fx.avis.service.EditeurService;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EditeurControllerTest {

	// cet objet imite ce que fait Postwoman, Postman, Insomnia, Swagger ou le front
	// Angular
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	EditeurService editeurService;

	@Test
	@WithMockUser(roles = "ADMIN")
	void testerPostEditeurs() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = post("/editeurs")
				.accept(MediaType.TEXT_HTML)
				.param("NOM", "toto");
		mockMvc.perform(requestBuilder)
				.andExpect(view().name("editeurs"))
				.andExpect(status().isOk())
				.andExpect(result -> result.getModelAndView().getModel().get("nom").equals("toto"))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	void testerAjoutEditeurWithInvalidNamePost() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/editeur").accept(MediaType.TEXT_HTML)
				.param("nom", "a"))
				.andExpect(view().name("editeur"))
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
}
