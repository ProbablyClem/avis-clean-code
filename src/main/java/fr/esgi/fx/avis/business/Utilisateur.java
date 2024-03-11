package fr.esgi.fx.avis.business;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilisateur_sequence")
    @SequenceGenerator(name = "utilisateur_sequence")
    protected Long id;

    protected String pseudo;

    protected String motDePasse;

    @Column(unique = true)
    protected String email;
}