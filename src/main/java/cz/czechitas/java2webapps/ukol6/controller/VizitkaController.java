package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.service.VizitkaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VizitkaController {
    private final VizitkaService service;
    public VizitkaController(VizitkaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView result = new ModelAndView("seznam");
        result.addObject("seznam", service.getAll());
        return result;
    }


    @GetMapping("/vizitka/{id}")
    public ModelAndView vizitka(@PathVariable int id) {
        ModelAndView result = new ModelAndView("vizitka");
        result.addObject("vizitka", service.getById(id));
        return result;
    }
}
