package fr.esgi.fx.avis.factory;

import java.time.LocalDate;

import fr.esgi.fx.avis.model.Editeur;

public class EditeurFactoryImpl implements EditeurFactory {

    @Override
    public Editeur createEditeur(String name) {
        return new Editeur(name, LocalDate.now());
    }
}
