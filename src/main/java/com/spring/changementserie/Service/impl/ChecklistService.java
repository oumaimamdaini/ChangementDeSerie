package com.spring.changementserie.Service.impl;

import com.spring.changementserie.Models.ChangementSerie;
import com.spring.changementserie.Models.Checklist;
import com.spring.changementserie.Models.DemandeChangement;
import com.spring.changementserie.Models.Produit;
import com.spring.changementserie.Repository.ChecklistRepository;
import com.spring.changementserie.Service.ChecklistInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChecklistService implements ChecklistInterface {
    @Autowired
    public ChecklistRepository checklistRepository;
    @Override
    public Checklist createChecklist(Checklist checklist) {

        return checklistRepository.save(checklist);
    }

    @Override
    public void deleteChecklist(Integer idChecklist) {
        checklistRepository.deleteById(idChecklist);
    }

    @Override
    public List<Checklist> getAllChecklist() {
        return checklistRepository.findAll();
    }

    @Override
    public Checklist updateChecklist(Checklist checklist, Integer idChecklist) {
            Optional<Checklist> optionalChecklist = checklistRepository.findById(idChecklist);
            if (optionalChecklist.isPresent()) {
                Checklist existingChecklist = optionalChecklist.get();

                if (checklist.getTitre() != null) {
                    existingChecklist.setTitre(checklist.getTitre());
                }
                if (checklist.getOutillage() != null) {
                    existingChecklist.setOutillage(checklist.getOutillage());
                }

                if (checklist.getDate() != null) {
                    existingChecklist.setDate(checklist.getDate());
                }


                return checklistRepository.save(existingChecklist);}
        return null;
    }

    @Override
    public Optional<Checklist> getidChecklistById(Integer idChecklist) {
        return checklistRepository.findById(idChecklist);
    }

}
