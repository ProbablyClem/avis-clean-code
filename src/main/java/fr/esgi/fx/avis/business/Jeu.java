package fr.esgi.fx.avis.business;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(indexes = {@Index(name="idx_nom", columnList="nom", unique = false)}, uniqueConstraints = @UniqueConstraint(columnNames={"ID", "EDITEUR_ID"}))
@Data
@Builder
public class Jeu {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NonNull
	@NotBlank(message="Merci de préciser le nom du jeu")
	@Length(min=2)
	private String nom;
	
	@Lob
	private String description;

	@PastOrPresent(message = "La date de sortie doit être dans le passé ou aujourd'hui")
	private LocalDate dateSortie;
	
	private String image;

	@ToString.Exclude
	@OneToMany(mappedBy = "jeu", cascade = CascadeType.REMOVE)
	private List<Avis> avis;

	//@Size(min=2,message = "")
	//@NotEmpty(message="Merci de choisir au moins une plateforme")
	// Dès que Hibernate récupère un jeu, du fait du EAGER sur la liste des plateformes, Hibernate va
	// également immédiatement récupérer les plateformes du jeu et les placer dans la liste des plateformes
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Plateforme> plateformes;

	@ManyToOne
	private Genre genre;

	@ManyToOne
	@NonNull
	//@NotNull(message="Il est nécessaire de sélectionner un éditeur")
	private Editeur editeur;

	@ManyToOne
	private Classification classification;

	@ManyToOne
	private ModeleEconomique modeleEconomique;
	
	@ManyToOne
	private Moderateur moderateur;
	
	public Jeu(String nom) {
		super();
		this.nom = nom;
	}

	public Jeu(String nom, LocalDate dateSortie, Editeur editeur) {
		this(nom, editeur);
		this.dateSortie = dateSortie;
	}
	
	public Jeu(String nom, String description, LocalDate dateSortie, Editeur editeur) {
		this(nom, dateSortie, editeur);
		this.description = description;
	}

	public Jeu(String nom, LocalDate dateSortie, Editeur editeur, Genre genre) {
		this(nom, null, dateSortie, editeur);
		this.genre = genre;
	}

}
