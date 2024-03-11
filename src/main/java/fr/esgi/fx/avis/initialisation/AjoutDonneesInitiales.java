package fr.esgi.fx.avis.initialisation;

import java.time.Instant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.esgi.fx.avis.entity.EditeurEntity;
import fr.esgi.fx.avis.repository.EditeurRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@Transactional
@Profile("dev")
public class AjoutDonneesInitiales implements CommandLineRunner {

	private EditeurRepository editeurRepository;

	@Override
	public void run(String... args) throws Exception {

		Instant debut = Instant.now();
		System.out.println("Ajout donéees initiales");

		ajouterEditeurs();
		Instant fin = Instant.now();

		System.out.println("Ajouts effectués en " + (fin.toEpochMilli() - debut.toEpochMilli()) + " ms");

	}

	private void ajouterEditeurs() {
		if (editeurRepository.count() == 0) {
			editeurRepository.save(new EditeurEntity("Activision"));
			editeurRepository.save(new EditeurEntity("Amazon Games"));
			editeurRepository.save(new EditeurEntity("Ankama"));
			editeurRepository.save(new EditeurEntity("Bandai Namco"));
			editeurRepository.save(new EditeurEntity("Bethesda"));
			editeurRepository.save(new EditeurEntity("BioWare"));
			editeurRepository.save(new EditeurEntity("Blizzard"));
			editeurRepository.save(new EditeurEntity("Capcom"));
			editeurRepository.save(new EditeurEntity("CCP"));
			editeurRepository.save(new EditeurEntity("CD Projekt Red"));
			editeurRepository.save(new EditeurEntity("Digital Extreme"));
			editeurRepository.save(new EditeurEntity("Electronic Arts"));
			editeurRepository.save(new EditeurEntity("Epic Games"));
			editeurRepository.save(new EditeurEntity("FromSoftware"));
			editeurRepository.save(new EditeurEntity("Hazelight Studios"));
			editeurRepository.save(new EditeurEntity("idSoftware"));
			editeurRepository.save(new EditeurEntity("Microsoft"));
			editeurRepository.save(new EditeurEntity("MonolithSoftware"));
			editeurRepository.save(new EditeurEntity("Naughty Dog"));
			editeurRepository.save(new EditeurEntity("Nintendo"));
			editeurRepository.save(new EditeurEntity("Riot Games"));
			editeurRepository.save(new EditeurEntity("Rockstar"));
			editeurRepository.save(new EditeurEntity("Sega"));
			editeurRepository.save(new EditeurEntity("Square Enix"));
			editeurRepository.save(new EditeurEntity("Tencent"));
			editeurRepository.save(new EditeurEntity("Ubisoft"));
			editeurRepository.save(new EditeurEntity("Ultra Software"));
			editeurRepository.save(new EditeurEntity("Valve"));
			editeurRepository.save(new EditeurEntity("Wildcard"));
		}
	}
}