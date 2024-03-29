package com.spring.changementserie.Service;

import com.spring.changementserie.Models.DemandeChangement;
import com.spring.changementserie.Models.Famille;

import java.util.List;
import java.util.Optional;

public interface DemandeChangementInterface {
    void deleteDemandeChangement(Integer idDemandeChangement);
    public DemandeChangement createDemandeChangement(DemandeChangement DemandeChangement);
    public List<DemandeChangement> getAllDemandeChangement();
    public Optional<DemandeChangement> getDemandeChangementByid(Integer idDemandeChangement);
    public DemandeChangement updateDemandeChangement(DemandeChangement DemandeChangement, Integer idFamille);
}
