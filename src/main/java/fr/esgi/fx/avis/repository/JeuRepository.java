package fr.esgi.fx.avis.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fr.esgi.fx.avis.business.Editeur;
import fr.esgi.fx.avis.business.Genre;
import fr.esgi.fx.avis.business.Jeu;

public interface JeuRepository extends JpaRepository<Jeu, Long> {

	// Requête par dérivation (query method)
	Jeu findFirstById(Long id);

	Jeu findFirstByNom(String nom);

	List<Jeu> findByEditeur(Editeur editeur);

	List<Jeu> findByEditeurNom(String nom);

	List<Jeu> findByEditeurAndGenre(Editeur editeur, Genre genre);

	List<Jeu> findByEditeurAndGenreAndClassificationNom(Editeur editeur, Genre genre, String nom);
	
	List<Jeu> findByGenre(Genre genre);

	List<Jeu> findByGenreNom(String nom);
	
	List<Jeu> findByNomLike(String nom);

	List<Jeu> findByNomLikeAndDateSortieBetween(String nom, LocalDate dateDebut, LocalDate dateFin);

	List<Jeu> findByEditeurAndNomLikeAndDateSortieBetween(Editeur editeur, String nom, Date dateDebut, Date dateFin);

	@Override
	Page<Jeu> findAll(Pageable pageable);
	
	Page<Jeu> findByGenreId(Long idGenre, Pageable pageable);

	//Page<Jeu> findByGenre(Genre genre, Pageable pageable);
	
	@Query("FROM Jeu WHERE dateSortie BETWEEN ?1 AND ?2")
	List<Jeu> findByDateSortieBetweenAndSort(LocalDate dateDebut, LocalDate dateFin, Sort sort);
	
	@Query("FROM Jeu WHERE dateSortie BETWEEN :dateDebut AND :dateFin")
	List<Jeu> findByDateSortieBetweenHQL(@Param("dateDebut") LocalDate dateDebut, @Param("dateFin") LocalDate dateFin);
	
	boolean existsByNom(String nom);
	
	@Transactional
    @Modifying
    @Query("UPDATE Jeu j SET j.nom = upper(j.nom) WHERE j.nom is not null")
    void updateNomByNomNotNull();

	@Transactional
	long deleteByEditeur(Editeur editeur);
	
	@Transactional
	long deleteByEditeurNomStartingWith(String debut);
	
	@Transactional
    @Modifying
    @Query(value= "DELETE FROM Jeu WHERE editeur_id = :id", nativeQuery = true)
    void supprimerJeuxByEditeurId(Long id);

	List<Jeu> findByDateSortieBetween(LocalDate dateDebut, LocalDate dateFin);
	
	@Query("FROM Jeu ORDER BY rand()")
	List<Jeu> findGamesRandomlySorted();
}