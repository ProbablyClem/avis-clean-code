package fr.esgi.fx.avis.business;

import jakarta.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class Moderateur extends Utilisateur{
    private String numeroDeTelephone;

	public Moderateur(String pseudo, String motDePasse, String email, String numeroDeTelephone) {
		super.pseudo=pseudo;
		super.motDePasse=motDePasse;
		super.email=email;
		this.numeroDeTelephone = numeroDeTelephone;
	}
    
}