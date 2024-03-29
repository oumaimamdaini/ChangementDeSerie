package com.spring.changementserie.Service;

import com.spring.changementserie.Models.ChangementSerie;
import com.spring.changementserie.Models.Famille;
import com.spring.changementserie.Models.Produit;

import java.util.List;
import java.util.Optional;

public interface ChangementSerieInterface {

    public ChangementSerie createChangementSerie(ChangementSerie changementSerie);
     void deleteChangementSerie(Integer idChangementSerie);
    public Optional<ChangementSerie> getChangementSerieById(Integer idChangementSerie);

    public List<ChangementSerie> getAllChangementSerie();
    public ChangementSerie updateChangementSerie(ChangementSerie changementSerie,Integer idChangementSerie);


}
