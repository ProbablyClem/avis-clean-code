package fr.esgi.fx.avis.gateway;

import java.util.List;

import fr.esgi.fx.avis.model.Editeur;

public interface EditeurDbGateway {
    void saveEditeur(Editeur editeur);

    List<Editeur> recupererEditeurs();
}
