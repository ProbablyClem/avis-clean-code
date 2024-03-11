package fr.esgi.fx.avis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.esgi.fx.avis.business.Moderateur;

public interface ModerateurRepository extends JpaRepository<Moderateur, Long> {

}
