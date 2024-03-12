package fr.esgi.fx.avis.initialisation;

import java.time.Instant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.esgi.fx.avis.usecases.EditeurUseCases;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@Transactional
@Profile("dev")
public class AjoutDonneesInitiales implements CommandLineRunner {

	private EditeurUseCases editeurUseCase;

	@Override
	@Order(1)
	public void run(String... args) throws Exception {

		Instant debut = Instant.now();
		System.out.println("Ajout donéees initiales");

		ajouterEditeurs();
		Instant fin = Instant.now();

		System.out.println("Ajouts effectués en " + (fin.toEpochMilli() - debut.toEpochMilli()) + " ms");

	}

	private void ajouterEditeurs() {
		editeurUseCase.createEditeur("Activision");
		editeurUseCase.createEditeur("Amazon Games");
		editeurUseCase.createEditeur("Ankama");
		editeurUseCase.createEditeur("Bandai Namco");
		editeurUseCase.createEditeur("Bethesda");
		editeurUseCase.createEditeur("BioWare");
		editeurUseCase.createEditeur("Blizzard");
		editeurUseCase.createEditeur("Capcom");
		editeurUseCase.createEditeur("CCP");
		editeurUseCase.createEditeur("CD Projekt Red");
		editeurUseCase.createEditeur("Digital Extreme");
		editeurUseCase.createEditeur("Electronic Arts");
		editeurUseCase.createEditeur("Epic Games");
		editeurUseCase.createEditeur("FromSoftware");
		editeurUseCase.createEditeur("Hazelight Studios");
		editeurUseCase.createEditeur("idSoftware");
		editeurUseCase.createEditeur("Microsoft");
		editeurUseCase.createEditeur("MonolithSoftware");
		editeurUseCase.createEditeur("Naughty Dog");
		editeurUseCase.createEditeur("Nintendo");
		editeurUseCase.createEditeur("Riot Games");
		editeurUseCase.createEditeur("Rockstar");
		editeurUseCase.createEditeur("Sega");
		editeurUseCase.createEditeur("Square Enix");
		editeurUseCase.createEditeur("Tencent");
		editeurUseCase.createEditeur("Ubisoft");
		editeurUseCase.createEditeur("Ultra Software");
		editeurUseCase.createEditeur("Valve");
		editeurUseCase.createEditeur("Wildcard");
	}
}