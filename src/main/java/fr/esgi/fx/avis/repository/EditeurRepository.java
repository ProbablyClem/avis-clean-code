package fr.esgi.fx.avis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.esgi.fx.avis.business.Editeur;

//@RepositoryRestResource
public interface EditeurRepository extends JpaRepository<Editeur, Long> {

	// Requête par dérivation
	List<Editeur> findByNomLike(String nom);

	Editeur findFirstByNomLike(String nom);

	Editeur findByNom(String nom);

	// Navigabilité : j.genre.nom (de la classe Jeu on navigue vers la classe Genre et on s'intéresse à son attribut nom
	@Query("SELECT DISTINCT j.editeur FROM Jeu j WHERE j.genre.nom LIKE :nom%")
	List<Editeur> findDistinctByJeuGenreNomStartingWith(String nom);

	@Query("FROM Editeur WHERE nom LIKE 'B%'")
	List<Editeur> findByNomStartingWithB();

	// La fonction size nous oblige à utilise un alias sur la classe Editeur
	@Query("FROM Editeur e WHERE size(e.jeux)=0")
	List<Editeur> findEditorsWithoutGames();

	@Query("FROM Editeur e JOIN FETCH e.jeux WHERE size(e.jeux)>0")
	List<Editeur> findEditorsWithGames();
	
	Editeur findFirstByNom(String nom);

	// Methode qui renvoit les 2 premiers editeurs dont le nom début par ce qui est
	// donné en paramètre
	List<Editeur> findFirst2ByNomStartingWith(String nom);

	List<Editeur> findFirst2ByNomStartingWithOrderByNom(String nom);

	List<Editeur> findByNomContainingIgnoreCase(String nom);
}
