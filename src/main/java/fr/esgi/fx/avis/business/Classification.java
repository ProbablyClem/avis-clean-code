package fr.esgi.fx.avis.business;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Classification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLASSIFICATION_SEQUENCE")
	@SequenceGenerator(name = "CLASSIFICATION_SEQUENCE")
	private Long id;
	
	@Column(length = 85)
	@NonNull
	private String nom;
	
	@OneToMany(mappedBy="classification")
	private List<Jeu> jeux;
}