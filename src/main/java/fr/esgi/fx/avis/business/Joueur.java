package fr.esgi.fx.avis.business;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Joueur extends Utilisateur {
	
	@DateTimeFormat(iso=ISO.DATE)
	@Past(message = "Merci d'indiquer une date dans le passé")
	private LocalDate dateDeNaissance;
	
	@OneToMany(mappedBy="joueur")
	private List<Avis> avis;
}