package fr.esgi.fx.avis.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.esgi.fx.avis.model.Editeur;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class EditeurEntity {

	public EditeurEntity(Editeur editeur) {
		this.nom = editeur.getNom();
		this.dateDeCreation = editeur.getDateDeCreation();
	}

	@Id
	// On demande à H2 de choisir un id pour chaque éditeur
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "editeur_seq")
	@SequenceGenerator(name = "editeur_seq", initialValue = 1)
	private Long id;

	@NonNull
	@NotBlank(message = "Merci de renseigner le nom de l'éditeur")
	@Column(unique = true, nullable = false, updatable = true)
	@Size(min = 2, message = "Le nom de l'éditeur doit comporter au moins {min} caractères")
	private String nom;

	private LocalDate dateDeCreation;
}