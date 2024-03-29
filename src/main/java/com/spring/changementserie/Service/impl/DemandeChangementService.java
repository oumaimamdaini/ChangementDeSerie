package com.spring.changementserie.Service.impl;

import com.spring.changementserie.Models.DemandeChangement;
import com.spring.changementserie.Models.DemandeChangement;
import com.spring.changementserie.Repository.DemandeChangementRepository;
import com.spring.changementserie.Service.DemandeChangementInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DemandeChangementService implements DemandeChangementInterface {
    @Autowired
    private DemandeChangementRepository demandeChangementRepository;

    @Override
    public void deleteDemandeChangement(Integer idDemandeChangement) {
        demandeChangementRepository.deleteById(idDemandeChangement);
    }

    @Override
    public DemandeChangement createDemandeChangement(DemandeChangement DemandeChangement) {
        return demandeChangementRepository.save(DemandeChangement);
    }

    @Override
    public List<DemandeChangement> getAllDemandeChangement() {
        return demandeChangementRepository.findAll();
    }

    @Override
    public Optional<DemandeChangement> getDemandeChangementByid(Integer idDemandeChangement) {
        return demandeChangementRepository.findById(idDemandeChangement);
    }

    @Override
    public DemandeChangement updateDemandeChangement(DemandeChangement updatedDemandeChangement, Integer idDemandeChangement) {
        Optional<DemandeChangement> optionalDemandeChangement = demandeChangementRepository.findById(idDemandeChangement);

        if (optionalDemandeChangement.isPresent()) {
            DemandeChangement existingDemandeChangement = optionalDemandeChangement.get();

            if (updatedDemandeChangement.getDescDemandeChangement() != null) {
                existingDemandeChangement.setDescDemandeChangement(updatedDemandeChangement.getDescDemandeChangement());
            }

            return demandeChangementRepository.save(existingDemandeChangement);
        }

        return null;
    }

}
