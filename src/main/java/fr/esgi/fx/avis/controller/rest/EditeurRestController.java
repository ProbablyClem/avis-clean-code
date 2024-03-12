package fr.esgi.fx.avis.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.esgi.fx.avis.exception.EditeurDejaPresentException;
import fr.esgi.fx.avis.model.Editeur;
import fr.esgi.fx.avis.usecases.EditeurUseCases;
import fr.esgi.fx.avis.util.ReponseApi;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/editeurs")
@AllArgsConstructor
@Validated
public class EditeurRestController {

    private final EditeurUseCases editeurUseCases;

    @PostMapping("/{nom}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Editeur postEditeur(@PathVariable String nom) {
        return editeurUseCases.createEditeur(nom);
    }

    // // Si qq1 se rend sur l'URL http://localhost:8080/editeurs
    // // la méthode ci-dessous sera invoquée
    // @GetMapping("")
    // public List<EditeurEntity> getEditeurs() {
    // return editeurService.recupererEditeurs();
    // }

    @ExceptionHandler(EditeurDejaPresentException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    private ReponseApi<String> traiterEditeurDejaPresentException(Exception e) {
        return new ReponseApi<String>("", e.getMessage(), null);
    }
}
