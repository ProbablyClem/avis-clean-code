package fr.esgi.fx.avis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.esgi.fx.avis.usecases.EditeurUseCases;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@AllArgsConstructor
@Log4j2
public class EditeurController {

    private final EditeurUseCases editeurUseCases;

    // Cette méthode sera invoquée lorsque qq1 se rend
    // http://localhost:8080/editeurs ou http://localhost:8080/index
    @GetMapping({ "editeurs", "index", "/" })
    public ModelAndView editeurs() {
        log.info("dans editeurs()");
        ModelAndView mav = new ModelAndView("editeurs");
        mav.addObject("editeurs", editeurUseCases.recupererEditeurs());
        return mav;
    }
}