package fr.esgi.fx.avis.business;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Plateforme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLATEFORME_SEQUENCE")
    @SequenceGenerator(name="PLATEFORME_SEQUENCE")
    private Long id;

    @Column(length = 85)
    @NonNull
    private String nom;
    
    @ToString.Exclude
	@ManyToMany(mappedBy="plateformes")
	private List<Jeu> jeux;
    
}