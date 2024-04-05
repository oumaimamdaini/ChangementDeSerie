package com.spring.changementserie.Controller;

import com.spring.changementserie.Models.User;
import com.spring.changementserie.Service.impl.UserImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")
/*@PreAuthorize("hasRole('ADMIN')or hasRole('technicienPrep') or hasRole('technicienCur') or hasRole('responsableMéthode') " +
           "or hasRole('chefSecteurCur') ")*/
public class UserController {

    @Autowired
    private UserImplService userImplService;
    @PostMapping(path="/createUser")
    //@PreAuthorize("hasAuthority('admin:create') ")
    public User createUser(@RequestBody User user) {

        return userImplService.createUser(user);
    }
    @PutMapping(path = "/update/{id}")
    //@PreAuthorize("hasAuthority('admin:update')")
    public User update(@RequestBody User user,@PathVariable Integer id){
        return userImplService.update(user, id);
    }
    @DeleteMapping(path="/deleteUser/{id}")
    //@PreAuthorize("hasAuthority('admin:delete')")
    public void deleteUser( @PathVariable Integer id){
        userImplService.deleteUser(id);
    }
    @GetMapping(path="/getUserById/{idUser}")
   //@PreAuthorize("hasAuthority('admin:read') ")

    public Optional<User> getUserById(@PathVariable("idUser") Integer idUser ) {
        return userImplService.getUserById(idUser);
    }

    @GetMapping(path="/getAllUsers")
   //@PreAuthorize("hasAuthority('admin:read') or hasAuthority('technicienPrep:read') or hasAuthority('technicienCur:read') " +
            //"or hasAuthority('chefSecteurCur:read') or hasAuthority('responsableMéthode:read') " )

    public List<User> getAllUsers() {

        return userImplService.getAllUsers();
    }

}