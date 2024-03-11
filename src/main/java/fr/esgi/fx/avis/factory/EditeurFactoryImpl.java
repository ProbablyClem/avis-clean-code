package fr.esgi.fx.avis.factory;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import fr.esgi.fx.avis.model.Editeur;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EditeurFactoryImpl implements EditeurFactory {

    @Override
    public Editeur createEditeur(String name) {
        return new Editeur(name, LocalDate.now());
    }
}
