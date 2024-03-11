// package fr.esgi.fx.avis.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.ModelAndView;

// import fr.esgi.fx.avis.entity.EditeurEntity;
// import fr.esgi.fx.avis.service.EditeurService;
// import jakarta.validation.Valid;
// import lombok.AllArgsConstructor;
// import lombok.extern.log4j.Log4j2;

// @Controller
// @AllArgsConstructor
// @Log4j2
// public class EditeurController {

// private final EditeurService editeurService;

// // Cette méthode sera invoquée lorsque qq1 se rend
// // http://localhost:8080/editeurs ou http://localhost:8080/index
// @GetMapping({ "editeurs", "index", "/" })
// public ModelAndView editeurs() {
// log.info("dans editeurs()");
// ModelAndView mav = new ModelAndView("editeurs");
// mav.addObject("editeurs", editeurService.recupererEditeurs());
// return mav;
// }

// @PostMapping({ "editeurs" })
// public ModelAndView editeursPost(@RequestParam("NOM") String nom) {

// ModelAndView mav = new ModelAndView("editeurs");
// mav.addObject("editeurs",
// editeurService.recupererEditeursParNomContenant(nom));
// mav.addObject("nom", nom);

// return mav;
// }

// /**
// * Cette méthode traite la requête HTTP qui demande à accéder au formulaire
// HTML
// * d'ajout d'un éditeur
// *
// * @return
// */
// @GetMapping({ "editeur" })
// public ModelAndView editeurGet() {
// ModelAndView mav = new ModelAndView();
// // On fait appel à la vue (aka template) nommée editeur.html
// mav.setViewName("editeur");
// // On injecte un nouvel éditeur sur le formulaire HTML de cette vue
// // on doit pour ce faire instancier un nouvel objet
// mav.addObject("editeur", new EditeurEntity());

// return mav;
// }

// @PostMapping({ "editeur" })
// public ModelAndView editeurPost(@Valid @ModelAttribute EditeurEntity editeur,
// BindingResult result) {
// if (result.hasErrors()) {
// ModelAndView mav = editeurGet();
// // On ne veut pas que l'internaute resaisisse toutes les informations
// // Les informations déjà saisies vont apparaître sur le formulaire HTML
// mav.addObject("editeur", editeur);
// return mav;
// }
// // Il n'y pas eu d'erreur de validation, on ajoute l'éditeur en base
// // en faisant appel au service editeurService puis on redirige vers la liste
// // des éditeurs
// editeurService.ajouterEditeur(editeur);
// // return editeurs();
// // La redirection va invoquer la méthode editeurs() et mettre à jour
// // ce qui apparait dans la barre d'adresse de l'internaute
// return new ModelAndView("redirect:editeurs");
// }

// }