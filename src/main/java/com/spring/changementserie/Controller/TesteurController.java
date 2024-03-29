package com.spring.changementserie.Controller;

import com.spring.changementserie.Models.Testeur;
import com.spring.changementserie.Service.impl.TesteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/testeur")
@PreAuthorize("hasRole('ADMIN') or hasRole('technicienPrep') or hasRole('technicienCur') or hasRole('responsableMéthode') " +
        "or hasRole('chefSecteurCur')")
public class TesteurController {
    @Autowired
    private TesteurService testeurService;
    @PostMapping(path="/createTesteur")
    @PreAuthorize("hasAuthority('admin:create') or hasAuthority('technicienPrep:create') or hasAuthority('technicienCur:create')" +
            "or hasAuthority('chefSecteurCur:create') or hasAuthority('responsableMéthode:create') ")
    public ResponseEntity<Testeur> createTesteur(@RequestBody Testeur testeur)
    {   Testeur createdtesteur = testeurService.createTesteur(testeur);
        return ResponseEntity.ok(createdtesteur);
    }
    @GetMapping(path="/getTesteurs")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )

    public List<Testeur> getAllTesteur() {
        return testeurService.getAllTesteur();
    }

    @GetMapping(path="/getTesteurById/{idTesteur}")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )

    public Optional<Testeur> getTesteurById(@PathVariable("idTesteur") Integer idTesteur ) {
        return testeurService.getTesteurByid(idTesteur);
    }
    @DeleteMapping(path="/deleteTesteur/{idTesteur}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteTesteur(@PathVariable Integer idTesteur){
        testeurService.deleteTesteur(idTesteur);

    }
    @PutMapping(path = "/updateTesteur/{idTesteur}")
    @PreAuthorize("hasAuthority('admin:update') ")
    public Testeur updateTesteur(@RequestBody Testeur testeur,@PathVariable Integer idTesteur){
        return testeurService.updateTesteur(testeur,idTesteur);
    }
}
