package fr.esgi.fx.avis.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.esgi.fx.avis.business.Avis;
import fr.esgi.fx.avis.business.Joueur;

public interface AvisRepository extends JpaRepository<Avis, Long> {
	
	List<Avis> findByJoueur(Joueur joueur);
	
	List<Avis> findByJoueurAndDateEnvoiBetween(Joueur joueur, LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin);
	
	List<Avis> findByJeuNomAndDateEnvoiBetween(String nomJeu, LocalDateTime dateMin, LocalDateTime dateMax);
	
	Avis findLastByJoueur(Joueur joueur);
	
	Avis findLastByJoueurPseudo(String pseudo);

	// l'avis le plus récent du joueur dont le pseudo est donné en paramètre
	Optional<Avis> findFirstByJoueurPseudoOrderByDateEnvoiDesc(String pseudo);
	
}