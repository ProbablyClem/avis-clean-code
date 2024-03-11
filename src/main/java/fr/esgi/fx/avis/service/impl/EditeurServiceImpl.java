package fr.esgi.fx.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.esgi.fx.avis.entity.EditeurEntity;
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
	public EditeurEntity ajouterEditeur(EditeurEntity editeur) {
		return editeurRepository.save(editeur);
	}
}
