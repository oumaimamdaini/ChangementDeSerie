package com.spring.changementserie.Controller;
import com.spring.changementserie.Models.Checklist;
import com.spring.changementserie.Models.Produit;
import com.spring.changementserie.Service.impl.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/produit")
/*@PreAuthorize("hasRole('ADMIN') or hasRole('technicienPrep') or hasRole('technicienCur') or hasRole('responsableMéthode') " +
        "or hasRole('chefSecteurCur')")*/
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    private ChecklistController checklistService;
    @PostMapping(path="/createProduit")
    /*@PreAuthorize("hasAuthority('admin:create') or hasAuthority('technicienPrep:create') or hasAuthority('technicienCur:create')" +
            "or hasAuthority('chefSecteurCur:create') or hasAuthority('responsableMéthode:create') ")*/
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit)

    {

      Produit createdProduit = produitService.createProduit(produit);
        return ResponseEntity.ok(createdProduit);
    }
    @GetMapping(path = "/getAllProduit/{idChecklist}")
    /*@PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )*/
    public List<Produit> getAllProduit(@PathVariable Integer idChecklist){
        return produitService.getAllProduit(idChecklist);
    }
    @DeleteMapping(path="/deleteProduit/{idProduit}")
   // @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteProduit(@PathVariable Integer idProduit){
        produitService.deleteProduit(idProduit);

    }
    @GetMapping(path="/getProduitById/{idProduit}")
   /* @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )*/

    public Optional<Produit> getProduitById(@PathVariable("idProduit") Integer idProduit ) {
        return produitService.getProduitById(idProduit);
    }
    @PutMapping(path = "/updateProduit/{idProduit}")
    //@PreAuthorize("hasAuthority('admin:update') ")
    public Produit updateProduit(@RequestBody Produit produit, @PathVariable Integer idProduit){
        return produitService.updateProduit(produit,idProduit);
    }

}
