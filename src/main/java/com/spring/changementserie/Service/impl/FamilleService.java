package com.spring.changementserie.Service.impl;

import com.spring.changementserie.Models.Famille;
import com.spring.changementserie.Repository.FamilleRepository;
import com.spring.changementserie.Service.FamilleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilleService implements FamilleInterface {

    @Autowired
    private FamilleRepository familleRepository;
    @Override
    public List<Famille> getAllFamille() {
        return familleRepository.findAll();
    }

    @Override
    public Famille updateFamille(Famille updatedFamille, Integer idFamille) {
        Optional<Famille> optionalFamille = familleRepository.findById(idFamille);

        if (optionalFamille.isPresent()) {
            Famille existingFamille = optionalFamille.get();

            if (updatedFamille.getNomFamille() != null) {
                existingFamille.setNomFamille(updatedFamille.getNomFamille());
            }
            return familleRepository.save(existingFamille);
        }

        return null;
    }


    @Override
    public Optional<Famille> getFamilleById(Integer idFamille) {
        return familleRepository.findById(idFamille);
    }


    @Override
    public void deleteFamille(Integer idFamille) {
        familleRepository.deleteById(idFamille);
    }
@Override
    public Famille createFamille(Famille famille){
        return  familleRepository.save(famille);
    }


}
