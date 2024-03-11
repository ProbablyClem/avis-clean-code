package fr.esgi.fx.avis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.esgi.fx.avis.entity.EditeurEntity;

//@RepositoryRestResource
public interface EditeurRepository extends JpaRepository<EditeurEntity, Long> {

}
