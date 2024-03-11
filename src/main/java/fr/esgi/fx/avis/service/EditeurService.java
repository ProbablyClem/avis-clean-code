package fr.esgi.fx.avis.service;

import java.util.List;

import fr.esgi.fx.avis.business.Editeur;

public interface EditeurService {

	Editeur ajouterEditeur(Editeur editeur);

	List<Editeur> recupererEditeurs();

	Editeur recupererEditeur(long id);
	Editeur recupererEditeurParNom(String nom);

	boolean supprimerEditeur(long id);

	List<Editeur> recupererEditeursParNomContenant(String nom);

	void supprimerEditeurs();

}
