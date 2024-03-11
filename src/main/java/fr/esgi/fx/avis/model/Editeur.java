package fr.esgi.fx.avis.model;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Editeur {

	private Long id;

	@NonNull
	private String nom;

	@NonNull
	private LocalDate dateDeCreation;
}
