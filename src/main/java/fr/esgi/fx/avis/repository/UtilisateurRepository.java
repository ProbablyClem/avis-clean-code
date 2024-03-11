package fr.esgi.fx.avis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.esgi.fx.avis.business.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	Utilisateur findByPseudoAndMotDePasse(String pseudo, String motDePasse);

}
