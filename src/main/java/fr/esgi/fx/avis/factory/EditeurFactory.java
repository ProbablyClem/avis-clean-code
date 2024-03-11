package fr.esgi.fx.avis.factory;

import fr.esgi.fx.avis.model.Editeur;

public interface EditeurFactory {
    Editeur createEditeur(String name);
}
