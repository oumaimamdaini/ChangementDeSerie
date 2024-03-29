package com.spring.changementserie.Controller;

import com.spring.changementserie.Models.Famille;
import com.spring.changementserie.Service.impl.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/famille")
@PreAuthorize("hasRole('ADMIN') or hasRole('technicienPrep') or hasRole('technicienCur') or hasRole('responsableMéthode') " +
        "or hasRole('chefSecteurCur')")
public class FamilleController {
    @Autowired
    private FamilleService familleService;

    @PostMapping(path="/create")
    @PreAuthorize("hasAuthority('admin:create') or hasAuthority('technicienPrep:create') or hasAuthority('technicienCur:create')" +
            "or hasAuthority('chefSecteurCur:create') or hasAuthority('responsableMéthode:create') ")
    public ResponseEntity<Famille> createFamille(@RequestBody Famille famille)
    {   Famille createdFamille = familleService.createFamille(famille);
        return ResponseEntity.ok(createdFamille);
    }
    @GetMapping(path="/getFamille")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )

    public List<Famille> getAllFamille() {
        return familleService.getAllFamille();
    }

    @GetMapping(path="/getFamilleById/{idFamille}")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )

    public Optional<Famille> getFamilleById(@PathVariable("idFamille") Integer idFamille ) {
        return familleService.getFamilleById(idFamille);
    }
    @DeleteMapping(path="/deleteFamille/{idFamille}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteFamille(@PathVariable Integer idFamille){
        familleService.deleteFamille(idFamille);

    }
    @PutMapping(path = "/updateFamille/{idFamille}")
    @PreAuthorize("hasAuthority('admin:update') ")
    public Famille updateFamille(@RequestBody Famille famille,@PathVariable Integer idFamille){
        return familleService.updateFamille(famille,idFamille);
    }

}
