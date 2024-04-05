package com.spring.changementserie.Controller;

import com.spring.changementserie.Models.Famille;
import com.spring.changementserie.Models.Rapport;
import com.spring.changementserie.Service.impl.FamilleService;
import com.spring.changementserie.Service.impl.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/rapport")
/*@PreAuthorize("hasRole('ADMIN') or hasRole('technicienPrep') or hasRole('technicienCur') or hasRole('responsableMéthode') " +
        "or hasRole('chefSecteurCur')")*/
public class RapportController {

    @Autowired
    private RapportService rapportservice;
    @PostMapping(path="/createRapport")
    /*@PreAuthorize("hasAuthority('admin:create') or hasAuthority('technicienPrep:create') or hasAuthority('technicienCur:create')" +
            "or hasAuthority('chefSecteurCur:create') or hasAuthority('responsableMéthode:create') ")*/
    public ResponseEntity<Rapport> createRapport(@RequestBody Rapport rapport)
    {   Rapport createdRapport = rapportservice.createRapport(rapport);
        return ResponseEntity.ok(createdRapport);
    }
    @GetMapping(path="/getRapportById/{idRapport}")
  /*  @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )
*/
    public Optional<Rapport> getRapportById(@PathVariable("idRapport") Integer idRapport ) {
        return rapportservice.getByid(idRapport);
    }
    @GetMapping(path="/getAllRapport")
    /*@PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )*/

    public List<Rapport> getAllRapport() {
        return rapportservice.getAllRapport();
    }
    @DeleteMapping(path="/deleteRapport/{idRapport}")
    //@PreAuthorize("hasAuthority('admin:delete')")
    public void deleteRapport(@PathVariable Integer idRapport){
        rapportservice.deleteRapport(idRapport);

    }
    @PutMapping(path = "/updateRapport/{idRapport}")
    //@PreAuthorize("hasAuthority('admin:update') ")
    public Rapport updateRapport(@RequestBody Rapport rapport,@PathVariable Integer idRapport){
        return rapportservice.updateRapport(rapport,idRapport);
    }
}
