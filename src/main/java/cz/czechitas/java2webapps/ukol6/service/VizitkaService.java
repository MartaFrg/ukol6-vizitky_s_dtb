package cz.czechitas.java2webapps.ukol6.service;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VizitkaService {
    //private final List<Vizitka> seznamVizitek = new ArrayList<>();
    private final VizitkaRepository vizitkaRepository;
    @Autowired
    public VizitkaService(VizitkaRepository vizitkaRepository) {
        this.vizitkaRepository = vizitkaRepository;
    }

    public List<Vizitka> getAll() {
        return vizitkaRepository.findAll();
    }

   public Vizitka getById(long id) {
        return vizitkaRepository.findById(id);
    }

    public void PridejVizitku(Vizitka vizitka) {
        vizitkaRepository.save(vizitka);
    }
    /*
    public void SmazVizitku(int id) {
        seznamVizitek.remove(id);
    }*/
}
