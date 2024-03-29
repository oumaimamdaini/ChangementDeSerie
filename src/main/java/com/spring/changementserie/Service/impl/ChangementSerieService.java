package com.spring.changementserie.Service.impl;

import com.spring.changementserie.Models.ChangementSerie;
import com.spring.changementserie.Models.User;
import com.spring.changementserie.Repository.ChangementSerieRepository;
import com.spring.changementserie.Service.ChangementSerieInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ChangementSerieService implements ChangementSerieInterface {
    @Autowired
    private ChangementSerieRepository changementSerieRepository;
    @Override
    public ChangementSerie createChangementSerie(ChangementSerie changementSerie){
        return changementSerieRepository.save(changementSerie);
    }

    @Override
    public void deleteChangementSerie(Integer idChangementSerie) {
        changementSerieRepository.deleteById(idChangementSerie);
    }

    @Override
    public Optional<ChangementSerie> getChangementSerieById(Integer idChangementSerie) {
        return changementSerieRepository.findById(idChangementSerie);
    }

    @Override
    public List<ChangementSerie> getAllChangementSerie() {
        return changementSerieRepository.findAll();
    }

    @Override
    public ChangementSerie updateChangementSerie(ChangementSerie changementSerie, Integer idChangementSerie) {
        Optional<ChangementSerie> optionalChangementSerie = changementSerieRepository.findById(idChangementSerie);

        if (optionalChangementSerie.isPresent()) {
            ChangementSerie existingChangement = optionalChangementSerie.get();


            if (changementSerie.getDescription() != null) {
                existingChangement.setDescription(changementSerie.getDescription());
            }

            if (changementSerie.getDateChangement() != null) {
                existingChangement.setDateChangement(changementSerie.getDateChangement());
            }

            return changementSerieRepository.save(existingChangement);
        }
        return null;
    }

}
