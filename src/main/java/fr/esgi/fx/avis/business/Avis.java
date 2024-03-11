package fr.esgi.fx.avis.business;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Avis {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Lob
	@NotEmpty(message="Merci de rédiger une description pour votre avis")
	@Size(min=5, message="Votre description doit contenir au moins {min} caractères")
	private String description;
	
	@Range(min=0, max=20, message="La note doit être comprise entre {min} et {max}")
	private float note;
	
	private LocalDateTime dateModeration;
	
	@Column(updatable=false)
	private LocalDateTime dateEnvoi = LocalDateTime.now();
	
	@ManyToOne
	@NonNull
	@NotNull(message="Merci d'indiquer le jeu relatif à votre avis")
	private Jeu jeu;
	
	// On fait référence au joueur qui a rédigé l'avis
	@ManyToOne
	@NonNull
	@NotNull(message="Nous avons besoin de savoir quel joueur a rédigé cet avis")
	private Joueur joueur;
	
	@ManyToOne
	private Moderateur moderateur;
	
}