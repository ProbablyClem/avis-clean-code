package fr.esgi.fx.avis.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.esgi.fx.avis.business.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

	// HQL : Hibernate Query Language (le langage de requête d'Hibernate)
	// JPQL : Jakarta Persistence Query Language (le langage de la specification Jakarta Persistence)
	@Query("FROM Joueur WHERE pseudo LIKE 'Ambre%'")
	List<Joueur> findByPseudoStartingWithAmbre();

	@Query(value="SELECT * FROM utilisateur WHERE DTYPE='Joueur' AND pseudo LIKE 'Ambre%'", nativeQuery = true)
	List<Joueur> findByPseudoStartingWithAmbreNativeQuerySingleTable();

	@Query("FROM Joueur WHERE year(dateDeNaissance)>=2000")
	List<Joueur> findByBirthDateIn2000OrOnwards();
	
	@Query("SELECT count(*) FROM Joueur where year(dateDeNaissance)>=2000")
	Long findNbOfGamersBornIn2000OrOnwards();
	
	@Query("""
			SELECT CONCAT(pseudo, ' ', day_of_month(dateDeNaissance), ' ', day(dateDeNaissance))
			FROM Joueur
			WHERE day_of_month(dateDeNaissance)=day_of_month(current_date())
			AND month(dateDeNaissance)=month(current_date())
			""")
	List<String> findGamersCelebratingTheirBirthdayDiff();
	
	@Query("FROM Joueur WHERE day_of_month(dateDeNaissance)=day_of_month(current_date()) " +
			"AND month(dateDeNaissance)=month(current_date())")
	List<Joueur> findGamersCelebratingTheirBirthday();
	
	@Query("FROM Joueur j WHERE j.pseudo=?1 AND j.motDePasse=?2")
	Joueur findByPseudoAndMotDePasse(String pseudo, String motDePasse);

	/**
	 * Page: réponse à une demande de page
	 * Pageable: demande de page
	 */
	Page<Joueur> findAll(Pageable pageable);
	
}
