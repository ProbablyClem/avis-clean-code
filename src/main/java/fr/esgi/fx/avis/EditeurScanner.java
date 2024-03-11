package fr.esgi.fx.avis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.esgi.fx.avis.usecases.EditeurUseCases;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@Transactional
@DependsOn("ajoutDonneesInitiales")
@Profile("dev")
public class EditeurScanner implements CommandLineRunner {

    EditeurUseCases editeurUseCases;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Saississez le nom de l'éditeur a créer : ");
        String nomEditeur = System.console().readLine();
        editeurUseCases.createEditeur(nomEditeur);
    }
}
