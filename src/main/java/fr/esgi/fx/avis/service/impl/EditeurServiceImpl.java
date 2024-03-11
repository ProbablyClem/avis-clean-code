package fr.esgi.fx.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.esgi.fx.avis.business.Editeur;
import fr.esgi.fx.avis.exception.EditeurDejaPresentException;
import fr.esgi.fx.avis.repository.EditeurRepository;
import fr.esgi.fx.avis.service.EditeurService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class EditeurServiceImpl implements EditeurService {

	private final EditeurRepository editeurRepository;
	
	@Override
	public Editeur ajouterEditeur(Editeur editeur) {
		if (recupererEditeurParNom(editeur.getNom())!=null) {
			throw new EditeurDejaPresentException("Cet éditeur est déjà présent");
		}
		return editeurRepository.save(editeur);
	}

	@Override
	public List<Editeur> recupererEditeurs() {
		return editeurRepository.findAll();
	}

	@Override
	public Editeur recupererEditeurParNom(String nom) {
		return editeurRepository.findByNom(nom);
	}

	@Override
	public Editeur recupererEditeur(long id) {
		return editeurRepository.findById(id).orElse(null);
	}

	@Override
	public boolean supprimerEditeur(long id) {
		return false;
	}

	@Override
	public List<Editeur> recupererEditeursParNomContenant(String nom) {
		return editeurRepository.findByNomContainingIgnoreCase(nom);
	}

	@Override
	public void supprimerEditeurs() {
		editeurRepository.deleteAll();
	}

}
