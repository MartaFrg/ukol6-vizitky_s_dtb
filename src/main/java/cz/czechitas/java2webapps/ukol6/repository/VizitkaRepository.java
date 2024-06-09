package cz.czechitas.java2webapps.ukol6.repository;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VizitkaRepository extends JpaRepository<Vizitka, Long> {
    Vizitka findVizitkaById(int id);
    List<Vizitka> findAll();

    //List<Vizitka> findAllByOrderByVizitkaIdAsc();
    //List<Vizitka>  findVizitkaById(int id);
}