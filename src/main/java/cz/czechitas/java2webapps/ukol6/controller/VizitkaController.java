package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import cz.czechitas.java2webapps.ukol6.service.VizitkaService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class VizitkaController {
    private final VizitkaService service;
    //private final VizitkaRepository vizitkaRepository;

    public VizitkaController(VizitkaService vizitkaService) {
        this.service = vizitkaService;
    }
    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView result = new ModelAndView("seznam");
        result.addObject("seznam", service.getAll());
        return result;
    }


    @GetMapping("/{id}")
        public ModelAndView vizitka(@PathVariable int id) {
        Vizitka vizitka = service.getById(id);
        if (vizitka == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("vizitka").addObject("vizitka", vizitka);
    }
    /*
    public ResponseEntity vizitka(@PathVariable int id) {
        Vizitka vizitka = service.getById(id);
        if (vizitka==null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(vizitka, HttpStatus.OK);
        }*/

        //@RequestMapping("/nova")

        @GetMapping("/nova")
        public ModelAndView novy() {
            ModelAndView modelAndView = new ModelAndView("formular");
            modelAndView.addObject("vizitka", new Vizitka());
            return modelAndView;
        }
    @PostMapping("/nova")
    public String pridat(@ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "formular";
        }
        //vizitka.setId(null);
        service.PridejVizitku(vizitka);
        return "redirect:/";
        /*service.PridejVizitku(vizitka);
        ModelAndView result = new ModelAndView("seznam");
        result.addObject("seznam", service.getAll());
        return "redirect:/";*/
    }
}
