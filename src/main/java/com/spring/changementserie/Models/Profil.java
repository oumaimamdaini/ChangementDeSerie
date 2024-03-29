package com.spring.changementserie.Models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.spring.changementserie.Models.Permission.*;

@RequiredArgsConstructor
public enum Profil {
    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                  ADMIN_DELETE,
                    ADMIN_CREATE,
                    ADMIN_UPDATE,
                    ADMIN_READ,
                    technicienCur_CREATE,
                    technicienCur_READ,
                    technicienPrep_CREATE,
                    technicienPrep_READ,
                    responsableMéthode_CREATE,
                    responsableMéthode_READ,
                    chefSecteurCur_CREATE,
                    chefSecteurCur_READ,
                    technicienPrev_CREATE,
                    technicienPrev_READ


            )
    ),
    technicienPrep(
            Set.of(
                    technicienPrep_CREATE,

                    technicienPrep_READ
        )),
    technicienCur(
            Set.of(
                    technicienCur_CREATE,

                    technicienCur_READ
            )),
    technicienPrev(
            Set.of(
                    technicienPrev_CREATE,
                    technicienPrev_READ

            )
    ),
    responsableMéthode(
            Set.of(
                    responsableMéthode_CREATE,
                    responsableMéthode_READ
            )
    ),
    chefSecteurCur(
            Set.of(
                    chefSecteurCur_CREATE,
                    chefSecteurCur_READ
            )
    );
    @Getter
    private final Set<Permission> permissions;
    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }

}
