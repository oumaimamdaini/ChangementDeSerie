package com.spring.changementserie.Service.impl;

import com.spring.changementserie.Models.Famille;
import com.spring.changementserie.Models.Rapport;
import com.spring.changementserie.Repository.RapportRepository;
import com.spring.changementserie.Service.RapportInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RapportService implements RapportInterface {
    @Autowired
    private RapportRepository rapportRepository;

    @Override
    public Rapport createRapport(Rapport rapport) {
        return  rapportRepository.save(rapport);
    }

    @Override
    public Optional<Rapport> getByid(Integer idRapport) {
        return rapportRepository.findById(idRapport);
    }

    @Override
    public List<Rapport> getAllRapport() {
        return rapportRepository.findAll();
    }

    @Override
    public void deleteRapport(Integer idRapport) {
        rapportRepository.deleteById(idRapport);
    }

    @Override
    public Rapport updateRapport(Rapport updatedRapport, Integer idRapport) {
        Optional<Rapport> optionalRapport = rapportRepository.findById(idRapport);

        if (optionalRapport.isPresent()) {
            Rapport existingRapport = optionalRapport.get();

            if (updatedRapport.getDescRapport() != null) {
                existingRapport.setDescRapport(updatedRapport.getDescRapport());
            }

            return rapportRepository.save(existingRapport);
        }

        return null;
    }

}
