package com.spring.changementserie.Service.impl;

import com.spring.changementserie.Models.Testeur;
import com.spring.changementserie.Models.Testeur;
import com.spring.changementserie.Repository.TesteurRepository;
import com.spring.changementserie.Service.TesteurInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TesteurService implements TesteurInterface {
    @Autowired
    private TesteurRepository testeurRepository;
    @Override
    public void deleteTesteur(Integer idTesteur) {
      testeurRepository.deleteById(idTesteur);
    }

    @Override
    public Testeur createTesteur(Testeur testeur) {
        return testeurRepository.save(testeur);
    }

    @Override
    public List<Testeur> getAllTesteur() {
        return testeurRepository.findAll();
    }

    @Override
    public Testeur updateTesteur(Testeur updatedTesteur, Integer idTesteur) {
        Optional<Testeur> optionalTesteur = testeurRepository.findById(idTesteur);

        if (optionalTesteur.isPresent()) {
            Testeur existingTesteur = optionalTesteur.get();

            if (updatedTesteur.getNomTesteur() != null) {
                existingTesteur.setNomTesteur(updatedTesteur.getNomTesteur());
            }

            if (updatedTesteur.getQteTesteur() != null) {
                existingTesteur.setQteTesteur(updatedTesteur.getQteTesteur());
            }

            if (updatedTesteur.getUF() != null) {
                existingTesteur.setUF(updatedTesteur.getUF());
            }

            if (updatedTesteur.getLigneCMS2() != null) {
                existingTesteur.setLigneCMS2(updatedTesteur.getLigneCMS2());
            }

            if (updatedTesteur.getAtelier() != null) {
                existingTesteur.setAtelier(updatedTesteur.getAtelier());
            }

            return testeurRepository.save(existingTesteur);
        }

        return null;
    }


    @Override
    public Optional<Testeur> getTesteurByid(Integer idTesteur) {
        return testeurRepository.findById(idTesteur);
    }
}
