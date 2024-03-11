package fr.esgi.fx.avis.business;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Genre {
	
	@Id
	@GeneratedValue
	private Long id;
	 
	@NonNull
	@NotBlank(message="Merci de préciser le nom du genre")
	private String nom;
	
	@OneToMany(mappedBy="genre")
	@ToString.Exclude
	private List<Jeu> jeux;
	
}