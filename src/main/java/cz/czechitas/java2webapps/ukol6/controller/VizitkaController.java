package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.service.VizitkaService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class VizitkaController {
    private final VizitkaService service;
    public VizitkaController(VizitkaService service) {
        this.service = service;
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
        //ModelAndView result = new ModelAndView("vizitka");
        //result.addObject("vizitka", service.getById(id));
        Vizitka vizitka = service.getById(id);
        if (vizitka==null) {
           // return ResponseEntity.notFound().build();
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("vizitka").addObject("vizitka", vizitka);
    }
}
