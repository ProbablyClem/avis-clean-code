package fr.esgi.fx.avis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.esgi.fx.avis.business.Plateforme;

public interface PlateformeRepository extends JpaRepository<Plateforme, Long> {

	@Query("SELECT j.plateformes FROM Jeu j WHERE j.id = :jeuId")
	List<Plateforme> findByJeuId(Long jeuId);
	
	@Query("FROM Plateforme WHERE nom LIKE CONCAT('%', :filtre, '%')")
	List<Plateforme> findByNomContaining(@Param("filtre") String filtre);
	
	// Requête par dérivation
	// Query method
	List<Plateforme> findPlateformesByJeuxIsEmpty();
	
	List<Plateforme> findByJeuxIsEmpty();
	
	List<Plateforme> findByJeuxEmpty();
	
	List<Plateforme> findByOrderByJeuxDesc();
	
}
