package com.spring.changementserie.Controller;

import com.spring.changementserie.Models.ChangementSerie;
import com.spring.changementserie.Service.impl.ChangementSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/changementserie")
@PreAuthorize("hasRole('ADMIN') or hasRole('technicienPrep') or hasRole('technicienCur') or hasRole('responsableMéthode') " +
        "or hasRole('chefSecteurCur')")
public class ChangementSerieController {
    @Autowired
    private ChangementSerieService changementSerieService;

    @PostMapping(path="/createChangementSerie")
    @PreAuthorize("hasAuthority('admin:create') or hasAuthority('technicienPrep:create') or hasAuthority('technicienCur:create')" +
            "or hasAuthority('chefSecteurCur:create') or hasAuthority('responsableMéthode:create') ")
    public ResponseEntity<ChangementSerie> createChangementSerie(@RequestBody ChangementSerie changementserie) {
        ChangementSerie createdChangementSerie = changementSerieService.createChangementSerie(changementserie);
        return ResponseEntity.ok(createdChangementSerie);
    }

    @DeleteMapping(path="/deleteChangementSerie/{idChangementSerie}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteChangementSerie(@PathVariable Integer idChangementSerie) {
        changementSerieService.deleteChangementSerie(idChangementSerie);
    }
    @GetMapping(path="/getChangementSerieById/{idChangementSerie}")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )

    public Optional<ChangementSerie> getChangementSerieById(@PathVariable("idChangementSerie") Integer idChangementSerie ) {
        return changementSerieService.getChangementSerieById(idChangementSerie);
    }

    @GetMapping(path="/getChangementSerie")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )

    public List<ChangementSerie> getAllChangementSerie() {
        return changementSerieService.getAllChangementSerie();
    }

    @PutMapping(path = "/updateChangementSerie/{idChangementSerie}")
    @PreAuthorize("hasAuthority('admin:update') ")
    public ChangementSerie updateChangementSerie(@RequestBody ChangementSerie changementSerie, @PathVariable Integer idChangementSerie){
        return changementSerieService.updateChangementSerie(changementSerie,idChangementSerie);
    }

}
