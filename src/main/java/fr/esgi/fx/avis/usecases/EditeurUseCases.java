package fr.esgi.fx.avis.usecases;

import org.springframework.stereotype.Component;

import fr.esgi.fx.avis.factory.EditeurFactory;
import fr.esgi.fx.avis.gateway.EditeurDbGateway;
import fr.esgi.fx.avis.model.Editeur;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EditeurUseCases {

    EditeurFactory editeurFactory;
    EditeurDbGateway editeurDbGateway;

    public void createEditeur(String name) {
        Editeur editeur = editeurFactory.createEditeur(name);
        editeurDbGateway.createEditeur(editeur);
    }
}
