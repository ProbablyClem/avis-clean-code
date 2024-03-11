package fr.esgi.fx.avis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.esgi.fx.avis.business.ModeleEconomique;

public interface ModeleEconomiqueRepository extends JpaRepository<ModeleEconomique, Long> {

	ModeleEconomique findFirstByNomLike(String nom);

}
