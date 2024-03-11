package fr.esgi.fx.avis.business;

import java.util.List;

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
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class ModeleEconomique {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modele_economique_sequence")
    @SequenceGenerator(name="modele_economique_sequence")
    private Long id;
    
    @NonNull
    private String nom;
    
	@OneToMany(mappedBy="modeleEconomique")
	private List<Jeu> jeux;
	
}