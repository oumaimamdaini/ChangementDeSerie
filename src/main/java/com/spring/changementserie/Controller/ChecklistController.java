package com.spring.changementserie.Controller;

import com.spring.changementserie.Models.ChangementSerie;
import com.spring.changementserie.Models.Checklist;
import com.spring.changementserie.Service.impl.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/checklist")
@PreAuthorize("hasRole('ADMIN') or hasRole('technicienPrep') or hasRole('technicienCur') or hasRole('responsableMéthode') " +
        "or hasRole('chefSecteurCur')")
public class ChecklistController {
    @Autowired
    private ChecklistService checklistService;
    @PostMapping(path="/createChecklist")
    @PreAuthorize("hasAuthority('admin:create') or hasAuthority('technicienPrep:create') or hasAuthority('technicienCur:create')" +
                  "or hasAuthority('chefSecteurCur:create') or hasAuthority('responsableMéthode:create') ")

    public ResponseEntity<Checklist> createChecklist(@RequestBody Checklist checklist)
    {
        Checklist createdChecklist = checklistService.createChecklist(checklist);
        return ResponseEntity.ok(createdChecklist);
    }

    @DeleteMapping(path="/deleteChecklist/{idChecklist}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteChecklist(@PathVariable Integer idChecklist){
        checklistService.deleteChecklist(idChecklist);
    }

    @GetMapping(path="/getAllChecklist")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )

    public List<Checklist> getAllChecklist(){
        return checklistService.getAllChecklist();
    }

    @PutMapping(path = "/updateChecklist/{idChecklist}")
    @PreAuthorize("hasAuthority('admin:update') ")
    public Checklist updateChecklist(@RequestBody Checklist checklist, @PathVariable Integer idChecklist){
        return checklistService.updateChecklist(checklist,idChecklist);
    }

    @GetMapping(path="/getChecklistById/{idChecklist}")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )

    public Optional<Checklist> getChecklistById(@PathVariable("idChecklist") Integer idChecklist ) {
        return checklistService.getidChecklistById(idChecklist);
    }
}
