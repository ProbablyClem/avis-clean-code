package fr.esgi.fx.avis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.esgi.fx.avis.business.Classification;

public interface ClassificationRepository extends JpaRepository<Classification, Long> {

}
