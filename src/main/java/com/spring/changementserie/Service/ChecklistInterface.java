package com.spring.changementserie.Service;

import com.spring.changementserie.Models.ChangementSerie;
import com.spring.changementserie.Models.Checklist;
import com.spring.changementserie.Models.Produit;

import java.util.List;
import java.util.Optional;

public interface ChecklistInterface {
    public Checklist createChecklist(Checklist checklist);
    void deleteChecklist(Integer idChecklist);
    public List<Checklist> getAllChecklist();
    public Checklist updateChecklist(Checklist checklist,Integer idChecklist);
    public Optional<Checklist> getidChecklistById(Integer idChangementSerie);
}
