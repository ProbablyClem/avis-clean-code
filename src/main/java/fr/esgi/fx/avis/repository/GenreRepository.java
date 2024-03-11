package fr.esgi.fx.avis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.esgi.fx.avis.business.Genre;

public interface GenreRepository extends JpaRepository<Genre, String> {

	List<Genre> findByNomLike(String nom);

	Genre findFirstByNomLike(String nom);

	Genre findByNom(String nom);

}
