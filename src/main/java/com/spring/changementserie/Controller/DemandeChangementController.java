package com.spring.changementserie.Controller;

import com.spring.changementserie.Models.DemandeChangement;

import com.spring.changementserie.Service.impl.DemandeChangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/demandechangement")
@PreAuthorize("hasRole('ADMIN') or hasRole('technicienPrep') or hasRole('technicienCur') or hasRole('responsableMéthode') " +
        "or hasRole('chefSecteurCur')")
public class DemandeChangementController {
    @Autowired
    private DemandeChangementService demandeChangementService;
    @PostMapping(path="/createDemandeChangement")
    @PreAuthorize("hasAuthority('admin:create') or hasAuthority('technicienPrep:create') or hasAuthority('technicienCur:create')" +
            "or hasAuthority('chefSecteurCur:create') or hasAuthority('responsableMéthode:create') ")
    public ResponseEntity<DemandeChangement> createDemandeChangement(@RequestBody DemandeChangement demandeChangement) {
        DemandeChangement createdDemandeChangement = demandeChangementService.createDemandeChangement(demandeChangement);
        return ResponseEntity.ok(createdDemandeChangement);
    }

    @DeleteMapping(path="/deleteDemandeChangement/{idDemandeChangement}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteDemandeChangement(@PathVariable Integer idDemandeChangement) {
        demandeChangementService.deleteDemandeChangement(idDemandeChangement);
    }
    @GetMapping(path="/getDemandeChangementById/{idDemandeChangement}")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )

    public Optional<DemandeChangement> getDemandeChangementById(@PathVariable("idDemandeChangement") Integer idDemandeChangement ) {
        return demandeChangementService.getDemandeChangementByid(idDemandeChangement);
    }

    @GetMapping(path="/getDemandeChangement")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )

    public List<DemandeChangement> getAllDemandeChangement() {
        return demandeChangementService.getAllDemandeChangement();
    }
    @PutMapping(path = "/updateDemandeChangement/{idDemandeChangement}")
    @PreAuthorize("hasAuthority('admin:update') ")
    public DemandeChangement updateDemandeChangement(@RequestBody DemandeChangement demandeChangement, @PathVariable Integer idDemandeChangement){
        return demandeChangementService.updateDemandeChangement(demandeChangement,idDemandeChangement);
    }
}
