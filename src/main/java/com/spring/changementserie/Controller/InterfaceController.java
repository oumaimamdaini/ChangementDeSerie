package com.spring.changementserie.Controller;


import com.spring.changementserie.Models.Interface;
import com.spring.changementserie.Service.impl.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/interface")
@PreAuthorize("hasRole('ADMIN') or hasRole('technicienPrep') or hasRole('technicienCur') or hasRole('responsableMéthode') " +
        "or hasRole('chefSecteurCur')")
public class InterfaceController {
    @Autowired
    private InterfaceService interfaceService;
    @PostMapping(path="/createInterface")
    @PreAuthorize("hasAuthority('admin:create') or hasAuthority('technicienPrep:create') or hasAuthority('technicienCur:create')" +
            "or hasAuthority('chefSecteurCur:create') or hasAuthority('responsableMéthode:create') ")
    public ResponseEntity<Interface> createInterface(@RequestBody Interface interfaceObj)
    {   Interface createdInterface = interfaceService.createInterface(interfaceObj);
        return ResponseEntity.ok(createdInterface);
    }
    @DeleteMapping(path="/deleteInterface/{idInterface}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteInterface(@PathVariable Integer idInterface){
        interfaceService.deleteInterface(idInterface);
    }
    @GetMapping(path="/getAllInterface")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )

    public List<Interface> getAllInterface(){

        return interfaceService.getAllInterface();
    }
    @PutMapping(path = "/updateInterface/{idInterface}")
    @PreAuthorize("hasAuthority('admin:update') ")
    public Interface updateInterface(@RequestBody Interface interfaceObj, @PathVariable Integer idInterface){
        return interfaceService.updateInterface(interfaceObj,idInterface);
    }
    @GetMapping(path="/getInterfaceById/{idInterface}")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            "or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )

    public Optional<Interface> getInterfaceById(@PathVariable("idInterface") Integer idInterface ) {
        return interfaceService.getCInterfaceById(idInterface);
    }


}
